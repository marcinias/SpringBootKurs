package pl.sixfaces.home_week_05.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {

    private String nameCity;
    private String ico;
    private String error;
    private double temp;
    private int time;


}
