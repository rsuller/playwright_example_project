package com.company.pages;

import com.microsoft.playwright.Page;

public class CartPage {

    protected Page page;

    public CartPage(Page page) {
        this.page = page;
    }

    public boolean confirmProductAddedToCart(String product) {
        return page.locator("#tbodyid .success > td:has-text(\"" + product + "\")").isVisible();
    }

    public String getCartTotal() {
        return page.locator("#totalp").textContent();
    }

    public void removeItemFromCart() {
        page.locator("text=Delete").click();
    }
}
