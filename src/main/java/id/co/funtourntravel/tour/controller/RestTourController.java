package id.co.funtourntravel.tour.controller;

import id.co.funtourntravel.tour.model.Tour;
import id.co.funtourntravel.tour.repo.TourRepo;
import id.co.funtourntravel.tour.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class RestTourController {
    @Autowired
    TourService tourService;

    @Autowired
    TourRepo tourRepo;

    @GetMapping("/tours")
    @ResponseStatus(HttpStatus.OK)
    public List<Tour> findAll(){
        return tourRepo.findAll();
    }

    @GetMapping("/tours/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Tour findTourById(@PathVariable("id") int id){
        return tourRepo.findTourById(id);
    }

    @PostMapping("/tours")
    @ResponseStatus(HttpStatus.OK)
    public Tour addTour(@RequestBody Tour tour){
        tour.setId(0);
        return tourRepo.save(tour);

    }

    @PutMapping("/tours/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Tour updateTour(@RequestBody Tour tour, @PathVariable("id") int id){
        tour.setId(id);
        return tourRepo.save(tour);
    }

    @DeleteMapping("/tours/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTour(@PathVariable("id") int id){
        tourRepo.deleteById(id);
    }
}
