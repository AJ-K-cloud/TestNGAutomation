package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GoogleHomePage;
import utilities.Config;
import utilities.Driver;

public class GoogleTest {

    @Test

    public void setUp(){
        Driver.getDriver().get("https://google.com");
        Driver.getDriver().findElement(By.name("q")).sendKeys("Selenium" + Keys.ENTER);
    }

    @Test(groups = {"smoke"})
    public void googleSearch(){
      //  Driver.getDriver().get((Config.getValue("googleURL")));
        System.out.println("Google searching");
    }

    @Test
    public void login(){
        Driver.getDriver().get("https://google.com");
        System.out.println(Driver.getDriver().getTitle());
    }

    @AfterMethod
    public void cleanUp(){
        Driver.quitBrowser();
    }
}
