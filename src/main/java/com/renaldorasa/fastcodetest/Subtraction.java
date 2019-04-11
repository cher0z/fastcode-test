package com.renaldorasa.fastcodetest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("Subtraction")
public class Subtraction implements Operation {

    @Autowired
    ValueScrambler valueScrambler;

    @Override
    public String doOperation(String firstNum, String secondNum) {

        long sterllina = valueScrambler.getTotalSubtractedValue(firstNum, secondNum) / 240;
        long scellini = (valueScrambler.getTotalSubtractedValue(firstNum, secondNum) - (sterllina * 240)) / 12;
        long pence = valueScrambler.getTotalSubtractedValue(firstNum, secondNum) - ((sterllina * 240) + (scellini* 12));

        if (valueScrambler.getTotalSubtractedValue(firstNum, secondNum) < 0){

            sterllina *= -1;
            scellini *= -1;;
            pence *= -1;;

            return String.format("(%d sterlinne + %d scellini + %d pennies) - (%d sterlinne + %d scellini + %d pennies) = %d sterlinne  %d scellini  %d pennies (OWED)",
                    valueScrambler.getPounds(firstNum), valueScrambler.getShellings(firstNum), valueScrambler.getPence(firstNum),
                    valueScrambler.getPounds(secondNum), valueScrambler.getShellings(secondNum), valueScrambler.getPence(secondNum),
                    sterllina, scellini, pence);
        }
        else {

            return String.format("(%d sterlinne + %d scellini + %d pennies) - (%d sterlinne + %d scellini + %d pennies) = %d sterlinne  %d scellini  %d pennies",
                    valueScrambler.getPounds(firstNum), valueScrambler.getShellings(firstNum), valueScrambler.getPence(firstNum),
                    valueScrambler.getPounds(secondNum), valueScrambler.getShellings(secondNum), valueScrambler.getPence(secondNum),
                    sterllina, scellini, pence);
        }
    }
}
