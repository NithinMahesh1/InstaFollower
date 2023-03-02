package com.InstaFollower.EmailBot;

// Instafollower Class Imports
import com.InstaFollower.ElementHelper.ElementHelper;

// Selenium class imports
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Java DataStructure class imports
import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        ElementHelper helper = new ElementHelper(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Clicks the More Option
        WebElement moreDropdownButton = helper.findElement(By.className("expander"));
        wait.until(ExpectedConditions.elementToBeClickable(moreDropdownButton)).click();

        // Clicks the signup buttons on main page
        WebElement signUpButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Sign up']")));
        signUpButton.click();

        // Define elements for the second page
        WebElement selectButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Select']")));
        selectButton.click();

        // After select is clicked modal appears then we proceed to click the checkboxes then the "ok" button
        WebElement checkbox1Page2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'I do not own any other Free account')]")));
        WebElement checkbox2page2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'I will not use this account for business')]")));
        WebElement okButtonPage2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Ok']")));

        checkbox1Page2.click();
        checkbox2page2.click();
        okButtonPage2.click();

        // Now we send keys to the email addy and the set password input fields
        Thread.sleep(2000);
        WebElement emailAddyField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@aria-label='Email address']")));
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@aria-label='Set password']")));
        WebElement checkbox1Page3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'I have read and agree to the following documents')]")));
        WebElement checkbox2Page3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'I am at least 16 years old')]")));
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Next']")));

        // Click the two checkboxes on signup screen and then hit next button
        emailAddyField.sendKeys(username);
        passwordField.sendKeys(password);
        checkbox1Page3.click();
        checkbox2Page3.click();
        Thread.sleep(5000);
        nextButton.click();

        // After input field we get to the last page 3 and click the "Ok" button
        // TODO - how do we get past the clock captcha
        Thread.sleep(22000);
        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Ok']")));
        okButton.click();

        driver.quit();
    }

    public void loginEmail(WebDriver driver1, String usernameInsta, String passwordInsta) throws InterruptedException {
        Thread.sleep(1000);
        driver1.switchTo().newWindow(WindowType.TAB);
        driver1.get("https://mail.tutanota.com/login");

        WebElement emailAddy = driver.findElement(By.xpath("//input[@type='email']"));
        WebElement passwordInputs = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement loginEmailButton = driver.findElement(By.xpath("//button[@title='Log in']"));

        emailAddy.sendKeys(usernameInsta + "@tutanota.com");
        passwordInputs.sendKeys(password);
        loginEmailButton.click();
    }

    public String getInstaConfirmationCode(WebDriver driver2) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Thread.sleep(13000);
        WebElement instagramEmail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Instagram code')]")));
        instagramEmail.click();

        WebElement titlebarcode = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'is your Instagram code')]")));
        String titlefullstr = titlebarcode.getText();

        Pattern pattern = Pattern.compile("^\\d+"); // match one or more digits at the beginning of the string
        Matcher matcher = pattern.matcher(titlefullstr);

        String confirmationCode = "";
        if (matcher.find()) {
            confirmationCode = matcher.group(); // get the matched digits
        } else {
            System.out.println("Confirmation code not found");
        }

        driver.close();

        return confirmationCode;
    }
}
