package com.digitalday.dojounittest.validator;

import java.util.regex.Pattern;

/**
 * Created by athila on 23/06/15.
 */
public class IntegerValidator extends Validator {
    private static final String REGEX = "^[-+]?\\d+$";

    public IntegerValidator() {
        super(Pattern.compile(REGEX));
    }
}
