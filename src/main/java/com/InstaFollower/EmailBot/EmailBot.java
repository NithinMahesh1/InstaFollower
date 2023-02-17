package com.InstaFollower.EmailBot;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class EmailBot {
    String username;
    String password;
    WebDriver driver;

    public EmailBot(String username, String password, WebDriver driver) {
        this.username = username;
        this.password = password;
        this.driver = driver;
    }

    public void runEmailBot() throws InterruptedException {
        // Open the desired webpage
        driver.get("https://mail.tutanota.com/login?noAutoLogin=true");

        Thread.sleep(1000);
        // Clicks the More Option
        driver.findElement(By.xpath("//*[@id=\"login-view\"]/div[2]/div/div[3]/div/button")).click();

        // Clicks the SignUpButton to open dialog
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"login-view\"]/div[2]/div/div[4]/div/div/div/button[1]/div")).click();

        // Clicks the free account button in dialog
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div[2]/div/div/div[2]/div[2]/div[1]/div/div[1]/div[5]/button/div")).click();

        // Clicks the "I do not own any other Free Account" checkbox
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"modal\"]/div[2]/div/div/div/div[2]/div[1]/div/input")).click();

        // Clicks the "I will not use this account for business" checkbox
        driver.findElement(By.xpath("//*[@id=\"modal\"]/div[2]/div/div/div/div[2]/div[2]/div/input")).click();

        // Clicks the ok button to close dialog
        driver.findElement(By.xpath("//*[@id=\"modal\"]/div[2]/div/div/div/div[3]/button[2]/div")).click();

        // Inputs the username/email name into Email Address input field
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"signup-account-dialog\"]/div/div[1]/div/div/div/div[1]/input")).sendKeys(username);

        // Inputs the password into Set Password input field
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"signup-account-dialog\"]/div/div[2]/div[1]/div/div/div/div[1]/input")).sendKeys(password);

        // Checks the "I have read terms" checkbox
        driver.findElement(By.xpath("//*[@id=\"signup-account-dialog\"]/div/div[3]/div/input")).click();

        // Checks the "I am at least 16 years old" checkbox
        driver.findElement(By.xpath("//*[@id=\"signup-account-dialog\"]/div/div[4]/div/input")).click();

        // Clicks the Next button to submit
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"signup-account-dialog\"]/div/div[5]/button/div")).click();

        // Clicks ok button after user is created, assuming we do not hit the captcha clock dialog
        Thread.sleep(20000);
        driver.findElement(By.xpath("//*[@id=\"wizardDialogContent\"]/div[4]/div/button")).click();

        // Inputs new users Email Address into login input dialog
        driver.findElement(By.xpath("//*[@id=\"login-view\"]/div[2]/div/div[1]/form/div[1]/div/div/div/div/div/input")).sendKeys(username + "@tutanota.com");

        // Inputs new users Password into password input dialog
        driver.findElement(By.xpath("//*[@id=\"login-view\"]/div[2]/div/div[1]/form/div[2]/div/div/div/div/div/input")).sendKeys(password);

        // Clicks the Log In button
        driver.findElement(By.xpath("//*[@id=\"login-view\"]/div[2]/div/div[1]/form/div[4]/button")).click();

        driver.quit();
    }

    public void loginEmail(WebDriver driver1) {
        // Create a new instance of the Actions class
        Actions actions = new Actions(driver1);

        // Simulate pressing the "Control" key and the "T" key simultaneously
        actions.sendKeys(Keys.CONTROL, "t").build().perform();

        // Get handles of all the tabs
        Set<String> handles = driver1.getWindowHandles();

        // Switch to the last tab
        for (String handle : handles) {
            driver1.switchTo().window(handle);
        }

        // Navigate to the second page
        driver1.get("https://mail.tutanota.com/");
    }
}
