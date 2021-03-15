package it.academy.monitorSensorProject.web.controller;

import it.academy.monitorSensorProject.service.dto.SensorDTO;
import it.academy.monitorSensorProject.service.impl.SensorsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class HomeController {

    @Autowired
    private final SensorsServiceImpl sensorsServiceImpl;

    public HomeController(SensorsServiceImpl sensorsServiceImpl) {
        this.sensorsServiceImpl = sensorsServiceImpl;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/allsensors")
    public String allSensors(Model model, @PageableDefault(sort = {"name"},
            direction = Sort.Direction.ASC) Pageable pageable) {
        Page<SensorDTO> page = sensorsServiceImpl.findAllSensors(pageable);
        model.addAttribute("page", page);
        model.addAttribute("url", "/allsensors");
        return "main_page";
    }

    @GetMapping("/allsensors/back")
    public String backToSensorsTable() {
        return "redirect:/allsensors";

    }

}
