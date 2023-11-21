package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    /**
     * 1. userShouldLoginSuccessfullyWithValidCredentials * Enter “tomsmith” username
     * * Enter “SuperSecretPassword!” password
     * * Click on ‘LOGIN’ button
     * * Verify the text “Secure Area”
     */
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //Entering Username - 'tomsmith'
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //Entering password - 'SuperSecretPassword!'
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        //Click on Login button
        driver.findElement(By.xpath("//button[@class='radius']")).click();

        //Finding actual text and get text from element
        String expectedText = "Secure Area";
        WebElement actualTextElement = driver.findElement(By.tagName("h2"));
        String actualText = actualTextElement.getText();
        //Verify expected and actual using Assert
        Assert.assertEquals("Error message", expectedText, actualText);
    }

    /**
     * 2. verifyTheUsernameErrorMessage
     * * Enter “tomsmith1” username
     * * Enter “SuperSecretPassword!” password
     * * Click on ‘LOGIN’ button
     * * Verify the error message “Your username is invalid!”
     */
    @Test
    public void verifyTheUsernameErrorMessage() {
        //Enter “tomsmith1” username
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        //Enter “SuperSecretPassword!” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        //Verify error message Your username is invalid!
        //Finding actual text and get text from element
        String expectedText = "Your username is invalid!\n" + "×";
        WebElement actualTextElement = driver.findElement(By.id("flash"));
        String actualText = actualTextElement.getText();
        //Verify expected and actual using Assert
        Assert.assertEquals("Error message", expectedText, actualText);
    }

    /**
     * verifyThePasswordErrorMessage
     * * Enter “tomsmith” username
     * * Enter “SuperSecretPassword” password
     * * Click on ‘LOGIN’ button
     * * Verify the error message “Your password is invalid!”
     */
    @Test
    public void verifyThePasswordErrorMessage() {
        //Entering Username - 'tomsmith'
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //Enter “SuperSecretPassword” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        //Verify the error message “Your password is invalid!”
        String expectedText = "Your password is invalid!\n" + "×";
        WebElement actualTextElement = driver.findElement(By.id("flash"));
        String actualText = actualTextElement.getText();
        //Verify expected and actual using Assert
        Assert.assertEquals("Error message", expectedText, actualText);

    }

    @After
    public void setDown() {
        closeBrowser();
    }
}
