package PageObjects;

import AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends AbstractComponents {
    WebDriver driver;
    public CheckOutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//*[@id=\"customer-email\"]")
    private WebElement emailAddress;
    @FindBy (css = "[name='shippingAddress.firstname'] [class='control']")
    private WebElement firstNameField;
    @FindBy (css = "[name='shippingAddress.lastname'] [class='control']")
    private WebElement lastNameField;
    @FindBy (css = "[name='shippingAddress.company'] [class='control']")
    private WebElement companyField;
    @FindBy (css = "[class='control'] [name='shippingAddress.street.0']")
    private WebElement streetAddressField;
    @FindBy (css = "[name='shippingAddress.city'] [class='control']")
    private WebElement cityField;
    @FindBy (css = "[name='shippingAddress.postcode'] [class='control']")
    private WebElement zipPostalCodeField;
    @FindBy (css = "[name='shippingAddress.country_id'] [class='control']")
    private WebElement countryDropDown;
    @FindBy (css = "[name='shippingAddress.telephone'] [class='control _with-tooltip']")
    private WebElement phoneNumberField;
    @FindBy (css = ".button")
    private WebElement nextButton;
    @FindBy (css = "[class='control _with-tooltip'] [class='note']")
    private WebElement note;


    public void selectCountry(String countryValue){
        countryDropDown.click();
        Select select = new Select(countryDropDown);
        select.selectByValue(countryValue);
    }
    public void fillTheForm(){
        waitForURL("https://magento.softwaretestingboard.com/checkout/#shipping");
        emailAddress.sendKeys(email);
        waitForElementToAppear(note);
        firstNameField.sendKeys(name);
        lastNameField.sendKeys(lastName);
        companyField.sendKeys(companyName);
        streetAddressField.sendKeys(streetAddress);
        cityField.sendKeys(city);
        selectCountry(countryValue);
        zipPostalCodeField.sendKeys(zipPostalCode);
        phoneNumberField.sendKeys(phoneNumber);
        nextButton.click();
    }





}
