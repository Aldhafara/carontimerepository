package com.carontime.on_time.controler;

import com.carontime.on_time.dto.UserDto;
import com.carontime.on_time.forms.UserEditForm;
import com.carontime.on_time.login.Role;
import com.carontime.on_time.login.RoleRepository;
import com.carontime.on_time.model.car.Car;
import com.carontime.on_time.model.car.CarForm;
import com.carontime.on_time.model.result.Result;
import com.carontime.on_time.model.user.User;
import com.carontime.on_time.model.user.UserForm;
import com.carontime.on_time.service.UserService;
import com.carontime.on_time.service.carservice.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.awt.geom.Point2D;
import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping
public class CarOnTimeControler {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final Long TEST_USER_ID = 226L;

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
    public String map(Model model) {
        List<Car> cars = carService.getAll();
        model.addAttribute("lat", cars.get(0).getLocalization().x);
        System.out.println(cars.get(0).getLocalization().x);
        model.addAttribute("lng", cars.get(0).getLocalization().y);
        System.out.println(cars.get(0).getLocalization().y);
        model.addAttribute("status", cars.get(0).getStatus());
        System.out.println(cars.get(0).getStatus());
        model.addAttribute("listOfCars",cars);
        return "mapapi/mapapi";
    }

    @GetMapping("/user/edit")
    public String edit(Principal principal, Model model) {
        if(!model.containsAttribute("userEditForm")) {
            model.addAttribute("userEditForm", UserDto.toUserForm(userService.getUserById(TEST_USER_ID)));
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

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/register")
    public String saveRegisterUser(UserForm userForm, RedirectAttributes model) {

        Role userRole = roleRepository.save(new Role("USER"));
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        User user = new User(userForm.getUsername(), passwordEncoder.encode(userForm.getPassword()), userForm.getName(), userForm.getLastname(), userForm.getCity(), userForm.getCarLicenceId(), userForm.getEmailAdress(), userForm.getPhoneNumber());
            model.addFlashAttribute(userForm);
            user.setRoles(userRoles);
            userService.addUser(user);
            return ("redirect:/registred_success");
            }
    @GetMapping("/registred_success")
    public String registredSuccess(){
        return "user/registration/registredSuccess";
    }







}
