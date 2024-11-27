package testsuite;

/**
 * Create the package ‘testsuite’ and create the
 * following class inside the ‘testsuite’ package.
 * 1. LoginTest
 * 4. Write down the following test in the ‘LoginTest’
 * class
 * 1. userSholdLoginSuccessfullyWithValid
 * Credentials()
 * * Enter “standard_user” for the username
 * * Enter “secret_sauce” for the password
 * * Click on the ‘Login’ button
 * * Verify the text “Products”
 * 2. verifyThatSixProductsAreDisplayedOnPage()
 * * Enter “standard_user” for the username
 * * Enter “secret_sauce” for the password
 * * Click on the ‘Login’ button
 * * Verify that six products are displayed on page
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {


    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        // Enter “standard_user” for the username
        sendTextOnElement(By.id("user-name"), "standard_user");

        //Enter “secret_sauce” for the password
        sendTextOnElement(By.id("password"), "secret_sauce");

        // Click on log in button
        clickOnElement(By.id("login-button"));

        // Verify the text “Products”
        String expectedText = "Products";

        Assert.assertEquals("Product text is not match", expectedText, getTextFromElement(By.xpath("//span[@class='title']")));

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){

        // Enter “standard_user” for the username
        sendTextOnElement(By.id("user-name"), "standard_user");

        //Enter “secret_sauce” for the password
        sendTextOnElement(By.id("password"), "secret_sauce");

        // Click on log in button
        clickOnElement(By.id("login-button"));

        // Verify that six products are displayed on page
        int expectedText = 6;

        Assert.assertEquals("Product text is not match",
                expectedText, getWebElements(By.xpath("//div[@class = 'inventory_item']")).size());
    }


    public void tearDown(){
        closeBrowser();
    }

}
