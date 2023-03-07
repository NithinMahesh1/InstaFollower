package com.InstaFollower.InstaBot;

import com.InstaFollower.EmailBot.EmailBot;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InstaBot {
    String username;
    String password;
    String firstname;
    String lastname;
    String month;
    String day;
    String year;
    WebDriver driver;
    EmailBot bot;

    /*
    * TODO
    *   Need to add either abstract class or interface (can't think of which one at the moment)
    *   So that we have one Main Object Class BOT and we extend or implement it with emailbot and instabot
    *   As such:
    *       interface BOT(String username, String password, Webdriver driver)
    *           EmailBot() extends BOT {}
    *           InstaBot() extends BOT {}
    * */

    public InstaBot(String username, String password, String firstname, String lastname, String day, String month, String year, WebDriver driver, EmailBot bot) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.month = month;
        this.day = day;
        this.year = year;
        this.driver = driver;
        this.bot = bot;
    }

    public void runInstaBot() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.instagram.com/accounts/emailsignup/");

        // Sign up main page
        Thread.sleep(3000);
        WebElement emailInput = driver.findElement(By.name("emailOrPhone"));
        WebElement fullname = driver.findElement(By.name("fullName"));
        WebElement usernameElem = driver.findElement(By.name("username"));
        WebElement passwordElem = driver.findElement(By.name("password"));
        WebElement signUpButton = driver.findElement(By.xpath("//button[contains(text(), 'Sign up')]"));

        Thread.sleep(3000);
        emailInput.sendKeys(username + "@tutanota.com");
        fullname.sendKeys(firstname + " " + lastname);
        usernameElem.sendKeys(username);
        passwordElem.sendKeys("nahbutTh1$!");
        signUpButton.click();

        // Birthday inputs second menu
        // Find the elements for the day, month, and year dropdown menus
        Thread.sleep(2000);
        WebElement dayDropdown = driver.findElement(By.xpath("//select[@title='Day:']"));
        WebElement monthDropdown = driver.findElement(By.xpath("//select[@title='Month:']"));
        WebElement yearDropdown = driver.findElement(By.xpath("//select[@title='Year:']"));
        WebElement nextButtonBdayMenu = driver.findElement(By.xpath("//button[contains(text(), 'Next')]"));

        // Use the Select class to create a selector for each dropdown
        Select daySelector = new Select(dayDropdown);
        Select monthSelector = new Select(monthDropdown);
        Select yearSelector = new Select(yearDropdown);

        // Select the desired values for day, month, and year
        daySelector.selectByValue(day);
        monthSelector.selectByValue(month);
        yearSelector.selectByValue(year);
        nextButtonBdayMenu.click();

        /*
        * TODO - There is an email confirmation code input menu
        *      - Need to run a method in EmailBot to log into email account
        *      - Open tutanota in second tab to select the first email and grab code
        *      - Close second tutanota tab
        *      - Enter code into confirmation code input field
        *      - Hit next button
        * */

        bot.loginEmail(driver, username, password);
        String generatedCode = bot.getInstaConfirmationCode(driver);

        //WebElement confirmcodefield = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//aria-label[@name='Confirmation Code']")));

        //WebElement confirmcodefield = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='email_confirmation_code']")));
        Thread.sleep(10000);
       // WebElement confirmcodefield = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("_aaie")));

        WebElement confirmcodefield = driver.findElement(By.xpath("//input[@aria-label='Confirmation Code']"));
//        WebElement confirmcodefield = driver.findElement(By.xpath("//input[contains(text(), 'Confirmation Code')]"));
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Next')]")));

        confirmcodefield.sendKeys(generatedCode);
        nextButton.click();
    }
}
