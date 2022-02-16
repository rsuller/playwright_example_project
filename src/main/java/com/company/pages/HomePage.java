package com.company.pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HomePage {

    protected Page page;

    public HomePage(Page page) {
        this.page = page;

    }

    public String getNavBarText() {
        // Leading White Space in this element due to logo - use trim()
        // Otherwise this fails
        String navBarHeading = "#nava";
        return page.innerText(navBarHeading).trim();
    }

    public int getNumberOfMobilePhones() {
        // Get all the products
        // Each product has the class 'card-block' when displayed
        String listedProducts = ".card-block";
        return page.querySelectorAll(listedProducts).size();
    }

    public void clickPhonesFilter() {
        page.locator("text=Phones").click();
    }

    public void clickMonitorFilter() {
        page.locator("text=Monitors").click();
    }

    public void clickLaptopFilter() {
        page.locator("text=Laptops").click();
    }

    public void selectSignUp() {
        page.locator("#signin2").click();
    }

    public void signUpUser(String username, String password) {
        page.locator("#sign-username").fill(username);
        page.locator("#sign-password").fill(password);
        page.locator("button:has-text(\"Sign up\")").click();

    }

    public void logInUser(String username, String password) {
        page.locator("#login2").click();
        page.locator("#loginusername").fill(username);
        page.locator("#loginpassword").fill(password);
        page.locator("button:has-text(\"Log in\")").click();

    }

    public void logOutUser() {
        page.locator("#logout2").click();
    }

    public void selectMobilePhone(String mobilePhone) {
        clickPhonesFilter();
        matchLinkTextWithString(mobilePhone);
    }

    public void selectLaptop(String laptop) {
        clickLaptopFilter();
        matchLinkTextWithString(laptop);
    }

    public void selectMonitor(String monitor) {
        clickMonitorFilter();
        matchLinkTextWithString(monitor);

    }

    public void clickAboutUs() {
        page.locator(".nav-link:has-text('About us')").click();

    }

    public void clickContact() {
        page.locator(".nav-link:has-text('Contact')").click();
    }

    private void matchLinkTextWithString(String stringToMatch) {
        String hasTextString = getHasTextString(stringToMatch);
        page.locator(hasTextString).click();
    }

    private String getHasTextString(String mobilePhone) {
        return "a:has-text(\"" + mobilePhone + "\")";
    }

    public boolean getCarouselImages() {
        List<ElementHandle> imageElements = page.querySelectorAll("div.carousel-item img");

        // List the expected images
        ArrayList<String> expectedImages = new ArrayList<>(Arrays.asList("Samsung1.jpg", "nexus1.jpg", "iphone1.jpg"));
        ArrayList<String> images = new ArrayList<>();

        for (ElementHandle imageElement : imageElements) {
            String src = imageElement.getAttribute("src");
            System.out.println(src);
            // Populate the list with the actual images
            images.add(src);

        }
        // Compare the two lists for equality
        return expectedImages.equals(images);
    }
}
