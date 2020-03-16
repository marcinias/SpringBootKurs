package week_08_ex_02.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import week_08_ex_02.demo.model.Notebook;

public interface NoteRepo extends JpaRepository<Notebook, Long> {
}
