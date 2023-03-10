package com.InstaFollower;

// Randomizer Imports
import com.InstaFollower.Randomizers.randomDates;
import com.InstaFollower.Randomizers.randomUsername;
import com.InstaFollower.Randomizers.randomPassword;

// Bot imports
import com.InstaFollower.EmailBot.EmailBot;
import com.InstaFollower.InstaBot.InstaBot;

// Selenium Imports
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        randomDates dateRan = new randomDates("month","day","year");
        boolean isEmail = true;
        randomUsername ranUsername = new randomUsername();
        randomPassword ranPassword = new randomPassword();
        String emailUsername = ranUsername.randomUsername(isEmail);
        String emailPassword = ranPassword.randomPassword();
        String instaUsername = ranUsername.randomUsername(!isEmail);
        String instaPassword = ranPassword.randomPassword();
        String firstname = "DavidSmith";
        String lastname = "Garcia";
        String month = dateRan.randomDates("month");
        String day = dateRan.randomDates("day");
        String year = dateRan.randomDates("year");


        // Define the path to the chrome webdriver
        System.setProperty("webdriver.chrome.driver", "src\\main\\java\\com\\WebDriver\\chromedriver-110-0-5481-77.exe");
        WebDriver driver = new ChromeDriver();

        // Initialize both bots
        EmailBot EmailBot1 = new EmailBot(emailUsername,emailPassword,driver);
        InstaBot InstaBot1 = new InstaBot(instaUsername,instaPassword,firstname,lastname,day,month,year,driver,EmailBot1);

        // Run the bots (at the moment only one at a time)
        EmailBot1.runEmailBot();
        InstaBot1.runInstaBot();
    }

}
