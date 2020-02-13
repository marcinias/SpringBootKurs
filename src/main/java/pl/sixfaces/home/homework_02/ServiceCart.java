package pl.sixfaces.home.homework_02;



import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ServiceCart {



    List<Cart> cartList;
    protected int priceAll;
    private int PriceMin = 30;
    private int PriceMax = 50;

    public int generatePrice() {
        return PriceMin + (int) (Math.random() * ((PriceMax - PriceMin) + 1));
    }

    //ContextRefreshedEvent zostanie wykonany nawet przed ApplicationReadyEvent
    @EventListener(ContextRefreshedEvent.class)
    public void ranStart() {

        cartList = new ArrayList<>();
        cartList.add(new Cart("rower", generatePrice()));
        cartList.add(new Cart("chleb", generatePrice()));
        cartList.add(new Cart("mleko", generatePrice()));
        cartList.add(new Cart("lcdTV", generatePrice()));
        cartList.add(new Cart("pendrive", generatePrice()));

        // list od cart
        for (Cart cart : cartList) {
            System.out.println(cart);

        }
        // add all prices
        for (Cart cart : cartList) {
            priceAll += cart.getPrice();

        }

        //--------
        String cos = "lcdTV";

        //List<Cart> collect = cartList.stream().filter(x -> x.getPrice() == cos).collect(Collectors.toList());
        // List<Cart> collect = cartList.stream().filter(x -> x.getItem().equals(cos)).collect(Collectors.toList());
        List<Cart> collect = cartList.stream().filter(x -> x.getPrice() > 40).collect(Collectors.toList()); ;
        System.out.println("filter: " + collect + "$");

        //----------------
        System.out.println("all price is without vat: " + priceAll + "$");


    }


}
