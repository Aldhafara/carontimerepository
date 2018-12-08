package com.carontime.on_time.controler;

import com.carontime.on_time.dao.UserDao;
import com.carontime.on_time.forms.UserEditForm;
import com.carontime.on_time.model.car.Car;
import com.carontime.on_time.model.car.CarForm;
import com.carontime.on_time.model.result.Result;
import com.carontime.on_time.model.user.User;
import com.carontime.on_time.model.user.UserForm;
import com.carontime.on_time.service.UserService;
import com.carontime.on_time.service.carservice.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.Binding;
import javax.validation.Valid;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.security.Principal;

@Controller
@RequestMapping
public class CarOnTimeControler {

    private final int TEST_USER_ID = 47;

    private CarService carService;
    private UserService userService;

    @Autowired
    public CarOnTimeControler(CarService carService, UserService userService) {
        this.carService = carService;
        this.userService = userService;
    }

    @GetMapping(value = {"/", "/index"})
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
    public String edit(Principal principal, Model model) {
        if(!model.containsAttribute("userEditForm")) {
            model.addAttribute("userEditForm", UserDao.toUserForm(userService.getUserById(TEST_USER_ID)));
        }
        return "user/edit";
    }

    @PostMapping("/user/edit")
    public String editUser(@Valid @ModelAttribute UserEditForm userEditForm, BindingResult bindingResult, Principal principal, RedirectAttributes model) {
        if(bindingResult.hasErrors()) {
            Result errors = new Result();
            bindingResult.getAllErrors().forEach(msg -> errors.addMessage(msg.getDefaultMessage()));
            model.addFlashAttribute("errors", errors);
        } else {
            Result result = new Result();
            try {
                User user = userService.getUserById(TEST_USER_ID);
                userService.updateUserData(user, userEditForm);
                result.addMessage("Pomyślnie edytowano dane użytkownika");
            } catch(RuntimeException e) {
                result.addMessage("Wystąpił błąd podczas edycji danych użytkownika");
                e.printStackTrace();
            }
            model.addFlashAttribute(result);
        }
        return "redirect:/user/edit";
    }

    @GetMapping("/register")
    public String userRegisterPage(){
        return "user/registration/register";
    }

    @PostMapping("/register")
    public String saveRegisterUser(UserForm userForm, RedirectAttributes model) {
            User user = new User(userForm.getName(), userForm.getLastname(), userForm.getCity(), userForm.getCarLicenceId(), userForm.getEmailAdress(), userForm.getPhoneNumber());
            model.addFlashAttribute(userForm);
            userService.addUser(user);
            return ("redirect:/registred_success");
            }
    @GetMapping("/registred_success")
    public String registredSuccess(){
        return "user/registration/registredSuccess";
    }







}
