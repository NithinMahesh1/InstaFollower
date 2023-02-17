package com.InstaFollower;

// Bot imports
import com.InstaFollower.EmailBot.EmailBot;
import com.InstaFollower.InstaBot.InstaBot;

// Selenium Imports
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
    One of Created Users

    DavidSmithMasterFighter
    Charles
*/

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // Define the path to the chrome webdriver
        System.setProperty("webdriver.chrome.driver", "src\\main\\java\\com\\WebDriver\\chromedriver-110-0-5481-77.exe");
        WebDriver driver = new ChromeDriver();

        // Initialize both bots
        EmailBot EmailBot1 = new EmailBot("NahBruhWeCoolWithIt","Charles",driver);
        InstaBot InstaBot1 = new InstaBot("DavidSmithMasterFighter","fightorlgithsg4615661!!", "Charles",driver,EmailBot1);

        // Run the bots (at the moment only one at a time)
        EmailBot1.runEmailBot();
        //InstaBot1.runInstaBot();
    }
}
