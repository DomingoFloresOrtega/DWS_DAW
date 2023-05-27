package org.iesvdm.videoclub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/prueba")
public class PruebaController {

    @GetMapping({"","/"})
    public String prueba() {
        return "Prueba security con éxito";
    }

    @GetMapping("/solo-admin")
    public String pruebaSoloAdmin() {
        return "Prueba security con éxito usando admin";
    }
}
