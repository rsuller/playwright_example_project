package com.company;

import com.company.pages.CartPage;
import com.company.pages.HomePage;
import com.company.pages.ProductPage;
import org.junit.Assert;
import org.junit.Test;

public class ProductOrderTest extends Hooks {

    @Test
    public void mobileDescriptionTest() {
        HomePage homePage = new HomePage(page);

        homePage.selectMobilePhone("Samsung galaxy s6");

        ProductPage productPage = new ProductPage(page);

        // Match Product Description
        Assert.assertEquals("The Samsung Galaxy S6 is powered by 1.5GHz octa-core Samsung Exynos 7420\n" +
                " processor and it comes with 3GB of RAM. The phone packs 32GB of \n" +
                "internal storage cannot be expanded.", productPage.getProductDescription());

        // Match Price
        Assert.assertTrue(productPage.getPrice().contains("$360"));
    }

    @Test
    public void addProductToCart() throws InterruptedException {
        HomePage homePage = new HomePage(page);

        homePage.selectLaptop("MacBook air");

        ProductPage productPage = new ProductPage(page);

        productPage.addProductToCart();
        productPage.clickCart();

        CartPage cartPage = new CartPage(page);
        Thread.sleep(DEFAULT_WAIT);
        Assert.assertTrue(cartPage.confirmProductAddedToCart("MacBook air"));
    }

    @Test
    public void addMoreThanOneItemToCart() throws InterruptedException {
        HomePage homePage = new HomePage(page);

        homePage.selectLaptop("Sony vaio i5");

        ProductPage productPage = new ProductPage(page);
        productPage.addProductToCart();
        productPage.returnToHomePage();

        // Add a second laptop to the order
        homePage.selectLaptop("Dell i7 8gb");
        productPage.addProductToCart();

        // Check Cart contents
        productPage.clickCart();

        // Let's calculate the total
        // Sony vaio = $790 + Dell i7 8gb = $700 - Expected total $1490
        CartPage cartPage = new CartPage(page);

        Thread.sleep(3000);
        String cartTotal = cartPage.getCartTotal();
        Assert.assertEquals("1490", cartTotal);

    }

    @Test
    public void removeItemFromCart() throws InterruptedException {
        HomePage homePage = new HomePage(page);

        homePage.selectMonitor("Apple monitor 24");

        // Add to cart
        ProductPage productPage = new ProductPage(page);
        productPage.addProductToCart();

        // Check Cart contents
        productPage.clickCart();

        // Remove item from the cart
        CartPage cartPage = new CartPage(page);
        cartPage.removeItemFromCart();

        Thread.sleep(3000);
        Assert.assertEquals("", cartPage.getCartTotal());

    }
}
