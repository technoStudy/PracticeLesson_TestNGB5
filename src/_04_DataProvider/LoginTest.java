package _04_DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.BaseDriver;

public class LoginTest extends BaseDriver {

    @Test (dataProvider = "credentials")
    public void loginTest(String username, String password){

        driver.get("https://www.saucedemo.com/");

        WebElement usernameInput= driver.findElement(By.id("user-name"));
        usernameInput.sendKeys(username);

        WebElement passwordInput= driver.findElement(By.id("password"));
        passwordInput.sendKeys(password);

        WebElement loginButton= driver.findElement(By.id("login-button"));
        loginButton.click();

      if(
              ((username.equals("standard_user")) ||
              (username.equals("problem_user")) ||
              (username.equals("performance_glitch_user")) ||
              (username.equals("error_user")) ||
              (username.equals("visual_user")) )
                &&
              password.equals("secret_sauce")
      ){
          WebElement burgerMenu=driver.findElement(By.id("react-burger-menu-btn"));
          burgerMenu.click();

          WebElement logout= driver.findElement(By.id("logout_sidebar_link"));
          logout.click();

      }else if(username.equals("locked_out_user")&& password.equals("secret_sauce")){

          WebElement errorMessage=driver.findElement(By.xpath("//h3[@data-test='error']"));
          Assert.assertTrue(errorMessage.isDisplayed());

          WebElement errorCloseButton=driver.findElement(By.xpath("//h3[@data-test='error']/button"));
          errorCloseButton.click();

          usernameInput.click();
          passwordInput.click();

      }else {

          WebElement errorMessage=driver.findElement(By.xpath("//h3[@data-test='error']"));
          Assert.assertTrue(errorMessage.isDisplayed());

          WebElement errorCloseButton=driver.findElement(By.xpath("//h3[@data-test='error']/button"));
          errorCloseButton.click();

          usernameInput.click();
          passwordInput.click();
      }
    }


   @DataProvider
    public Object[][] credentials(){

        Object[][] credentialList={
                {"standard_user","secret_sauce"},
                {"fake_user_01","secret_sauce"},
                {"error_user","fake_password_01"},
                {"performance_glitch_user","secret_sauce"},
                {"fake_user_02","secret_sauce"},
                {"error_user","secret_sauce"},
                {"visual_user","fake_password_01"},
                {"visual_user","secret_sauce"},
                {"problem_user","secret_sauce"},
                {"locked_out_user","secret_sauce"},
        };
        return credentialList;
    }
}
