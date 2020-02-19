package pl.sixfaces.week07.DAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.sixfaces.week07.model.Car;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    private final JdbcTemplate jdbcTemplate;
    private static final Logger log = LoggerFactory.getLogger(CarDaoImpl.class);

    @Autowired
    public CarDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void saveCar(Car car) {


        String sql = "INSERT  INTO cars ( mark , model, color, date_production) values (?,?,?,?)";
        jdbcTemplate.update(sql,
                car.getMark(),
                car.getModel(),
                car.getColor(),
                car.getDateProduction());

    }

    @Override
    public int deleteById(long id) {

        return jdbcTemplate.update("delete  from cars where  car_id=?", id);

    }




    @Override
    public List<Car> findAll() {

        return jdbcTemplate.query("SELECT * from cars", this::mapRow);
    }

   @Override
    public List<Car> findByDateBetween( String dateFrom,  String dateTo) {

        return jdbcTemplate.query("SELECT * from cars WHERE date_production between  ?  and  ? ", new String[] {dateFrom, dateTo}, this::mapRow);
    }


    private Car mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Car(resultSet.getLong(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4),
                resultSet.getDate(5));
    }

}
// or create new RowMapper<Car>

 /*   return jdbcTemplate.query("SELECT * from cars", new RowMapper<Car>() {
        @Override
        public Car mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Car(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getDate(5));
        }
    });*/