package com.InstaFollower.InstaBot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class InstaBot {
    String username;
    String password;
    String lastname;
    WebDriver driver;

    /*
    * TODO
    *   Need to add either abstract class or interface (can't think of which one at the moment)
    *   So that we have one Main Object Class BOT and we extend or implement it with emailbot and instabot
    *   As such:
    *       interface BOT(String username, String password, Webdriver driver)
    *           EmailBot() extends BOT {}
    *           InstaBot() extends BOT {}
    * */

    public InstaBot(String username, String password, String lastname, WebDriver driver) {
        this.username = username;
        this.password = password;
        this.lastname = lastname;
        this.driver = driver;
    }

    public void runInstaBot() throws InterruptedException {
        driver.get("https://www.instagram.com/accounts/emailsignup/");

        // Sign up main page
        Thread.sleep(3000);
        WebElement emailInput = driver.findElement(By.name("emailOrPhone"));
        WebElement fullname = driver.findElement(By.name("fullName"));
        WebElement usernameElem = driver.findElement(By.name("username"));
        WebElement passwordElem = driver.findElement(By.name("password"));
        WebElement signUpButton = driver.findElement(By.xpath("//button[contains(text(), 'Sign up')]"));

        Thread.sleep(1000);
        emailInput.sendKeys(username + "@tutanota.com");
        fullname.sendKeys(username + " " + lastname);
        usernameElem.sendKeys(username);
        passwordElem.sendKeys(password);
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
        daySelector.selectByValue("1");
        monthSelector.selectByValue("11");
        yearSelector.selectByValue("1997");
        nextButtonBdayMenu.click();

        /*
        * TODO - There is an email confirmation code input menu
        *      - Need to run a method in EmailBot to log into email account
        *      - Open tutanota in second tab to select the first email and grab code
        *      - Close second tutanota tab
        *      - Enter code into confirmation code input field
        *      - Hit next button
        * */
    }
}
