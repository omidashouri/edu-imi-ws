package edu.imi.ir.eduimiws.repositories;
import edu.imi.ir.eduimiws.domain.crm.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
}
