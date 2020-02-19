package pl.sixfaces.week_07_zadanie_02.DAO;

import pl.sixfaces.week_07_zadanie_02.model.Article;

import java.util.List;

public interface NewsDao {

    void saveNews(Article article);
    List<Article> findAll();
    void update(Article article);
    void deleteById(long id);
    Article findById(Long id);

}
