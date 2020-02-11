package com.example.demo.service;


import com.example.demo.model.Film;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmService {


    private   List<Film> filmList;

    public List<Film> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<Film> filmList) {
        this.filmList = filmList;
    }

    public FilmService() {
        filmList = new ArrayList<>();
        filmList.add(new Film(1,"nazwa1",1999));
        filmList.add(new Film(2,"nazwa2",1978));
        filmList.add(new Film(3,"nazwa3",1943));
        filmList.add(new Film(4,"nazwa4",2004));
    }


}
