package pl.sixfaces.week07.DAO;

import pl.sixfaces.week07.model.Car;

import java.util.List;

public interface CarDao {

    void saveCar(Car car);
    List<Car> findAll();
    List<Car> findByDateBetween(String dateFrom, String dateTo);
    int deleteById(long id);


}
