package pl.sixfaces.home.homework_02;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component

@Profile("pro")
public class CartPro {

    @Value("${page-info.vat}")
    private int vat;

    @Value("${page-info.discount}")
    private double discountPercent;

    ServiceCart serviceCart;

    @Autowired()
    public CartPro(ServiceCart serviceCart) {
        this.serviceCart = serviceCart;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void ranStart() {
        int vatPrice = (serviceCart.priceAll * vat / 100 + serviceCart.priceAll);
        double discountVal = (serviceCart.priceAll * vat / 100 + serviceCart.priceAll) * (discountPercent / 100);
        double priceWithDiscount = vatPrice - discountVal;

        System.out.println("VAT is: " + vat + " %");
        System.out.println("all price is: " + vatPrice + " z vat $");

        System.out.println("discount: " + Math.round(discountVal * 100.0) / 100.0 + "$");
        System.out.println("discount percent: " + discountPercent + "%");
        System.out.println("all price with discount: " + priceWithDiscount + " z vat $");


    }


}
