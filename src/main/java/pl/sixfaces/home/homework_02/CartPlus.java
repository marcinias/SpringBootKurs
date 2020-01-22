package pl.sixfaces.home.homework_02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
@Data
@AllArgsConstructor
@NoArgsConstructor

@Profile("plus")
public class CartPlus {
    @Value("${page-info.vat}")
    private int vat;

    ServiceCart serviceCart;

    @Autowired()
    public CartPlus(ServiceCart serviceCart) {
        this.serviceCart = serviceCart;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void ranStart() {

        int vatPrice = serviceCart.priceAll * vat / 100 + serviceCart.priceAll;

        System.out.println("VAT is: " + vat + " %");
        System.out.println("all price is: " + vatPrice + " z vat $");

    }


}
