package com.carontime.on_time.controler;

import com.carontime.on_time.dto.AddCarDao;
import com.carontime.on_time.model.car.Car;
import com.carontime.on_time.forms.CarForm;
import com.carontime.on_time.model.result.Result;
import com.carontime.on_time.service.carservice.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.awt.geom.Point2D;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private CarService carService;

    @Autowired
    public AdminController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    @PostMapping
    public String admin() {
        return "admin/adminIndex";
    }

    @GetMapping("/cars")
    public String carsManager(Model model) {
        if(!model.containsAttribute("carForm")) {
            model.addAttribute(new CarForm());
        }
        model.addAttribute("carList", carService.getAll());
        return "admin/carManager";
    }

    @PostMapping("/cars/add")
    public String add(@Valid CarForm carForm, BindingResult bindingResult, RedirectAttributes model) {
        if(bindingResult.hasErrors()) {
            Result errors = new Result();
            bindingResult.getAllErrors().forEach(message -> errors.addMessage(message.getDefaultMessage()));
            model.addFlashAttribute("errors", errors);
            model.addFlashAttribute(carForm);
            return "redirect:/admin/cars";
        }
        model.addFlashAttribute("results", new Result("Dodano pojazd do listy"));
        carService.addCar(new Car(carForm.getStatus(), AddCarDao.convertCoordsToPoint2D(carForm)));
        return "redirect:/admin/cars";
    }

    @GetMapping("/cars/edit/{carid}")
    public String editCar(@PathVariable("carid") int carId, Model model) {
        Car car = carService.getCar(carId);
        CarForm carForm = AddCarDao.fromCar(car);
        model.addAttribute("carid", car.getId());
        model.addAttribute("carForm", carForm);
        return "admin/caredit";
    }

    @PostMapping("/cars/edit/{carid}")
    public String postEditCar(@Valid CarForm carForm, BindingResult bindingResult, @PathVariable("carid") int carId, RedirectAttributes model) {
        if(bindingResult.hasErrors()) {
            Result errors = new Result();
            bindingResult.getAllErrors().forEach(message -> errors.addMessage(message.getDefaultMessage()));
            model.addFlashAttribute("errors", errors);
            return "redirect:/admin/cars/edit/" + carId;
        }
        try {
            carService.updateCar(carId, carForm);
            model.addFlashAttribute("results", new Result("Pomyślnie edytowano dane!"));
        } catch (NullPointerException e) {
            model.addFlashAttribute("errors", new Result("Niepoprawne ID pojazdu!"));
        }
        return "redirect:/admin/cars/edit/" + carId;
    }

    @GetMapping("/cars/delete")
    public String infoDeleteCar() {
        return "admin/carDelete";
    }

    @GetMapping("/cars/delete/{carid}")
    public String deleteCar(@PathVariable("carid") int carId, Model model) {
        Car car = carService.getCar(carId);
        model.addAttribute("carid", car.getId());
        return "admin/carDelete";
    }

    @PostMapping("/cars/delete/{carid}")
    public String postDeleteCar(@PathVariable("carid") int carId, RedirectAttributes model) {
        Car car = carService.getCar(carId);
        carService.deleteCar(car);
        model.addFlashAttribute("results", "Pomyślnie usunięto pojazd o ID: " + carId);
        return "redirect:/admin/cars/delete";
    }
}
