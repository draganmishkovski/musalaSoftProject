import org.musalaproject.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.CareersPage;
import pageObjects.LandingPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestCase4 extends Base {


    WebDriver driver;
    boolean available = true;

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
    public void Test4()  {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnCareersButton().click();

        CareersPage careersPage = new CareersPage(driver);
        careersPage.clickOnCheckOurPosition().click();
        WebElement dropDownfield = careersPage.locationDropDownMenu();
        Select select = new Select(dropDownfield);

        if (available) {

            select.selectByVisibleText("Sofia");

            List<WebElement> options = driver.findElements(By.tagName("img"));

            for (int i = 1; i < options.size(); i++) {

                System.out.println("Available positions Sofia " + options.get(i).getAttribute("alt"));
            }
        }

        if (available) {

            select.selectByVisibleText("Skopje");
            List<WebElement> options = driver.findElements(By.tagName("img"));


            for (int i = 1; i < options.size(); i++) {

                System.out.println("Available positions Skopje " + options.get(i).getAttribute("alt"));

            }
        }


    }

    @AfterMethod
    public void tearDown() {

        driver.quit();


    }
}