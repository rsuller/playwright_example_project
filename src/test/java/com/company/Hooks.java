package com.company;

import com.microsoft.playwright.*;
import org.junit.After;
import org.junit.Before;

public class Hooks {

    public static int DEFAULT_WAIT = 2000;


    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    // Set up
    @Before
    public void setupPlaywright() {
        playwright = Playwright.create();
        // Set browser to run in "head full" mode
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(200)
                .setDevtools(false));

        // Go to site - demo blaze in this instance
        page = browser.newPage();
        page.setViewportSize(1920, 1080);

        page.navigate("https://www.demoblaze.com/");

    }

    // Tear down
    @After
    public void teardownPlaywright() {
        page.close();
        playwright.close();

    }
}
