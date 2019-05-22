package com.spendster.presentation.utils;

import android.content.res.Resources;

import com.spendster.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TextDate implements SDateFormats {

    private final String textDate;

    public TextDate(String textDate) {
        this.textDate = textDate;
    }

    public Date date() throws ParseException {
        Date date = new Date();
        if (!textDate.equals(Resources.getSystem().getString(R.string.today))){
            date = new SimpleDateFormat(TIME_FORMAT, Locale.UK).parse(textDate);
        }
        return date;
    }
}
