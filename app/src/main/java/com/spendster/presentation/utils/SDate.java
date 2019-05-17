package com.spendster.presentation.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SDate implements SDateFormats {

    private final Date date;

    public SDate(Date date) {
        this.date = date;
    }

    public String dateFormatted() {
        return new SimpleDateFormat(TIME_FORMAT, Locale.UK).format(this.date);
    }


}
