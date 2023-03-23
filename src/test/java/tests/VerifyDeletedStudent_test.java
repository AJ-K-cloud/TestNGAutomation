package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StudentPage;
import pages.TrashPage;
import studymatepage.LoginPage;
import utilities.Config;
import utilities.Driver;
import utilities.Flow;

public class VerifyDeletedStudent_test {
    LoginPage loginPage=new LoginPage();
    TrashPage trashPage=new TrashPage();
    StudentPage studentPage=new StudentPage();

    @Test(groups = "regression")
    public void verifyingStudentDelete() {
        Driver.getDriver().get(Config.getValue("studyMateURL"));
        loginPage.login("studymate@gmail.com", "123123");
        studentPage.StudentsButton.click();
        String expectedStudent = studentPage.student.getText();
        studentPage.threeDotsButton.click();
        studentPage.deleteButton.click();
        studentPage.deleteConfirmation.click();
        trashPage.trashButton.click();
        trashPage.lastPageButton.click();
        Flow.wait(400);
        int count = trashPage.lastDeletedStudentsList.size();
        String actualStudent = trashPage.lastDeletedStudentsList.get(count - 1).getText();
        Assert.assertEquals(actualStudent, expectedStudent);
        Driver.quitBrowser();

    }
}
