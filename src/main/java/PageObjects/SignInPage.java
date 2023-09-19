package PageObjects;

import AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends AbstractComponents {
    WebDriver driver;
    public SignInPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "input#email")
    private WebElement emailField;
    @FindBy (css = "input[name='login[password]']")
    private WebElement passwordField;
    @FindBy (css = "button.login")
    private WebElement signInButton;
    public void signIn(){
        emailField.sendKeys(validEmail);
        passwordField.sendKeys(validPassword);
        signInButton.click();
    }

}
