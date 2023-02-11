package com.InstaFollower;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // Define the path to the chrome webdriver
        System.setProperty("webdriver.chrome.driver", "D:\\MyGit\\InstaFollower\\src\\main\\java\\com\\WebDriver\\chromedriver-110-0-5481-77.exe");
        WebDriver driver = new ChromeDriver();

        // Open the desired webpage
        driver.get("https://mail.tutanota.com/login?noAutoLogin=true");

        driver.findElement(By.id("//*[@id=\"login-view\"]/div[2]/div/div[1]/form/div[1]/div/div/div/div/div/input"));

        // Close the driver instance
        //Thread.sleep(60000);
        driver.quit();
    }
}
