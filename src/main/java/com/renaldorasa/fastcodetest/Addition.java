package com.renaldorasa.fastcodetest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("Addition")
public class Addition implements Operation {

    @Autowired
    ValueScrambler valueScrambler;

    @Override
    public String doOperation(String firstNum, String secondNum) {

        long sterllina = valueScrambler.getTotalAddedValue(firstNum, secondNum) / 240;
        long scellini = (valueScrambler.getTotalAddedValue(firstNum, secondNum) - (sterllina * 240)) / 12;
        long pence = valueScrambler.getTotalAddedValue(firstNum, secondNum) - ((sterllina * 240) + (scellini* 12));

        return String.format("(%d sterlinne + %d scellini + %d pennies) + (%d sterlinne + %d scellini + %d pennies) = %d sterlinne + %d scellini + %d pennies",
                valueScrambler.getPounds(firstNum), valueScrambler.getShellings(firstNum), valueScrambler.getPence(firstNum),
                valueScrambler.getPounds(secondNum), valueScrambler.getShellings(secondNum), valueScrambler.getPence(secondNum),
                sterllina, scellini, pence);
    }
}
