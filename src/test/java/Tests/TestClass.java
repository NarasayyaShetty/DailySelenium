package Tests;

import Pages.HomePage;
import Pages.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class TestClass extends BaseTest{

    HomePage hm;
    RegisterPage rp;
    String userName;
    String password="Test@123";


    @BeforeClass(alwaysRun=true)
    public void setUp(){
        hm=new HomePage(driver);
        rp=new RegisterPage(driver);
    }


    @Test(description="Login to the application",enabled=false)
    public void testCase(){
        boolean status;
        status=hm.verifyRegisterPageNavigation();
        Assert.assertTrue(status,"Navigation is failed");
        status=rp.validateRegisterPage();
        Assert.assertTrue(status,"Navigation is failed");
        userName=String.format("Test_%s@gmail.com", UUID.randomUUID().toString());
        status=rp.makeReservation(userName,password);
        Assert.assertTrue(status,"Registration is failed");
    }
    @Test(description="open new window and pass currentUrl")
    public void testCase01() throws InterruptedException {
        String url=driver.getCurrentUrl();
        System.out.println(url);

        driver.findElement(By.linkText("Privacy policy")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> set=driver.getWindowHandles();
        List<String> list=new ArrayList<>(set);
        driver.switchTo().window(list.get(1));

        String value=driver.findElement(By.tagName("h2")).getText();
        System.out.println(value);
        driver.close();
        wait.until(ExpectedConditions.numberOfWindowsToBe(1));
        set=driver.getWindowHandles();
        list=new ArrayList<>(set);
        driver.switchTo().window(list.get(0));

        String mainPage=driver.findElement(By.cssSelector("p.hero-heading")).getText();
        System.out.println(mainPage);



    }
}
