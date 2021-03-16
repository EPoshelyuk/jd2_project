package it.academy.monitorSensorProject.web.controller;

import it.academy.monitorSensorProject.service.SensorService;
import it.academy.monitorSensorProject.service.dto.SensorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final SensorService sensorService;

    @Autowired
    public HomeController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/allsensors")
    public String allSensors(Model model, @PageableDefault(sort = {"name"},
            direction = Sort.Direction.ASC) Pageable pageable) {
        Page<SensorDTO> page = sensorService.findAllSensors(pageable);
        model.addAttribute("page", page);
        model.addAttribute("url", "/allsensors");
        return "main_page";
    }

    @GetMapping("/allsensors/back")
    public String backToSensorsTable() {
        return "redirect:/allsensors";
    }

}
