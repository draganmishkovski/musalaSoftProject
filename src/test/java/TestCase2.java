

import org.musalaproject.Base;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.CompanyPage;
import pageObjects.FacebookPage;
import pageObjects.LandingPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestCase2 extends Base {

    WebDriver driver;
    CompanyPage companyPage;


    @BeforeMethod
    public void openApp() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/main/java/resource/config.properties");
        prop.load(fis);


        driver = initalizeDriver();
        driver.get(prop.getProperty("base_url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }


    @Test
    public void Test2() throws InterruptedException {


        companyPage = new CompanyPage(driver);
        companyPage.clickOnCompanyButton().click();

        System.out.println(driver.getCurrentUrl());

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.musala.com/company/");
        Assert.assertEquals(companyPage.leadershipTitleIsDisplayed().getText(), "Leadership");

        LandingPage landingPage = new LandingPage(driver);
        landingPage.enterAcceptCookiesButton().click();
        Thread.sleep(3000);
        companyPage.clickOnFacebookButton().click();

        ArrayList<String> multiWindow = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(multiWindow.get(1));

        System.out.println(driver.getCurrentUrl());

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/MusalaSoft?fref=ts");

        FacebookPage facebookPage = new FacebookPage(driver);

        Assert.assertTrue(facebookPage.displayFacebookProfilePicture().isDisplayed());


    }

    @AfterMethod
    public void tearDown() {

        driver.quit();

    }

}
