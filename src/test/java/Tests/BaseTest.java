package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import java.time.Duration;

import static Utils.DriverSingleTon.createDriver;

public class BaseTest {

    WebDriver driver;
    @Parameters({"browserName"})

    @BeforeTest(alwaysRun=true)
    public void setUp(String browserName){
       driver=createDriver(browserName);
       System.out.println("HashCode od driver is :"+driver.hashCode());
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://crio-qkart-frontend-qa.vercel.app/");
    }
}
