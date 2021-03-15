package it.academy.monitorSensorProject.web.controller;


import it.academy.monitorSensorProject.service.dto.SensorDTO;
import it.academy.monitorSensorProject.service.impl.EnumServiceImpl;
import it.academy.monitorSensorProject.service.impl.SensorsServiceImpl;
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

    @Autowired
    private final SensorsServiceImpl sensorsServiceImpl;
    @Autowired
    private final EnumServiceImpl enumServiceImpl;

    public SensorsController(SensorsServiceImpl sensorsServiceImpl, EnumServiceImpl enumServiceImpl) {
        this.sensorsServiceImpl = sensorsServiceImpl;
        this.enumServiceImpl = enumServiceImpl;
    }

    @GetMapping("allsensors/add")
    public String addSensor(Model model) {
        model.addAttribute("types", enumServiceImpl.getAllTypes());
        model.addAttribute("units", enumServiceImpl.getAllUnits());
        model.addAttribute("sensorDTO", new SensorDTO());
        return "new_sensor";

    }

    @PostMapping("allsensors/add")
    public String addNewSensor(@Valid SensorDTO sensorDTO, BindingResult bindingResult, Model model) {

        model.addAttribute("types", enumServiceImpl.getAllTypes());
        model.addAttribute("units", enumServiceImpl.getAllUnits());

        if (bindingResult.hasErrors()) {
            model.addAttribute("sensorDTO", sensorDTO);
            return "new_sensor";
        } else {
            sensorsServiceImpl.saveNewSensor(sensorDTO);
            return "redirect:/allsensors";
        }
    }

    @GetMapping("/allsensors/edit/{id}")
    public String editSensor(@PathVariable("id") String id, Model model) {
        model.addAttribute("types", enumServiceImpl.getAllTypes());
        model.addAttribute("units", enumServiceImpl.getAllUnits());
        model.addAttribute("sensorDTO", sensorsServiceImpl.getSensorById(id));
        return "update_sensor";
    }

    @PostMapping("allsensors/edit/{id}")
    public String update(@ModelAttribute("sensorDTO") SensorDTO sensorDTO, @PathVariable("id") String id) {
        sensorsServiceImpl.updateSensor(id, sensorDTO);
        return "redirect:/allsensors";
    }

    @GetMapping("/allsensors/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        sensorsServiceImpl.deleteSensor(id);
        return "redirect:/allsensors";
    }

}

