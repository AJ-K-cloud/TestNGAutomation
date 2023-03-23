package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StudentPage;
import utilities.Config;
import utilities.Driver;
import utilities.Flow;

public class StudentTest {

    StudentPage studentPage=new StudentPage();

    @Test
    public void StudentTest() {
        Driver.getDriver().get("https://codewise.studymate.us");
        studentPage.emailBtn.sendKeys(Config.getValue("studyMateLoginEmail"));
        studentPage.passwordBtn.sendKeys(Config.getValue("studyMateLoginPassword"));
        studentPage.LoginBtn.click();

        studentPage.studentsBtn.click();

        studentPage.threeDotBtn.click();

        studentPage.blockDropDown.click();

        studentPage.blockPopup.click();
        Flow.wait(800);
        String expectedMessage = "Student successfully blocked";
        String actualMessage = studentPage.blockedPopupMessage.getText();

        Flow.wait(2000);
        Assert.assertEquals(expectedMessage, actualMessage);

        Flow.wait(5000);

        studentPage.administratorBtn.click();

        studentPage.logOutBtn.click();
        studentPage.logOutExitBtn.click();
    }

}
