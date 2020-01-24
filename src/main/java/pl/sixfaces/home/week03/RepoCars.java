package pl.sixfaces.home.week03;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Repository
public class RepoCars {

    public List<Car> carList;

    @EventListener(ApplicationReadyEvent.class)
    public void ranStart() {

        carList = new ArrayList<>();
        carList.add(new Car(1, "Ford", "C-max", "red"));
        carList.add(new Car(2, "Honda", "Accord", "black"));
        carList.add(new Car(3, "Audi", "A1", "blue"));
        carList.add(new Car(4, "Ford", "S-max", "red"));
        carList.add(new Car(5, "Honda", "Jazz", "black"));
        carList.add(new Car(6, "Audi", "A8", "blue"));


    }

}
