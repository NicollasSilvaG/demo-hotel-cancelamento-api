package org.example.demohotelcancelamentoapi.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerController {

    @GetMapping("/api/v1/reservas/cancelamento/swagger")
    public String redirectToSwagger() {
        return "redirect:/docs-reserva-cancelamento.html";
    }

}