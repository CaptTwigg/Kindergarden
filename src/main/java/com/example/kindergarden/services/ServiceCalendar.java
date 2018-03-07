package com.example.kindergarden.services;

import java.util.*;

public class ServiceCalendar {

  private Calendar calendar = new GregorianCalendar();
  int dateToday = calendar.get(Calendar.DAY_OF_MONTH);
  private String[] months = {"Januar", "Februar", "Marts", "April", "Maj", "Juni", "Juli", "August", "September", "Oktober", "November", "December"};
  private int[] days = new int[42];
  private boolean[] daysInThisMonth = new boolean[42];
  private String[] dateArray = new String[42];
  int weekdays = 0;

  private void listCalendar(){
    int counter = 0;

    /*--- Forrige måned ---*/
    //Sætter datoen til den første i måneden
    calendar.set(Calendar.DAY_OF_MONTH, 1);

    //Regner ud hvor mange dage der skal udskrives af den forrige måned
    weekdays = (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ? 6 : calendar.get(Calendar.DAY_OF_WEEK)-2);

    //Trækker dage fra kalenderen
    calendar.add(Calendar.DAY_OF_MONTH, -weekdays);

    for(int i = 0; i < weekdays; i++) {
      days[counter] = calendar.get(Calendar.DAY_OF_MONTH);
      daysInThisMonth[counter] = false;
      dateArray[counter] = "";
      calendar.add(Calendar.DAY_OF_MONTH, 1);
      counter++;
    }

    String thisMonth = String.valueOf((calendar.get(Calendar.MONTH)+1) < 10 ? "0"+(calendar.get(Calendar.MONTH)+1) : calendar.get(Calendar.MONTH)+1);
    int thisYear = calendar.get(Calendar.YEAR);

    //Nuværende måned
    for (int i = 1; i <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
      days[counter] = i;
      daysInThisMonth[counter] = true;
      dateArray[counter] = String.valueOf(thisYear + "-" + thisMonth + "-" + (i < 10 ? "0"+i : i));
      counter++;
    }

    //Næste måned
    for(int i = 1; counter < days.length; i++) {
      days[counter] = i;
      daysInThisMonth[counter] = false;
      dateArray[counter] = "";
      counter++;
    }
  }
  public String getMonthAndYear(){
    listCalendar();
    return String.valueOf(months[calendar.get(Calendar.MONTH)]+" "+calendar.get(Calendar.YEAR));
  }

  public int[] getDays(){
    listCalendar();
    return days;
  }

  public boolean[] getDaysInThisMonth() { return daysInThisMonth; }

  public void decrement(){
    calendar.add(Calendar.MONTH, -1);
  }

  public void increment(){
    calendar.add(Calendar.MONTH, 1);
  }

  public int getToday() {
    return dateToday;
  }

  public String[] getDateArray() {
    return dateArray;
  }

  public int daysToBypass() {
    return weekdays;
  }

  public String getMonthAsString() {
    return String.valueOf(calendar.get(Calendar.MONTH)+1).length() == 1 ? "0"+String.valueOf(calendar.get(Calendar.MONTH)+1) : String.valueOf(calendar.get(Calendar.MONTH)+1);
  }

  public String getYearAsString() {
    return String.valueOf(calendar.get(Calendar.YEAR));
  }
}
