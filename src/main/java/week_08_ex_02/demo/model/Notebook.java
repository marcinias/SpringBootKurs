package week_08_ex_02.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notebook")
public class Notebook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(value=TemporalType.TIME)
    private Date dateNote = new Date();;
    private String title;
    private String note;

    public Notebook( String title, String note) {
        this.title = title;
        this.note = note;
    }
}
