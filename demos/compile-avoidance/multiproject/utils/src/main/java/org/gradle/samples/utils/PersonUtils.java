package org.gradle.samples.utils;

import static org.apache.commons.lang3.StringUtils.capitalize;

import org.gradle.samples.core.Person;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonUtils {
    private final static Pattern PATTERN = Pattern.compile("([0-9]{2})[-/]([0-9]{2})[-/]([0-9]{4})");

    public static Person of(String firstName, String lastName, String dateOfBirth) {
        Matcher m = PATTERN.matcher(dateOfBirth);
        if (m.matches()) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Integer.valueOf(m.group(3)), Integer.valueOf(m.group(2)) + 1, Integer.valueOf(m.group(1)));
            return new Person(capitalize(firstName), capitalize(lastName), calendar.getTime());
        }
        System.out.println("Hallo Gradle Day!");
        throw new IllegalArgumentException("Unsupported date format: " + dateOfBirth);
    }
}
