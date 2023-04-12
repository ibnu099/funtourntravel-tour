package id.co.funtourntravel.tour.controller;

import id.co.funtourntravel.tour.model.Tour;
import id.co.funtourntravel.tour.repo.TourRepo;
import id.co.funtourntravel.tour.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("tour")
public class TourController {
    @Autowired
    private TourService tourService;

    @GetMapping("/all")
    public @ResponseBody
    List<Tour> findAll(){
        return tourService.allTour();
    }

    @GetMapping("/id")
    public @ResponseBody Tour getTour(@RequestParam("id") int id){
        Tour model = new Tour();
        model.setId(id);
        return tourService.findTheTour(model);
    }

    @GetMapping("/add")
    public String addTour(@RequestParam("tourname") String tourname
            , @RequestParam("price") Long price
            , @RequestParam("desc") String desc){
        Tour model = new Tour();
        model.setId(0);
        model.setTourName(tourname);
        model.setPrice(price);
        model.setDescription(desc);
        tourService.insert(model);
        return "redirect:/tour/all";
    }

    @GetMapping("/update")
    public String addTour(@RequestParam("id")  int id
            , @RequestParam("tourname") String tourname
            , @RequestParam("price") Long price
            , @RequestParam("desc") String desc){
        Tour model = new Tour();
        model.setId(id);
        model.setTourName(tourname);
        model.setPrice(price);
        model.setDescription(desc);
        tourService.update(model);
        return "redirect:/tour/all";
    }

    @GetMapping("/delete")
    public String addTour(@RequestParam("id")  int id){
        Tour model = new Tour();
        model.setId(id);
        tourService.delete(model);
        return "redirect:/tour/all";
    }

    @GetMapping("/allpage")
    public @ResponseBody List<Tour> findAllPage(@RequestParam("page") int page
            , @RequestParam("size") int size) {
        return tourService.allTourPage(page, size);
    }

}
