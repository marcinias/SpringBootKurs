package pl.sixfaces.week_04_home;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Car  {

    int Id;
    String mark;
    String model;
    String color;


}