package id.co.funtourntravel.tour.service;

import id.co.funtourntravel.tour.model.Tour;
import id.co.funtourntravel.tour.repo.TourRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService implements ITourService{
    @Autowired
    TourRepo tourRepo;

    @Override
    public void insert(Tour tour) {
        tourRepo.save(tour);
    }

    @Override
    public void update(Tour tour) {
        tourRepo.save(tour);
    }

    @Override
    public void delete(Tour tour) {
        tourRepo.deleteById(tour.getId());
    }

    @Override
    public Tour findTheTour(Tour tour) {
        return tourRepo.findTourById(tour.getId());
    }

    @Override
    public List<Tour> allTour() {
        return tourRepo.findAll();
    }

    @Override
    public List<Tour> allTourPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return tourRepo.findAll(pageable).getContent();
    }
}
