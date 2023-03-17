package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GitHubHomePage;
import utilities.Config;
import utilities.Driver;
import utilities.Flow;

public class GitHubTest {

    GitHubHomePage gitHubHomePage=new GitHubHomePage();
    @Test
    public void search(){
        Driver.getDriver().get(Config.getValue("gitHubURL"));
        String testData="selenium";
        gitHubHomePage.search.sendKeys(testData+ Keys.ENTER);
        for (WebElement result: gitHubHomePage.resultList){
            String resultStr=result.getText().toLowerCase();
            Assert.assertTrue(resultStr.contains(testData),"Result in GitHub search");
        }

    }

    @Test(groups = {"smoke"})
    public void socialMedia(){
        Driver.getDriver().get(Config.getValue("gitHubURL"));
        Flow.scrollDown(14000);

        for (WebElement link:gitHubHomePage.socialMediaLinks){
            String currentURL=Driver.getDriver().getCurrentUrl();
            link.click();
            Flow.wait(600);
            String url=Driver.getDriver().getCurrentUrl();
            Assert.assertFalse(url.equalsIgnoreCase(currentURL));
            Driver.getDriver().navigate().back();
            Flow.wait(600);

        }
    }
}
