package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Utils.SeleniumUtils.*;

import java.time.Duration;

public class RegisterPage {

    public WebDriver driver;

    public RegisterPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);

    }

    @FindBy(css="h2.title")
    private WebElement registerText;

    @FindBy(css="input#username")
    private WebElement userNameField;

    @FindBy(css="input#password")
    private WebElement passwordField;

    @FindBy(css="input#confirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(xpath="//button[normalize-space(text())='Register Now']")
    private WebElement registerButton;



    public boolean validateRegisterPage(){
        boolean flag=false;

        try{
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains("/register"));
            if(registerText.getText().equalsIgnoreCase("Register")){
               flag=true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean makeReservation(String userName, String password){
        boolean flag=false;
        try {
            enterValue(userNameField, userName);
            enterValue(passwordField, password);
            enterValue(confirmPasswordField, password);
            elementClick(driver, registerButton);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Exception is occureed while registration");
        }
        return flag;
    }

}
