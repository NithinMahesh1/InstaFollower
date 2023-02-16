package com.InstaFollower;
import com.InstaFollower.EmailBot.EmailBot;

// Selenium Imports
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // Define the path to the chrome webdriver
        System.setProperty("webdriver.chrome.driver", "D:\\MyGit\\InstaFollower\\src\\main\\java\\com\\WebDriver\\chromedriver-110-0-5481-77.exe");
        WebDriver driver = new ChromeDriver();

        // One of Created Users
        // DavidSmithMasterFighter
        // Charles

        EmailBot bot1 = new EmailBot("NahBruhWeCoolWithIt","EggMcChickenISNice",driver);
        bot1.runEmailBot();
    }
}
