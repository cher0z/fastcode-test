package com.renaldorasa.fastcodetest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValueScrambler {

    Pattern valuePattern = Pattern.compile("(^[1-9][0-9]*)p([1-9][0-9]*)s([1-9][0-9]*)");
    Matcher matcher;
}
