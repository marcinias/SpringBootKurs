package pl.sixfaces.home.homework_02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Service
public class ServiceCart {



    List<Cart> cartList;
    protected int priceAll;
    private int PriceMin = 50;
    private int PriceMax = 300;

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



        System.out.println("all price is without vat: " + priceAll + "$");



    }


}
