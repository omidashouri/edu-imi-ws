package edu.imi.ir.eduimiws.repositories;


import edu.imi.ir.eduimiws.domain.crm.CarDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDetailRepository extends JpaRepository<CarDetail,Long> {
}
