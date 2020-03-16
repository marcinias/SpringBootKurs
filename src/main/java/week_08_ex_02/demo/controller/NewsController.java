package week_08_ex_02.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import week_08_ex_02.demo.model.Notebook;
import week_08_ex_02.demo.repository.NoteRepo;

import java.util.List;
import java.util.Optional;

@Controller
public class NewsController {

    NoteRepo noteRepo;


    @Autowired
    public NewsController(NoteRepo notoRepo) {
        this.noteRepo = notoRepo;
    }


    @GetMapping
    public String getAll(Model model) {

        List<Notebook> notebookList = noteRepo.findAll();

        model.addAttribute("notebookList", notebookList);
        model.addAttribute("newNote", new Notebook());

        return "index";
    }

    @PostMapping("/add")
    public String add(Notebook notebook) {

        noteRepo.save(notebook);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") long id) {
        noteRepo.deleteById(id);

        return "redirect:/";
    }

    @GetMapping("/update/form")
    public String updateFindId(@RequestParam("id") long id, Model model) {
        Notebook note = noteRepo.findById(id).get();

        model.addAttribute("noteUpdate", note);
        return "update";
    }

    @PostMapping("/update")
    public String update(Notebook notebook) {

        noteRepo.save(notebook);
        return "redirect:/";
    }


}
