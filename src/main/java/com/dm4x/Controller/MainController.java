package com.dm4x.Controller;

/**
 * Created by kiselev on 21.02.17.
 */
import com.dm4x.Model.Teacher;
import com.dm4x.Model.User;
import com.dm4x.service.SecurityService;
import com.dm4x.service.TeacherService;
import com.dm4x.service.UserService;
import com.dm4x.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private TeacherService teacherService;


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

    @RequestMapping(value = {"/", "/main"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "main";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }

    @RequestMapping(value = "/teachers", method = RequestMethod.GET)
    public String listTeachers(Model model) {
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("listTeachers", this.teacherService.listTeachers());
        return "teachers";
    }

    @RequestMapping(value = "/teachers/add", method = RequestMethod.POST)
    public String addTeacher(@ModelAttribute("teacher") Teacher teacher){
        teacherService.save(teacher);
        return "redirect:/teachers";
    }

    @RequestMapping("/delete/{id}")
    public String deleteTeacher(@ModelAttribute("teacher") Teacher teacher){
        teacherService.delete(teacher);
        return "redirect:/teachers";
    }

    @RequestMapping("edit/{id}")
    public String editTeacher(@PathVariable("id") Long id, Model model){
        model.addAttribute("teacher", teacherService.getTeacherById(id));
        model.addAttribute("listTeachers", teacherService.listTeachers());
        return "teachers";
    }

    @RequestMapping("teacherdata/{id}")
    public String teacherData(@PathVariable("id") Long id, Model model){
        model.addAttribute("teacher", teacherService.getTeacherById(id));
        return "teacherdata";
    }
}
