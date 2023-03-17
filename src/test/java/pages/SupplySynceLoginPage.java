package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SupplySynceLoginPage {

    public SupplySynceLoginPage() {

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(id = "input")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement pass;

    @FindBy(tagName = "button")
    public WebElement login;

    @FindBy(tagName = "p")
    public WebElement errorMessage;


    public void login(String email,String password){
        username.sendKeys(email);
        pass.sendKeys(password);
        login.click();
    }


}
