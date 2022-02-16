package com.company;

import com.company.pages.AboutModal;
import com.company.pages.HomePage;
import com.microsoft.playwright.Page;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Paths;

public class AboutTest extends Hooks {

    /**
     * Test confirms that the About html video provided by BlazeMeter is present
     */
    @Test
    public void confirmAboutDetails() throws InterruptedException {
        HomePage homePage = new HomePage(page);

        homePage.clickAboutUs();

        AboutModal aboutModal = new AboutModal(page);
        Thread.sleep(DEFAULT_WAIT);
        Assert.assertTrue(aboutModal.confirmVideoIsPresent());

        //Screenshot
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/About_Video.jpg")));

    }


}
