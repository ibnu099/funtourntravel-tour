package id.co.funtourntravel.tour.repo;

import id.co.funtourntravel.tour.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TourRepo extends JpaRepository<Tour, Integer> {
    Tour findTourById(Integer ainteger);
}
