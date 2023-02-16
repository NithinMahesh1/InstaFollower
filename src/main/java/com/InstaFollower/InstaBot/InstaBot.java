package com.InstaFollower.InstaBot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InstaBot {
    String username;
    String password;
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

    public InstaBot(String username, String password, WebDriver driver) {
        this.username = username;
        this.password = password;
        this.driver = driver;
    }

    public void runInstaBot() throws InterruptedException {
        driver.get("https://www.instagram.com/accounts/emailsignup/");

        // Input for tutanota email created on EmailBot
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"mount_0_0_oM\"]/div/div/div/div[1]/div/div/div/div[1]/section/main/div/div/div[1]/div[2]/form/div[3]/div/label/input")).sendKeys(username+"@tutanota.com");

        // Full name input
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"mount_0_0_oM\"]/div/div/div/div[1]/div/div/div/div[1]/section/main/div/div/div[1]/div[2]/form/div[4]/div/label/input")).sendKeys("David Smithster");

        // username input
        driver.findElement(By.xpath("//*[@id=\"mount_0_0_oM\"]/div/div/div/div[1]/div/div/div/div[1]/section/main/div/div/div[1]/div[2]/form/div[5]/div/label/input")).sendKeys(username);

        // password input
        driver.findElement(By.xpath("//*[@id=\"mount_0_0_oM\"]/div/div/div/div[1]/div/div/div/div[1]/section/main/div/div/div[1]/div[2]/form/div[6]/div/label/input")).sendKeys(password);

        // click sign up button
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"mount_0_0_oM\"]/div/div/div/div[1]/div/div/div/div[1]/section/main/div/div/div[1]/div[2]/form/div[7]/div/button")).click();
    }
}
