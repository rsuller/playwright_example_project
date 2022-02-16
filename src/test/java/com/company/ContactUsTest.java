package com.company;

import com.company.pages.ContactModal;
import com.company.pages.HomePage;
import org.junit.Test;

public class ContactUsTest extends Hooks {

    /**
     * There is no validation present on this modal. The only chance this test has of failing is if the
     * modal does not load and the steps cannot be completed.
     * Hence, no assertion.
     */
    @Test
    public void completeContactUsDetails() {
        HomePage homePage = new HomePage(page);

        homePage.clickContact();

        ContactModal contactModal = new ContactModal(page);

        contactModal.enterContactEmailAndName("Test User", "someuser@someaddress.com");
        contactModal.enterMessage("Hi, let me know when you get the new iphone please.");

    }

    @Test
    public void cancelMessage() {
        HomePage homePage = new HomePage(page);

        homePage.clickContact();

        ContactModal contactModal = new ContactModal(page);

        contactModal.closeMessage();
    }
}
