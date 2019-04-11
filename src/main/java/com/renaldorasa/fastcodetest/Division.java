package com.renaldorasa.fastcodetest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("Division")
public class Division implements Operation{

    @Autowired
    ValueScrambler valueScrambler;

    @Override
    public String doOperation(String value, String divisor) {

        long sterllina = valueScrambler.getTotalDividedValue(value, divisor) / 240;
        long scellini = (valueScrambler.getTotalDividedValue(value, divisor) - (sterllina * 240)) / 12;
        long pence = valueScrambler.getTotalDividedValue(value, divisor) - ((sterllina * 240) + (scellini * 12));

        long resto = ((valueScrambler.getPounds(value) * 240) + (valueScrambler.getShellings(value) * 12) + valueScrambler.getPence(value))
                - (valueScrambler.getTotalDividedValue(value, divisor) * Long.parseLong(divisor));

        long sterllinaResto = resto / 240;
        long scelliniResto = (resto - (sterllinaResto * 240)) / 12;
        long penceResto = resto - ((sterllinaResto * 240) + (scelliniResto * 12));

        return String.format("(%d sterlinne + %d scellini + %d pennies) / %d = %d sterlinne  %d scellini  %d pennies (%d sterlinne  %d scellini %d pennies)",
                valueScrambler.getPounds(value), valueScrambler.getShellings(value), valueScrambler.getPence(value), Long.parseLong(divisor),
                sterllina, scellini, pence,
                sterllinaResto, scelliniResto, penceResto);
    }
}
