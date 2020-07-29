package com.example.demo.controllers;

import com.example.demo.models.LocationStats;
import com.example.demo.services.CoronavirusDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    CoronavirusDatabaseService coronavirusDatabaseService;

    @GetMapping("/")
    public String home(Model model){
        List<LocationStats> locationStatsList = coronavirusDatabaseService.getLocationStatsList();
        int reportedCasesToday = locationStatsList.stream().mapToInt(locStat -> locStat.getLatestTotalCases()).sum();
        model.addAttribute("locationStatsList", locationStatsList);
        model.addAttribute("reportedCasesToday", reportedCasesToday);
        return "home";
    }
}
