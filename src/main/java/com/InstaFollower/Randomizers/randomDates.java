package com.InstaFollower.Randomizers;

import org.openqa.selenium.WebDriver;

import java.util.Random;

public class randomDates {
    String month = "";
    String day = "";
    String year = "";

    public randomDates(String month, String day, String year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public static String randomDates(String dateVal) {
        Random r = new Random();

        if(dateVal.equals("month")) {
            int ranInt = r.nextInt((12-1)+1);
            String month = String.valueOf(ranInt);
            dateVal = month;
        }
        if(dateVal.equals("day")) {
            int ranInt = r.nextInt((24)+1);
            String day = String.valueOf(ranInt);
            dateVal = day;
        }
        if(dateVal.equals("year")) {
            int ranInt = r.nextInt(16) + 1989;
            String year = String.valueOf(ranInt);
            dateVal = year;
        }

        return dateVal;
    }
}
