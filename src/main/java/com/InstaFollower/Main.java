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

        driver.findElement(By.xpath("//*[@id=\"login-view\"]/div[2]/div/div[3]/div/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"login-view\"]/div[2]/div/div[4]/div/div/div/button[1]/div")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div[2]/div/div/div[2]/div[2]/div[1]/div/div[1]/div[5]/button/div")).click();

//        try {
//            Thread.sleep(3000);
            driver.findElement(By.xpath("'//*[@id=\"modal\"]/div[2]/div/div/div/div[2]/div[1]/div/input"));

//        }
//        catch(Exception e) {
//            System.out.println("Failed");
//        }
    }
}
