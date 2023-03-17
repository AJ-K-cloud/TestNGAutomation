package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.Flow;

public class SauceTest {

    @Test(groups={"Smoke"})
    public void login(){
        Driver.getDriver().get("https://saucedemo.com");
    }

    @Test(priority =2,groups = {"Smoke,products","regression"})
    public void sort(){
        Driver.getDriver().get("https://saucedemo.com");

    }

    @Test(priority=3)
    public void logout() {
        Driver.getDriver().get("https://saucedemo.com");
        Flow.wait(2000);
    }
    @AfterMethod
    public void cleanUp(){
        Driver.quitBrowser();
    }




}
