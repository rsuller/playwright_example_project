package com.company.pages;

import com.microsoft.playwright.Page;

public class ContactModal {
    protected Page page;

    public ContactModal(Page page) {
        this.page = page;
    }

    public void enterContactEmailAndName(String email, String contactName) {
        page.locator("#recipient-email").fill(email);
        page.locator("#recipient-name").fill(contactName);
    }

    public void enterMessage(String message) {
        page.locator("#message-text").fill(message);
        page.locator("button:has-text('Send message')").click();
    }

    public void closeMessage() {
        page.locator(":nth-match(button:has-text('Close'), 1)").click();
    }
}
