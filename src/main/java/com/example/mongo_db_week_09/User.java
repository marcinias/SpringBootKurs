package com.example.mongo_db_week_09;


import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    // @CsvBindByName
    @CsvBindByPosition(position = 0)
    private Long id;
    @CsvBindByPosition(position = 1)
    //@CsvBindByName
    private String first_name;
    @CsvBindByPosition(position = 2)
    private String lastName;
    @CsvBindByPosition(position = 3)
    private String emial;
    @CsvBindByPosition(position = 4)
    private String gender;
    @CsvBindByPosition(position = 5)
    private String ip_address;
    //@CsvCustomBindByPosition(position = 3, converter = LocalDateConverter.class)


}



