package it.academy.monitorSensorProject.web.controller;

import it.academy.monitorSensorProject.repository.SensorRepository;
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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    private final SensorsServiceImpl sensorsServiceImpl;

    @Autowired
    public SearchController(SensorsServiceImpl sensorsServiceImpl) {
        this.sensorsServiceImpl = sensorsServiceImpl;
    }

    @GetMapping("/allsensors/search")
    public String search(@RequestParam(name = "searchParam", required = false) String param, Model model,
                         @PageableDefault(sort = {"name"},
                                 direction = Sort.Direction.ASC) Pageable pageable) {

        if (param != null && !"".equals(param.trim())) {
            Page<SensorDTO> page = sensorsServiceImpl.searchSensorsByParam(param, pageable);
            model.addAttribute("page", page);
            model.addAttribute("url", "/allsensors/search?searchParam=" + param + "&");

        } else if (param == null | param == "") {
            return "redirect:/allsensors";
        }
        return "search_result";
    }

}
