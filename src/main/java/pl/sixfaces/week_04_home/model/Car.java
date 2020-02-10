package pl.sixfaces.week_04_home.model;


import lombok.*;

//@Setter(AccessLevel.PROTECTED)
//@Getter(AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Car {

    private int Id;
    private String mark;
    private String model;
    private String color;


}