package _06_POM;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.BaseDriver;

public class LoginTestPOM extends BaseDriver {

    // Test senaryosunu yürütmek için kullanılacak test metodu
    @Test(dataProvider = "credentials")
    public void loginTest(String username, String password){

        // LoginTest_Elements sınıfından bir örnek oluşturulur
        LoginTestElements loginTestElements=new LoginTestElements();

        // Web sitesine gidilir
        driver.get("https://www.saucedemo.com/");

        // Kullanıcı adı ve şifre alanları doldurulur
        loginTestElements.usernameInput.sendKeys(username);
        loginTestElements.passwordInput.sendKeys(password);
        loginTestElements.loginButton.click();

        // Kullanıcı adı ve şifre doğruysa
        if(
                (
                        (username.equals("standard_user")) ||
                                (username.equals("problem_user")) ||
                                (username.equals("performance_glitch_user")) ||
                                (username.equals("error_user")) ||
                                (username.equals("visual_user")) )
                        &&
                        password.equals("secret_sauce")
        ){

            // Burger menüsüne tıklanır ve çıkış yapılır
            loginTestElements.burgerMenu.click();
            loginTestElements.logout.click();

        }
        // Kullanıcı adı "locked_out_user" ve şifre "secret_sauce" ise
        else if(username.equals("locked_out_user")&& password.equals("secret_sauce")){
            // Hata mesajının görüntülendiği doğrulanır
            Assert.assertTrue(loginTestElements.errorMessage.isDisplayed());
            loginTestElements.errorCloseButton.click();
            loginTestElements.usernameInput.click();
            loginTestElements.passwordInput.click();

        }
        // Diğer durumlarda
        else {
            // Hata mesajının görüntülendiği doğrulanır
            Assert.assertTrue(loginTestElements.errorMessage.isDisplayed());
            loginTestElements.errorCloseButton.click();
            loginTestElements.usernameInput.click();
            loginTestElements.passwordInput.click();
        }
    }

    // Test senaryosunda kullanılacak verileri sağlayan veri sağlayıcısı
    @DataProvider
    public Object[][] credentials(){

        // Kullanıcı adı ve şifre kombinasyonlarını içeren bir dizi
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

/**
 Bu sınıf, TestNG kullanarak bir otomasyon testi gerçekleştirmek için gerekli olan
 test senaryosunu içerir. Bu senaryo, LoginTest_Elements sınıfındaki web öğelerini
 kullanarak bir web uygulamasına giriş yapmayı simüle eder.

 - `@Test(dataProvider = "credentials")`:
 Bu satır, TestNG tarafından bir test metodu olarak işaretlenir ve "credentials"
 adlı veri sağlayıcısından gelen verileri kullanarak test senaryosunu yürütür.

 - `public void loginTest(String username, String password)`:
 Bu satır, test senaryosunun kodunu içerir. Giriş yapmak için kullanıcı adı ve şifre alır
 ve LoginTest_Elements sınıfındaki web öğelerini kullanarak giriş yapar.

 - `@DataProvider`:
 Bu satır, test senaryosunda kullanılacak verilerin sağlayıcısını tanımlar.
 Bu senaryoda, "credentials" adlı bir veri sağlayıcısı kullanılır.

 - `public Object[][] credentials()`:
 Bu satır, veri sağlayıcısının kodunu içerir. Bu senaryoda, bir dizi kullanıcı adı
 ve şifre kombinasyonu sağlanır.
 */
