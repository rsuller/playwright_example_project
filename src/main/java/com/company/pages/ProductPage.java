package com.company.pages;

import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Page;

public class ProductPage {

    protected Page page;

    public ProductPage(Page page) {
        this.page = page;
    }

    public String getProductDescription() {
        return page.locator("div #more-information > p").textContent().trim();
    }

    public String getPrice() {
        return page.locator("h3.price-container").textContent().trim();
    }

    public void addProductToCart() {
        page.locator("text=Add to cart").click();
//        page.onDialog(Dialog::accept);
    }

    public void clickCart() {
        page.locator("#cartur").click();
    }

    public void returnToHomePage() {
        page.locator("a:has-text('Home')").click();
    }
}
