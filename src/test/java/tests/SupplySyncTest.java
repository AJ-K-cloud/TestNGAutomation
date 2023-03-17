package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.SupplySynceLoginPage;
import utilities.Config;
import utilities.Driver;
import utilities.Flow;

public class SupplySyncTest {
    SupplySynceLoginPage syncLoginPage=new SupplySynceLoginPage();

    @Test
    public void loginPositive(){
        Driver.getDriver().get(Config.getValue("supplySyncURL"));
        syncLoginPage.login("codewise@gmail.com","123123");
        String expectedURL="https://supplysync.us/dashboard/companies";
        Flow.wait(3000);
        Assert.assertEquals(expectedURL,Driver.getDriver().getCurrentUrl());
    }

    @Test
    public void loginNegative(){
        Driver.getDriver().get(Config.getValue("supplySyncURL"));
        syncLoginPage.login("codewise@gail.com","123");
        String errorMessage=syncLoginPage.errorMessage.getText();
        String expectedMessage="Incorrect login and/or password.";
        Assert.assertEquals(expectedMessage,errorMessage);
    }

}
