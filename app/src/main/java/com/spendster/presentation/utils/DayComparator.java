package com.spendster.presentation.utils;

import java.util.Calendar;
import java.util.Date;

public class DayComparator {
    private final Date date;

    public DayComparator(Date date) {
        this.date = date;
    }

    public boolean isToday(){
        Calendar dateToCompare = Calendar.getInstance();
        dateToCompare.setTime(this.date);
        Calendar todayDay = Calendar.getInstance();
        todayDay.setTime(new Date());
        return dateToCompare.get(Calendar.DATE) == todayDay.get(Calendar.DATE);
    }

    public boolean isYesterday(){
        Calendar dateToCompare = Calendar.getInstance();
        dateToCompare.setTime(this.date);
        Calendar yesterdayDay = Calendar.getInstance();
        yesterdayDay.add(Calendar.DATE, -1);
        return dateToCompare.get(Calendar.DATE) == yesterdayDay.get(Calendar.DATE);
    }

    public int day(){
        Calendar date = Calendar.getInstance();
        date.setTime(this.date);
        return date.get(Calendar.DATE);
    }
}
