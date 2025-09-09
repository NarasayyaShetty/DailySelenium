package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import static Utils.SeleniumUtils.*;

public class HomePage {
   public WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);

    }

    @FindBy(xpath ="//button[normalize-space(text())='Register']")
    private WebElement registerButton;

    public boolean verifyRegisterPageNavigation(){
        boolean flag=false;
        try {
            elementClick(driver, registerButton);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Expection is occured while registar page navigation");
        }
        return flag;
    }


}
