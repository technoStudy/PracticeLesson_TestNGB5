package _05_HardAndSoftAsserts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utility.BaseDriver;

import java.util.List;

public class HardAndSoftAssert extends BaseDriver {

    @Test
    public void hardAssertTesting() {
        // Google.com'a gidin
        driver.get("https://google.com/");

        // "Tümünü reddet" butonunu bulun ve tıklayın
        List<WebElement> rejectAll = driver.findElements(By.xpath("//button[@id='W0wltc']/div"));
        if (!rejectAll.isEmpty()) {
            rejectAll.get(0).click();
        }

        // URL'in "google.com" ibaresini içerdiğini doğrulayın
        String currentUrl = driver.getCurrentUrl().toLowerCase();
        Assert.assertTrue(currentUrl.contains("google.com"), "URL doğrulama hatası");

        // Title'ın "google" kelimesini içerdiğini doğrulayın
        String title = driver.getTitle().toLowerCase();
        Assert.assertTrue(title.contains("google"), "Title doğrulama hatası");

        // "Selenium" yazın ve Enter'a basın
        WebElement searchInput = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        Actions actions = new Actions(driver);
        Action action = actions
                .moveToElement(searchInput)
                .click()
                .sendKeys("selenium" + Keys.ENTER)
                .build();
        action.perform();

        // İlk sonucun "selenium" kelimesini içerdiğini doğrulayın
        WebElement theFirstLink = driver.findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']"));
        wait.until(ExpectedConditions.elementToBeClickable(theFirstLink));

        // İlk yöntem: Tam eşleşme kontrolü
        String firstLinkText = theFirstLink.getText().toLowerCase();
        Assert.assertEquals(firstLinkText, "selenium", "İlk sonuç doğrulama hatası");

        // İkinci yöntem: Parça kontrolü
        Assert.assertTrue(firstLinkText.contains("selenium"), "İlk sonuç doğrulama hatası");
    }

    @Test
    public void softAssertTesting() {
        // Google.com'a gidin
        driver.get("https://google.com/");

        // "Tümünü reddet" butonunu bulun ve tıklayın
        List<WebElement> rejectAll = driver.findElements(By.xpath("//button[@id='W0wltc']/div"));
        if (!rejectAll.isEmpty()) {
            rejectAll.get(0).click();
        }

        // URL'in "google.com" ibaresini içerdiğini doğrulayın
        SoftAssert softAssert = new SoftAssert();
        String currentUrl = driver.getCurrentUrl().toLowerCase();
        softAssert.assertTrue(currentUrl.contains("google.com"), "URL doğrulama hatası");

        // Title'ın "google" kelimesini içerdiğini doğrulayın
        String title = driver.getTitle().toLowerCase();
        softAssert.assertTrue(title.contains("google"), "Title doğrulama hatası");

        // "Selenium" yazın ve Enter'a basın
        WebElement searchInput = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        Actions actions = new Actions(driver);
        Action action = actions
                .moveToElement(searchInput)
                .click()
                .sendKeys("selenium" + Keys.ENTER)
                .build();
        action.perform();

        // İlk sonucun "selenium" kelimesini içerdiğini doğrulayın
        WebElement theFirstLink = driver.findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']"));
        wait.until(ExpectedConditions.elementToBeClickable(theFirstLink));

        // İlk yöntem: Tam eşleşme kontrolü
        String firstLinkText = theFirstLink.getText().toLowerCase();
        softAssert.assertEquals(firstLinkText, "selenium", "İlk sonuç doğrulama hatası");

        // İkinci yöntem: Parça kontrolü
        softAssert.assertTrue(firstLinkText.contains("selenium"), "İlk sonuç doğrulama hatası");

        // Tüm doğrulama adımlarını gerçekleştirin
        softAssert.assertAll();
    }
}

/**
 Bu kodda, hardAssertTesting ve softAssertTesting adında iki test metodu bulunmaktadır.
 Her iki metot da aynı işlemleri gerçekleştirir, ancak doğrulama yöntemleri farklıdır.

 hardAssertTesting metodu, Assert kullanarak doğrulama yapar. İlk olarak, Google.com'a gidilir
 ve "Tümünü reddet" butonu tıklanır. Ardından, URL'in "google.com" ibaresini içerip içermediği
 ve title'ın "google" kelimesini içerip içermediği doğrulanır.Daha sonra, "Selenium" kelimesi
 aranır ve ilk sonucun "selenium" kelimesini içerip içermediği doğrulanır.İki farklı doğrulama
 yöntemi kullanılır: tam eşleşme kontrolü (assertEquals) ve parça kontrolü (assertTrue).

 softAssertTesting metodu ise SoftAssert kullanarak doğrulama yapar.Aynı adımları takip eder,
 ancak hata durumunda testi durdurmak yerine tüm doğrulama adımlarını gerçekleştirir ve
 hata mesajlarını görüntüler (assertAll).

 Her iki metot da Selenium WebDriver kullanarak tarayıcı üzerinde işlemler gerçekleştirir.
 */