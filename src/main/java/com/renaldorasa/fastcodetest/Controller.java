package com.renaldorasa.fastcodetest;

import org.springframework.web.bind.annotation.*;


import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api")
public class Controller {
    

    // Addition method

    @RequestMapping(value = "/add/{sterllina1}/{scellini1}/{pence1}/{sterllina2}/{scellini2}/{pence2}", method = GET)
    String add (@PathVariable("sterllina1") Long sterllina1, @PathVariable("scellini1") Long scellini1, @PathVariable("pence1") Long pence1,
                           @PathVariable("sterllina2") Long sterllina2, @PathVariable("scellini2") Long scellini2, @PathVariable("pence2") Long pence2){

        long totalValue = ((sterllina1 + sterllina2) * 240) + ((scellini1 + scellini2) * 12) + (pence1 + pence2);
        long sterllina = totalValue / 240;
        long scellini = (totalValue - (sterllina * 240)) / 12;
        long pence = totalValue - ((sterllina * 240) + (scellini* 12));


        return String.format("(%d sterlinne + %d scellini + %d pennies) + (%d sterlinne + %d scellini + %d pennies) = %d sterlinne + %d scellini + %d pennies",
                sterllina1, scellini1, pence1, sterllina2, scellini2, pence2, sterllina, scellini, pence);
    }



    // Subtraction method

    @RequestMapping(value = "/subtract/{sterllina1}/{scellini1}/{pence1}/{sterllina2}/{scellini2}/{pence2}", method = GET)
    String subtract (@PathVariable("sterllina1") Long sterllina1, @PathVariable("scellini1") Long scellini1, @PathVariable("pence1") Long pence1,
                           @PathVariable("sterllina2") Long sterllina2, @PathVariable("scellini2") Long scellini2, @PathVariable("pence2") Long pence2){

        long totalValue = ((sterllina1 * 240) + (scellini1 * 12) + pence1) - ((sterllina2 * 240) + (scellini2 * 12) + pence2);
        long sterllina = totalValue / 240;
        long scellini = (totalValue - (sterllina * 240)) / 12;
        long pence = totalValue - ((sterllina * 240) + (scellini* 12));

        if (totalValue < 0){
            sterllina *= -1;
            scellini *= -1;;
            pence *= -1;;

            return String.format("(%d sterlinne + %d scellini + %d pennies) - (%d sterlinne + %d scellini + %d pennies) = %d sterlinne  %d scellini  %d pennies (OWED)",
                    sterllina1, scellini1, pence1, sterllina2, scellini2, pence2, sterllina, scellini, pence);
        }
        else {
            return String.format("(%d sterlinne + %d scellini + %d pennies) - (%d sterlinne + %d scellini + %d pennies) = %d sterlinne  %d scellini  %d pennies",
                    sterllina1, scellini1, pence1, sterllina2, scellini2, pence2, sterllina, scellini, pence);
        }
    }


    // Multiplication method

    @RequestMapping(value = "/multiply/{sterllina1}/{scellini1}/{pence1}/{multiplicant}", method = GET)
    String multiply (@PathVariable("sterllina1") Long sterllina1, @PathVariable("scellini1") Long scellini1, @PathVariable("pence1") Long pence1,
                     @PathVariable("multiplicant") Long multiplicant) {

        long totalValue = ((sterllina1 * 240) + (scellini1 * 12) + pence1) * multiplicant;
        long sterllina = totalValue / 240;
        long scellini = (totalValue - (sterllina * 240)) / 12;
        long pence = totalValue - ((sterllina * 240) + (scellini* 12));

        return String.format("(%d sterlinne + %d scellini + %d pennies) * %d = %d sterlinne  %d scellini  %d pennies",
                    sterllina1, scellini1, pence1, multiplicant, sterllina, scellini, pence);
    }


    // Division method

    @RequestMapping(value = "/divide/{sterllina1}/{scellini1}/{pence1}/{divisor}", method = GET)
    String divide (@PathVariable("sterllina1") Long sterllina1, @PathVariable("scellini1") Long scellini1, @PathVariable("pence1") Long pence1, @PathVariable("divisor") Long divisor) {
        if( divisor != 0) {

            long totalValue = ((sterllina1 * 240) + (scellini1 * 12) + pence1) / divisor;
            long resto = ((sterllina1 * 240) + (scellini1 * 12) + pence1) - (totalValue * divisor);

            long sterllina = totalValue / 240;
            long scellini = (totalValue - (sterllina * 240)) / 12;
            long pence = totalValue - ((sterllina * 240) + (scellini * 12));

            long sterllinaResto = resto / 240;
            long scelliniResto = (resto - (sterllinaResto * 240)) / 12;
            long penceResto = resto - ((sterllinaResto * 240) + (scelliniResto * 12));

            return String.format("(%d sterlinne + %d scellini + %d pennies) / %d = %d sterlinne  %d scellini  %d pennies (%d sterlinne  %d scellini %d pennies)",
                    sterllina1, scellini1, pence1, divisor, sterllina, scellini, pence, sterllinaResto, scelliniResto, penceResto);
        }
        else {
            return "CAN'T DIVIDE BY ZERO";
        }
    }
}
