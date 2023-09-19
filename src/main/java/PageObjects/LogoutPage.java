package PageObjects;

import AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage extends AbstractComponents {
    WebDriver driver;
    public LogoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//*[@id=\"maincontent\"]/div[1]/h1/span")
    private WebElement logoutMessage;

    public String getLogoutMessage(){
        AbstractComponents AC = new AbstractComponents(driver);
        LogoutPage LP = new LogoutPage(driver);
        AC.waitForElementTextToAppear(LP.logoutMessage, correctLogoutMessage);
        return logoutMessage.getText();
    }
}
