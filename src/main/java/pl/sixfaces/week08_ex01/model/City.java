package pl.sixfaces.week08_ex01.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameCity;
    private String ico;
    private String error;
    private double temp;
    private String time;

    public City(String nameCity, String ico, String error, double temp, String time) {
        this.nameCity = nameCity;
        this.ico = ico;
        this.error = error;
        this.temp = temp;
        this.time = time;
    }

}
