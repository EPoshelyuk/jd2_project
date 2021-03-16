package it.academy.monitorSensorProject.web.controller;

import it.academy.monitorSensorProject.service.EnumService;
import it.academy.monitorSensorProject.service.SensorService;
import it.academy.monitorSensorProject.service.dto.SensorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class SensorsController {

    private final SensorService sensorService;
    private final EnumService enumService;

    @Autowired
    public SensorsController(SensorService sensorService, EnumService enumService) {
        this.sensorService = sensorService;
        this.enumService = enumService;
    }

    @GetMapping("allsensors/add")
    public String addSensor(Model model) {
        model.addAttribute("types", enumService.getAllTypes());
        model.addAttribute("units", enumService.getAllUnits());
        model.addAttribute("sensorDTO", new SensorDTO());
        return "new_sensor";
    }

    @PostMapping("allsensors/add")
    public String addNewSensor(@Valid SensorDTO sensorDTO, BindingResult bindingResult, Model model) {

        model.addAttribute("types", enumService.getAllTypes());
        model.addAttribute("units", enumService.getAllUnits());

        if (bindingResult.hasErrors()) {
            model.addAttribute("sensorDTO", sensorDTO);
            return "new_sensor";
        } else {
            sensorService.saveNewSensor(sensorDTO);
            return "redirect:/allsensors";
        }
    }

    @GetMapping("/allsensors/edit/{id}")
    public String editSensor(@PathVariable("id") String id, Model model) {
        model.addAttribute("types", enumService.getAllTypes());
        model.addAttribute("units", enumService.getAllUnits());
        model.addAttribute("sensorDTO", sensorService.getSensorById(id));
        return "update_sensor";
    }

    @PostMapping("allsensors/edit/{id}")
    public String update(@ModelAttribute("sensorDTO") SensorDTO sensorDTO, @PathVariable("id") String id) {
        sensorService.updateSensor(id, sensorDTO);
        return "redirect:/allsensors";
    }

    @GetMapping("/allsensors/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        sensorService.deleteSensor(id);
        return "redirect:/allsensors";
    }

}

