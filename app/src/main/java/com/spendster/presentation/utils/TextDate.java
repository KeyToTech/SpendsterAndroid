package com.spendster.presentation.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TextDate implements SDateFormats {

    private final String textDate;
    private final static String TODAY = "Today?";

    public TextDate(String textDate) {
        this.textDate = textDate;
    }

    public Date date() throws ParseException {
        Date date = new Date();
        if (!textDate.equals(TODAY)){
            date = new SimpleDateFormat(TIME_FORMAT, Locale.UK).parse(textDate);
        }
        return date;
    }
}
