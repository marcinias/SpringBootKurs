package pl.sixfaces.week08_ex01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sixfaces.week08_ex01.model.City;

@Repository
public interface WeatherRepo extends JpaRepository<City, Long> {
}
