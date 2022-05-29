package ru.appline.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.appline.logic.SideModel;

import java.util.Map;

@RestController
public class CompassController {
    private static final SideModel sideModel = SideModel.getInstance();


    @PostMapping(value = "/createCompass", consumes = "application/json")
    public String createCompass(@RequestBody Map<String, String> compassSide) {

        sideModel.add(compassSide);
        return "Компас успешно создан";
    }

    @GetMapping(value = "/getSide", consumes = "application/json", produces = "application/json")
    public String getSide(@RequestBody Map<String, String> degree) {

        return sideModel.getSide(Integer.parseInt(degree.get("Degree")));
    }
}