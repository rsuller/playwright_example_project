package com.company;

import com.company.pages.HomePage;
import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Page;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Paths;

public class SignUpTest extends Hooks {


    /**
     * The following test demonstrates the user sign up. The ability to log into the site and also shows that a user is
     * unable to sign up again with the same credentials.
     * The tests validate successful sign up by ensuring the username is displayed on the page.
     *
     * Random usernames created so that this test can be executed more than once without error i.e. User already exists.
     *
     * @throws InterruptedException for thread.sleep()
     */
    @Test
    public void signUpFlow() throws InterruptedException {
        HomePage homePage = new HomePage(page);
        homePage.selectSignUp();

        // Once the user is created this test can only be run once, hence the use of random email account
        String randomEmailPrefix = RandomStringUtils.random(10, true, false);
        String username = randomEmailPrefix + "@someplace.com";
        String password = "secure_password!shh";

        page.onDialog(Dialog::accept);

        homePage.signUpUser(username, password);

        Thread.sleep(DEFAULT_WAIT);

        // Log in with new user
        homePage.logInUser(username, password);

        Thread.sleep(DEFAULT_WAIT);

        // Check content for welcome message
        String htmlContent = page.content();
        Assert.assertTrue(htmlContent.contains("Welcome " + username));

        // Attempt to sign up with the same account
        homePage.logOutUser();
        homePage.selectSignUp();
        homePage.signUpUser(username, password);

        Thread.sleep(DEFAULT_WAIT);

        //Screenshot
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/Sign_Up.jpg")));

        page.onDialog(Dialog::accept);

    }


}
