package br.edu.usj.ads.pw.calculadora;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/calculadora")
public class CaculadoraController {

    @GetMapping
    public ModelAndView calculadora() {
        return new ModelAndView("calculadora");
    }

    @PostMapping("/resultado")
    public ModelAndView resultado(
        @RequestParam Double numero1,@RequestParam Double numero2, @RequestParam String operacao) {
        ModelAndView modelAndView =  new ModelAndView("resultado");
        modelAndView.addObject("resultado", getResultado(numero1, numero2, operacao));
        return modelAndView;
    }

    private Double getResultado (Double numero1, Double numero2, String operacao) {
        Double resultado;
        switch (operacao) {
            case "adicao":
                resultado = numero1 + numero2;
                break;
            case "subtracao":
                resultado = numero1 - numero2;
                break;
            case "multiplicacao":
                resultado = numero1 * numero2;
                break;
            case "divisao":
                if (numero2 != 0) {
                    resultado = numero1 / numero2;
                } else {
                    resultado = 0.0;
                }
                break;
            default:
                resultado = 0.0;
                break;
        }
        return resultado;
    }


    
}
