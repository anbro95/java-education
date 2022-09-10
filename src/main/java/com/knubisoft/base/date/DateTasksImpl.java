package com.knubisoft.base.date;

import javassist.Loader;
import lombok.SneakyThrows;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

public class DateTasksImpl implements DateTasks {
    @SneakyThrows
    @Override
    public String add1Day(String date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(df.parse(date));
        calendar.add(Calendar.DATE, 1);
        String res = df.format(calendar.getTime());
        return res;
    }  //
    @SneakyThrows
    @Override
    public int getMonthFromDate(String date) {
        SimpleDateFormat df = new SimpleDateFormat("EEE, dd MMM yyyy", Locale.ENGLISH);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(df.parse(date));
        return calendar.get(Calendar.MONTH)+1;
    }  //
    @SneakyThrows
    @Override
    public String findBiggestDate(String date1, String date2, String date3) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        Calendar c3 = Calendar.getInstance();
        c1.setTime(df.parse(date1));
        c2.setTime(df.parse(date2));
        c3.setTime(df.parse(date3));
        Calendar max = Collections.max(Arrays.asList(c1, c2, c3));


        return df.format(max.getTime());

    } //

    @SneakyThrows
    @Override
    public String getLastDayOfTheMonth(String date) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate d = LocalDate.parse(date, df);
        LocalDate lastDay = d.with(TemporalAdjusters.lastDayOfMonth());

        return lastDay.format(df);
    } //

    @SneakyThrows
    @Override
    public String sumTimes(String time1, String time2) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime t1 = LocalTime.parse(time1);
        LocalTime t2 = LocalTime.parse(time2);
        LocalTime res = t1.plusHours(t2.getHour()).plusMinutes(t2.getMinute()).plusSeconds(t2.getSecond());
        return res.format(df);
    }  //

    @SneakyThrows
    @Override
    public String getDateAfter2Weeks(String date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(df.parse(date));
        calendar.add(Calendar.WEEK_OF_MONTH, 2);

        return df.format(calendar.getTime());
    }  //

    @Override
    public long getNumberOfDaysBetweenTwoDates(String date1, String date2) {
        LocalDate d1 = LocalDate.parse(date1);
        LocalDate d2 = LocalDate.parse(date2);

        return Duration.between(d1.atStartOfDay(), d2.atStartOfDay()).toDays();

    }  //

    @Override
    public String[] getTheNextAndPreviousFriday(String date) {
        LocalDate ld = LocalDate.parse(date);
        LocalDate next = ld.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        LocalDate prev = ld.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));

        return new String[]{prev.toString(), next.toString()};
    }  //

    @Override
    public int getNumberOfMonthsRemainingInTheYear(String date) {
        LocalDate ld = LocalDate.parse(date);
        LocalDate lastDay = ld.with(TemporalAdjusters.lastDayOfYear());
        Period period = Period.between(ld, lastDay);

        return period.getMonths();
    }  //
}
