package com.barriohub.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleTestController {

    @GetMapping("/admin/test")
    public String adminTest() {

        return "Panel administrador";
    }

    @GetMapping("/guardia/test")
    public String guardiaTest() {

        return "Panel guardia";
    }

    @GetMapping("/residente/test")
    public String residenteTest() {

        return "Panel residente";
    }
}