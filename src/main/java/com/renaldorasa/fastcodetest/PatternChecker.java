package com.renaldorasa.fastcodetest;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class PatternChecker {

    private Pattern valuePattern = Pattern.compile("(([1-9][0-9]*)|0)p(([1-9][0-9]*)|0)s(([1-9][0-9]*)|0)d$");
    private Matcher m;

    // Check if the input value correspongs to the format #p#s#d

    boolean checkPattern(String text){

        m = valuePattern.matcher(text);

        return m.matches();
    }
}
