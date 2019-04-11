package com.renaldorasa.fastcodetest;

import org.springframework.stereotype.Component;

@Component
public class ValueScrambler {

    Long getPounds(String value){
        return Long.parseLong(value.substring(0, value.indexOf("p")));
    }

    Long getShellings(String value){
        return Long.parseLong(value.substring(value.indexOf("p") + 1, value.indexOf("s")));
    }

    Long getPence(String value){
        return Long.parseLong(value.substring(value.indexOf("s") + 1, value.indexOf("d")));
    }

    Long getTotalAddedValue(String firstNum, String secondNum){

       return ((getPounds(firstNum) + getPounds(secondNum)) * 240) + ((getShellings(firstNum) +
               getShellings(secondNum)) * 12) + (getPence(firstNum) + getPence(secondNum));
    }

    Long getTotalSubtractedValue(String firstNum, String secondNum){

        return ((getPounds(firstNum) * 240) + (getShellings(firstNum) * 12) + getPence(firstNum)) -
                ((getPounds(secondNum) * 240) + (getShellings(secondNum) * 12) + getPence(secondNum));
    }

    Long getTotalMultipliedValue(String value, String multiplier){

        return ((getPounds(value) * 240) + (getShellings(value) * 12) + getPence(value)) * Long.parseLong(multiplier);
    }

    Long getTotalDividedValue(String value, String divider){
            return ((getPounds(value) * 240) + (getShellings(value) * 12) + getPence(value)) / Long.parseLong(divider);
    }


}
