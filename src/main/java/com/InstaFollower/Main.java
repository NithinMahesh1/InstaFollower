package com.InstaFollower;

// Bot imports
import com.InstaFollower.EmailBot.EmailBot;
import com.InstaFollower.InstaBot.InstaBot;

// Selenium Imports
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
    Created Users:

    DavidSmithMasterFighter
    Charles

    bangarang99neighbors@tutanota.com
    bmwM5csdroptop1$

    Jackthebeaniemeanie4
    a$apt1lldeathofme

    nohesi
    nohe$1cutuP


    2_28_2023 - First successful emailbot created fully automated
        * This is the user: bangarang99neighbors password: bmwM5csdroptop1$
*/

public class Main {

    public static void main(String[] args) throws InterruptedException {
        String username = "bangarang99neighbors";
        String password = "bmwM5csdroptop1$";
        String lastname = "NireoMac";
        String month = "1";
        String day = "1";
        String year = "2004";


        // Define the path to the chrome webdriver
        System.setProperty("webdriver.chrome.driver", "src\\main\\java\\com\\WebDriver\\chromedriver-110-0-5481-77.exe");
        WebDriver driver = new ChromeDriver();

        // Initialize both bots
        EmailBot EmailBot1 = new EmailBot(username,password,driver);
        InstaBot InstaBot1 = new InstaBot(username,password,lastname,day,month,year,driver,EmailBot1);

        // Run the bots (at the moment only one at a time)
//        EmailBot1.runEmailBot();
        InstaBot1.runInstaBot();
    }
}
