package Tests;

import AbstractComponents.AbstractComponents;
import PageObjects.*;
import TestComponents.BaseTest;
import TestData.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SmokeTests extends BaseTest {
    AbstractComponents AC;
    HomePage HP;
    CreateAnAccountPage CP;
    TestData TD;
    ProductsListPage PLP;
    LogoutPage LP;
    SignInPage SP;
    AccountPage AP;
    ProductsDetailPage PDP;
    CartPage CaP;
    CheckOutPage COP;

    @BeforeMethod
    public void objects(){
        AC = new AbstractComponents(driver);
        HP = new HomePage(driver);
        CP = new CreateAnAccountPage(driver);
        TD = new TestData(driver);
        LP = new LogoutPage(driver);
        PLP = new ProductsListPage(driver);
        SP = new SignInPage(driver);
        AP = new AccountPage(driver);
        PDP = new ProductsDetailPage(driver);
        CaP = new CartPage(driver);
        COP = new CheckOutPage(driver);
    }

    @Test(description = "TC153", priority = 1)
    public void verifyThatAllElementsArePresentedEndLayoutOnTheHomePage(){
        Assert.assertTrue(HP.isDisplayed(AC.logo));
        Assert.assertTrue(HP.isDisplayed(AC.searchBox));
        Assert.assertTrue(HP.isDisplayed(AC.menu));
        Assert.assertTrue(HP.isDisplayed(AC.header));
        Assert.assertTrue(HP.isDisplayed(AC.footer));
        Assert.assertTrue(HP.isDisplayed(HP.blockPromo));
        Assert.assertTrue(HP.isDisplayed(HP.blockList));
    }

    @Test(description = "TC154", priority = 2)
    public void verifyCreateAnAccountFunctionality() {
        AC.goToCreateAnAccountPage();
        CP.registerAnAccount();
        Assert.assertEquals(AC.getCurrentURL(), TD.accountURL);
    }

    @Test(description = "TC155", priority = 3)
    public void verifyLogoutFunctionality() {
        AC.goToCreateAnAccountPage();
        CP.registerAnAccount();
        AC.clickOnSignOut();
        Assert.assertEquals(LP.getLogoutMessage(), TD.correctLogoutMessage);
        Assert.assertEquals(AC.getCurrentURL(), TD.logoutURL);
    }

    @Test(description = "TC180", priority = 4)
    public void verifyIfTheUserIsStillLoggedInAfterHeLoggedOutAndClickedBack(){
        AC.goToCreateAnAccountPage();
        CP.registerAnAccount();
        AC.clickOnSignOut();
        AC.clickOnBack();
        Assert.assertEquals(AC.getCurrentURL(), TD.signInURL);
    }

    @Test(description = "TC156", priority = 5)
    public void verifySignInFunctionality(){
        AC.clickOnSignIn();
        SP.signIn();
        Assert.assertEquals(AP.getWelcomeMessage(), TD.correctWelcomeMessage);
        Assert.assertEquals(AC.getCurrentURL(), TD.homeURL);
    }

    @Test(description = "TC157", priority = 6)
    public void verifyThatTheProductsAreDisplayedOnTheProductListingPage(){
        Assert.assertTrue(HP.isDisplayed(PLP.productsImages));
        Assert.assertTrue(HP.isDisplayed(PLP.productsNames));
        Assert.assertTrue(HP.isDisplayed(PLP.productsPrices));
    }

    @Test(description = "TC158", priority = 7)
    public void verifyAddToCartFunctionality(){
        HP.goToWatchesPage();
        PLP.findTheProduct(TD.firstProduct);
        PDP.addProductToCart();
        Assert.assertEquals(PDP.getTheConfirmationMessage(), TD.correctConfirmationMessage);
        Assert.assertTrue(CaP.numberOfProductInCart());
    }

    @Test(description = "TC159", priority = 8)
    public void verifyIfTheProductIsPresentedInTheCart(){
        HP.goToWatchesPage();
        PLP.findTheProduct(TD.firstProduct);
        PDP.addProductToCart();
        Assert.assertTrue(CaP.presenceOfProductInCart());
    }

    @Test(description = "TC160", priority = 9)
    public void verifyThePriceInTheCartWhenUserAddAnotherProduct() {
        HP.goToWatchesPage();
        PLP.findTheProduct(TD.firstProduct);
        PDP.addProductToCart();
        AC.clickOnBack();
        PLP.findTheProduct(TD.secondProduct);
        PDP.addProductToCart();
        CaP.waitForMessageAndClickOnCart();
        Assert.assertTrue(CaP.sumOfProductsPricesInCart());
    }

    @Test(description = "TC161", priority = 10)
    public void verifySuccessfulPurchaseOfProductsWithNotSignedInUser() {
        HP.goToWatchesPage();
        PLP.findTheProduct(TD.firstProduct);
        PDP.addProductToCart();
        AC.clickOnBack();
        PLP.findTheProduct(TD.secondProduct);
        PDP.addProductToCart();
        CaP.waitForMessageAndClickOnCart();
        CaP.goToCheckOut();
        COP.fillTheForm();
    }











  /*@Test
    public void testProba(){
        AbstractComponents.goToCreateAnAccountPage();
        CP.registerAnAccount();
        AC.clickOnSignOut();
        AC.waitForElementTextToAppear(LogoutPage.logoutMessage, TestData.correctLogoutMessage);
        System.out.println(LogoutPage.logoutMessage.getText());
    }*/


}
