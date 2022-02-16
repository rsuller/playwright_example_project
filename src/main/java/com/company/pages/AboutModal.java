package com.company.pages;

import com.microsoft.playwright.Page;

public class AboutModal {
    protected Page page;

    public AboutModal(Page page) {
        this.page = page;
    }

    /**
     * The HLS video embedded in this modal does not seem to be accessible via automation.
     * So in this scenario, we'll just ensure this video exists by returning true if the unique id is present.
     *
     * @return true/false for video presence
     */
    public boolean confirmVideoIsPresent() {
        return page.locator("div > video").getAttribute("id")
                .equalsIgnoreCase("example-video_html5_api");
    }
}
