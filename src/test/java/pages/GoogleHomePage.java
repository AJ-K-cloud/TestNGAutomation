package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class GoogleHomePage {
    public GoogleHomePage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "APjFqb")
    public WebDriver searchButton;




}
