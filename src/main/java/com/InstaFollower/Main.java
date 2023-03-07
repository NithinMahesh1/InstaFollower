package com.InstaFollower;

// Bot imports
import com.InstaFollower.EmailBot.EmailBot;
import com.InstaFollower.InstaBot.InstaBot;

// Selenium Imports
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    Created Users:

    DavidSmithMasterFighter
    Charles

    bangarang99neighbors@tutanota.com
    bmwM5csdroptop1$

    Jackthebeaniemeanie4@tutanota.com
    a$apt1lldeathofme

    nohesi
    nohe$1cutuP


    2_28_2023 - First successful emailbot created fully automated
        * This is the user: bangarang99neighbors password: bmwM5csdroptop1$
*/

public class Main {

    public static void main(String[] args) throws InterruptedException {
        String username = "DavidSmithMasterFighter";
        String password = "Charles";
        String firstname = "DavidSmith";
        String lastname = "Garcia";
        String month = "12";
        String day = "13";
        String year = "1999";

        // Define the path to the chrome webdriver
        System.setProperty("webdriver.chrome.driver", "src\\main\\java\\com\\WebDriver\\chromedriver-110-0-5481-77.exe");
        WebDriver driver = new ChromeDriver();

        // Create random int for DB
        //randomIntGenerator();
//        websitenames(driver);

        // Initialize both bots
        EmailBot EmailBot1 = new EmailBot(username,password,driver);
        InstaBot InstaBot1 = new InstaBot(username,password,firstname,lastname,day,month,year,driver,EmailBot1);

        // Run the bots (at the moment only one at a time)
//        EmailBot1.runEmailBot();
        InstaBot1.runInstaBot();
    }

    public static int randomIntGenerator() {
        Random r = new Random();
        int min = 100000;
        int max = 1000000;
        int id = r.nextInt((max-min)+1) +min;

        System.out.println(id);
        return id;
    }

    public static void websitenames(WebDriver driver) {

        driver.get("https://www.al.com/news/2019/10/50-most-common-last-names-in-america.html");
        // Find the table element on the page
        WebElement table = driver.findElement(By.tagName("div"));

        // Find all rows in the table
        List<WebElement> rows = table.findElements(By.tagName("p"));

        // Define the regular expression pattern to match names
        Pattern pattern = Pattern.compile("([A-Z][a-z]+)\\s+([A-Z][a-z]+)");



        // Loop through the paragraphs and extract the names
//        Map<Integer, String> names = new HashMap<Integer, String>();
//        for (WebElement paragraph : paragraphs) {
//            String text = paragraph.getText();
//            Matcher matcher = pattern.matcher(text);
//            while (matcher.find()) {
//                String name = matcher.group(0);
//                int userid = randomIntGenerator(); // Replace with your own logic for generating user IDs
//                names.put(userid, name);
//            }
//        }


        Map<Integer, String> names = new HashMap<Integer, String>();
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.size() >= 2) { // Ensure there are at least two cells per row
                String name = cells.get(1).getText();
                Matcher matcher = pattern.matcher(name);
                if (matcher.find()) {
                    int userid = randomIntGenerator(); // Replace with your own logic for generating user IDs
                    names.put(userid, matcher.group(0));
                }
            }
        }

        // Close the Selenium WebDriver
        driver.quit();

    }
}
