package _06_POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseDriver;

public class LoginTestElements {

    public LoginTestElements() {
        // BaseDriver sınıfındaki sürücüyü kullanarak web öğelerini başlatır
        PageFactory.initElements(BaseDriver.driver,this);
    }

    // Kullanıcı adı alanı
    @FindBy(id="user-name")
    public WebElement usernameInput;

    // Şifre alanı
    @FindBy(id="password")
    public WebElement passwordInput;

    // Giriş butonu
    @FindBy(id="login-button")
    public WebElement loginButton;

    // Burger menüsü
    @FindBy(id="react-burger-menu-btn")
    public WebElement burgerMenu;

    // Çıkış butonu
    @FindBy(id="logout_sidebar_link")
    public WebElement logout;

    // Hata mesajı
    @FindBy(xpath="//h3[@data-test='error']")
    public WebElement errorMessage;

    // Hata mesajı kapatma butonu
    @FindBy(xpath = "//h3[@data-test='error']/button")
    public WebElement errorCloseButton;
}

/**
 Bu sınıf, LoginTestPOM sınıfındaki test senaryosunda kullanılan web öğelerini içerir.

 - `public LoginTestElements()`:
 Bu satır, sınıfın yapıcı metodudur. Bu metot, BaseDriver sınıfındaki sürücüyü kullanarak
 LoginTestElements sınıfındaki web öğelerini başlatır.

 - `@FindBy`:
 Bu satırlar, LoginTestElements sınıfındaki web öğelerinin yerini belirler.
 Bu öğeler, sınıfın diğer bölümlerinde kullanılacak olan WebElement nesneleri olarak tanımlanır.
 */