package com.example.demo.controller;


import com.example.demo.service.SendEmail;
import com.example.demo.model.Film;
import com.example.demo.service.EmailService;
import com.example.demo.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class FilmController {


    private FilmService filmService = new FilmService();
    private EmailService emailService = new EmailService();

    @Autowired
    public FilmController(FilmService filmService, EmailService emailService) {
        this.filmService = filmService;
        this.emailService = emailService;
    }

    @GetMapping
    public String getAllFilms(Model model) {

        model.addAttribute("list", filmService.getFilmList());
        model.addAttribute("newFilm", new Film());

        return "index";
    }

    @SendEmail
    @PostMapping("/add")
    public String addCar(Film film) {
        filmService.getFilmList().add(film);

        return "redirect:/";
    }

}
