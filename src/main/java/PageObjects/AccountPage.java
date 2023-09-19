package PageObjects;

import AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends AbstractComponents {

    WebDriver driver;
    public AccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "/html/body/div[2]/header/div[1]/div/ul/li[1]/span")
    private WebElement welcomeMessage;
    public String getWelcomeMessage(){
        AbstractComponents AC = new AbstractComponents(driver);
        AC.waitForElementTextToAppear(welcomeMessage, correctWelcomeMessage);
        return welcomeMessage.getText();
    }

}
