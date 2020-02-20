package pl.sixfaces.week_07_zadanie_02.DAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.sixfaces.week_07_zadanie_02.model.Article;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class NewsDaoImpl implements NewsDao {

    private final JdbcTemplate jdbcTemplate;
    private static final Logger log = LoggerFactory.getLogger(NewsDaoImpl.class);

    @Autowired
    public NewsDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void saveNews(Article article) {

        String sql = "INSERT  INTO news ( title , description , url ) values (?,?,?)";
        jdbcTemplate.update(sql,
                                article.getTitle(),
                                article.getDescription(),
                                article.getUrlToImage());
    }


    @Override
    public List<Article> findAll() {
        return jdbcTemplate.query("SELECT * from news", this::mapRow);
    }

    @Override
    public void update(Article article) {

        String sql = "UPDATE news SET title=?, description=?, url=? WHERE news_id=?";

                       jdbcTemplate.update(sql,
                             article.getTitle(),
                             article.getDescription(),
                             article.getUrlToImage(),
                             article.getId());
    }

    @Override
    public void deleteById(long id) {
        jdbcTemplate.update("delete from news where  news_id=?", id);
    }

    @Override
    public Article findById(Long id) {

        return jdbcTemplate.queryForObject("select * from news where  news_id=?",  new Long[]{id}, this::mapRow ) ;
    }


    //mapRow
    private Article mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Article(resultSet.getLong(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4));
    }



}
