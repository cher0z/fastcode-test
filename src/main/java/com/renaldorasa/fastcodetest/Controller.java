package com.renaldorasa.fastcodetest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    PatternChecker patternChecker;

    @Autowired
    @Qualifier("Addition")
    Operation addition;

    @Autowired
    @Qualifier("Subtraction")
    Operation subtraction;

    @Autowired
    @Qualifier("Multiplication")
    Operation multiplication;

    @Autowired
    @Qualifier("Division")
    Operation division;

    // Addition method

    @RequestMapping(value = "/add/{firstNum}/{secondNum}", method = GET)
    String add (@PathVariable("firstNum") String firstNum, @PathVariable("secondNum") String secondNum){

        if(patternChecker.checkPattern(firstNum) && patternChecker.checkPattern(secondNum)) {
            return addition.doOperation(firstNum, secondNum);
        }
        else{
            return "INCORRECT FORMAT USE XpXsXd";
        }
    }



    // Subtraction method

    @RequestMapping(value = "/subtract/{firstNum}/{secondNum}", method = GET)
    String subtract (@PathVariable("firstNum") String firstNum, @PathVariable("secondNum") String secondNum){

        if(patternChecker.checkPattern(firstNum) && patternChecker.checkPattern(secondNum)) {
            return subtraction.doOperation(firstNum, secondNum);
        }
        else{
            return "INCORRECT FORMAT USE /XpXsXd/YpYsYd";
        }
    }


    // Multiplication method

    @RequestMapping(value = "/multiply/{value}/{multiplier}", method = GET)
    String multiply (@PathVariable("value") String value, @PathVariable("multiplier") String multiplier){

        if(patternChecker.checkPattern(value) && multiplier.matches("-?(0|[1-9]\\d*)")) {
            return multiplication.doOperation(value, multiplier);
        }
        else{
            return "INCORRECT FORMAT USE /XpXsXd/N";
        }
    }


    // Division method

    @RequestMapping(value = "/divide/{value}/{divider}", method = GET)
    String divide (@PathVariable("value") String value, @PathVariable("divider") String divider){

        if(patternChecker.checkPattern(value) && divider.matches("-?(0|[1-9]\\d*)")) {
            if(Long.parseLong(divider) != 0)
                return division.doOperation(value, divider);
            else {
                return "DIVISION BY ZERO NOT ALLOWED";
            }
        }
        else{
            return "INCORRECT FORMAT, USE /XpXsXd/N ";
        }
    }
}
