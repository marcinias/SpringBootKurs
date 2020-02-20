package pl.sixfaces.week_07_zadanie_02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sixfaces.week_07_zadanie_02.DAO.NewsDao;
import pl.sixfaces.week_07_zadanie_02.model.Article;

import java.util.List;

@Controller
public class NewsController {

    NewsDao newsDao;


    @Autowired
    public NewsController(NewsDao newsDao) {
        this.newsDao = newsDao;
    }


    @GetMapping
    public String getAll(Model model) {

        List<Article> all = newsDao.findAll();
        model.addAttribute("news", all);

        return "index";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") long id) {

        newsDao.deleteById(id);
        return "redirect:/";
    }


    @GetMapping("/update/form")
    public String updateFindId(@RequestParam("id") long id, Model model) {

        Article article = newsDao.findById(id);
        model.addAttribute("article", article);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Article article) {

        newsDao.update(article);
        return "redirect:/";
    }


}
