package id.co.funtourntravel.tour.service;

import id.co.funtourntravel.tour.model.Tour;

import java.util.List;

public interface ITourService {
    void insert(Tour tour);
    void update(Tour tour);
    void delete(Tour tour);
    Tour findTheTour(Tour tour);
    List<Tour> allTour();
    List<Tour> allTourPage(int page, int size);
}
