package PageObjects;

import AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAnAccountPage extends AbstractComponents {
    WebDriver driver;
    public CreateAnAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "input#firstname")
    private WebElement firstNameField;

    @FindBy (css = "input#lastname")
    private WebElement lastNameField;

    @FindBy (css = "input#email_address")
    private WebElement emailField;

    @FindBy (css = "input#password")
    private WebElement passwordField;

    @FindBy (css = "input#password-confirmation")
    private WebElement confirmPasswordField;

    @FindBy (xpath = "//button[@class='action submit primary']")
    private WebElement createAnAccountButton;


    public AccountPage registerAnAccount(){
        firstNameField.sendKeys(name);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(password);
        createAnAccountButton.click();
        AccountPage accountPage = new AccountPage(driver);
        return accountPage;
    }



}
