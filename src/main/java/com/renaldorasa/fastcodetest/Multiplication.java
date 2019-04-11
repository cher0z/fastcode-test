package com.renaldorasa.fastcodetest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("Multiplication")
public class Multiplication implements Operation {

    @Autowired
    ValueScrambler valueScrambler;

    @Override
    public String doOperation(String value, String multiplier) {

        long sterllina = valueScrambler.getTotalMultipliedValue(value, multiplier) / 240;
        long scellini = (valueScrambler.getTotalMultipliedValue(value, multiplier) - (sterllina * 240)) / 12;
        long pence = valueScrambler.getTotalMultipliedValue(value, multiplier) - ((sterllina * 240) + (scellini* 12));

        if(Long.parseLong(multiplier) < 0){
            sterllina *= -1;
            scellini *= -1;;
            pence *= -1;;

            return String.format("(%d sterlinne + %d scellini + %d pennies) * %d = %d sterlinne  %d scellini  %d pennies (OWED)",
                    valueScrambler.getPounds(value), valueScrambler.getShellings(value), valueScrambler.getPence(value), Long.parseLong(multiplier),
                    sterllina, scellini, pence);
        }else{
            return String.format("(%d sterlinne + %d scellini + %d pennies) * %d = %d sterlinne  %d scellini  %d pennies",
                    valueScrambler.getPounds(value), valueScrambler.getShellings(value), valueScrambler.getPence(value), Long.parseLong(multiplier),
                    sterllina, scellini, pence);
        }
    }
}
