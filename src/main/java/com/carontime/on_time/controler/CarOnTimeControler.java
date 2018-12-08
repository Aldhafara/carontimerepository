package com.carontime.on_time.controler;

import com.carontime.on_time.model.car.Car;
import com.carontime.on_time.model.car.CarForm;
import com.carontime.on_time.model.user.User;
import com.carontime.on_time.model.user.UserForm;
import com.carontime.on_time.service.UserService;
import com.carontime.on_time.service.carservice.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.geom.Point2D;

@Controller
@RequestMapping
public class CarOnTimeControler {

    @Autowired
    CarService carService;

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String start() {
        return "layout";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/user")
    public String user(Model model) {
        if(!model.containsAttribute("userForm")){
            model.addAttribute(new UserForm());
        }
        return "user/userdata";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin/admindata";
    }

    @PostMapping("/admin")
    public String add(@ModelAttribute CarForm carForm, Model model) {
        Car car = new Car(carForm.getStatus(), new Point2D.Double(carForm.getLatitude(), carForm.getLongitude()));
        model.addAttribute("status", carForm.getStatus());
        model.addAttribute("latitude", carForm.getLatitude());
        model.addAttribute("longitude", carForm.getLongitude());
        carService.addCar(car);
        return "admin/admindata";
    }

    @GetMapping("/user/map")
    public String map() {
        return "mapapi/mapapi";
    }

    @GetMapping("/user/edit")
    public String edit() { return "user/edit"; }

    @PostMapping("/user/edit")
    public String editUser(UserForm userForm, RedirectAttributes model) {
        User user = new User(userForm.getName(), userForm.getLastname(), userForm.getCity(), userForm.getCarLicenceId(), userForm.getEmailAdress(), userForm.getPhoneNumber());
        model.addFlashAttribute(userForm);
        userService.addUser(user);
        return "redirect:/user";
    }





}
