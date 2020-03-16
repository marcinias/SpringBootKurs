package week_08_ex_02.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import week_08_ex_02.demo.model.Notebook;
import week_08_ex_02.demo.repository.NoteRepo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    private NoteRepo noteRepo;

    @Autowired
    public DemoApplication(NoteRepo noteRepo) {
        this.noteRepo = noteRepo;
    }


  @Override
    public void run(String... args) throws Exception {

        Notebook notebook = new Notebook( " New title", "Placeholder 01");
        System.out.println(notebook);
        noteRepo.save(notebook);
    }
}
