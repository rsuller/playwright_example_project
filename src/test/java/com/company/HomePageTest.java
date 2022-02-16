package com.company;

import com.company.pages.HomePage;
import com.microsoft.playwright.Page;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Paths;

public class HomePageTest extends Hooks {


    @Test
    public void confirmUserIsOnHomePage() {
        HomePage homePage = new HomePage(page);

        // Firstly confirm Page title is correct
        Assert.assertEquals("STORE", page.title());

        // Then check heading
        Assert.assertEquals(homePage.getNavBarText(), "PRODUCT STORE");

        //Screenshot
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/Home_Page.jpg")));

    }

    @Test
    public void phoneCount() throws InterruptedException {
        HomePage homePage = new HomePage(page);

        homePage.clickPhonesFilter();

        // Quite literally thrown up in my own mouth at this usage!
        Thread.sleep(DEFAULT_WAIT);

        int numberOfPhones = homePage.getNumberOfMobilePhones();
        System.out.println(numberOfPhones);

        //Screenshot
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/Mobile_Filter.jpg")));

        // Get count of mobile phone products
        Assert.assertEquals(7, numberOfPhones);

    }

    @Test
    public void monitorCount() throws InterruptedException {
        HomePage homePage = new HomePage(page);

        homePage.clickMonitorFilter();

        // Quite literally thrown up in my own mouth at this usage!
        Thread.sleep(DEFAULT_WAIT);

        int numberOfMonitors = homePage.getNumberOfMobilePhones();
        System.out.println(numberOfMonitors);

        //Screenshot
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/Monitor_Filter.jpg")));

        // Get count of mobile phone products
        Assert.assertEquals(2, numberOfMonitors);

    }

    @Test
    public void laptopsCount() throws InterruptedException {
        HomePage homePage = new HomePage(page);

        homePage.clickLaptopFilter();

        // Quite literally thrown up in my own mouth at this usage!
        Thread.sleep(DEFAULT_WAIT);

        int numberOfLaptops = homePage.getNumberOfMobilePhones();
        System.out.println(numberOfLaptops);

        //Screenshot
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/Laptop_Filter.jpg")));

        // Get count of mobile phone products
        Assert.assertEquals(6, numberOfLaptops);

    }

    @Test
    public void testCarouselImages() {
        HomePage homePage = new HomePage(page);

        Assert.assertTrue(homePage.getCarouselImages());
    }
}
