package TestData;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;

public class TestData {
    WebDriver driver;
    public TestData(WebDriver driver) {
        this.driver = driver;
    }

    //Home page
    public String homeURL = "https://magento.softwaretestingboard.com/";


    //Create an account page
    Faker faker = new Faker();
    protected String name = faker.name().name();
    protected String lastName = faker.name().lastName();
    protected String email = faker.internet().emailAddress();
    protected String password = "AAAbbb123";


    //Account page
    public String accountURL = "https://magento.softwaretestingboard.com/customer/account/";
    public String correctWelcomeMessage = "Welcome, Andriana Chichonovska!";


    //Logout page
    public String correctLogoutMessage = "You are signed out";
    public String logoutURL = "https://magento.softwaretestingboard.com/customer/account/logoutSuccess/";


    //Sign in page
    protected String validEmail = "ane_t_2005@hotmail.com";
    protected String validPassword = "AneChi2412";
    public String signInURL = "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2luZGV4Lw%2C%2C/";


    //Product list page
    public String firstProduct = "Didi Sport Watch";
    public String secondProduct = "Bolo Sport Watch";


    //Product detail page
    public String correctConfirmationMessage = "You added Didi Sport Watch to your shopping cart.";
    public String correctConfirmationMessageForSecondProduct = "You added Bolo Sport Watch to your shopping cart.";


    //Check out page
    protected String companyName = faker.company().name();
    protected String streetAddress = faker.address().streetAddress();
    protected String city = faker.address().city();
    protected String zipPostalCode = faker.address().zipCode();
    protected String phoneNumber = faker.phoneNumber().toString();
    protected String countryValue = "BO";


}
