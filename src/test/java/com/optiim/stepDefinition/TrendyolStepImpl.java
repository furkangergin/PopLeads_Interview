package com.optiim.stepDefinition;

import com.optiim.pages.Cartpage;
import com.optiim.pages.DashboardPage;
import com.optiim.pages.LoginPage;
import com.optiim.utilities.DriverFactory;
import com.optiim.utilities.ExcelHelper;
import com.optiim.utilities.ReadProperties;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class TrendyolStepImpl {

    private static final Logger LOG = LogManager.getLogger(TrendyolStepImpl.class);
    WebDriver driver = DriverFactory.getDriver();
    Cartpage cartpage = new Cartpage();
    DashboardPage dashboardPage = new DashboardPage();
    LoginPage loginPage = new LoginPage();
    Actions actions = new Actions(driver);

    JavascriptExecutor executor = (JavascriptExecutor) driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));



    @Given("Kullanıcı {string} url'ine gider.")
    public void kullanıcı_url_ine_gider(String url) {
        String testURL = ReadProperties.getProperty("testURL");
        driver.get(testURL);
        LOG.info(testURL+ " adresine navigate olunur.");
    }

    @When("{string} sayfasına gidildiği doğrulanır.")
    public void sayfasına_gidildiği_doğrulanır(String url) {
        assertTrue(driver.getCurrentUrl().equals(url));
        LOG.info(url+ " adresine navigate olunduğu doğrulanır.");

    }

    @And("Çerezleri kabul et butonuna tıklanır.")
    public void çerezleri_kabul_et_butonuna_tıklanır() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[.='KABUL ET']"))));
        driver.findElement(By.xpath("//button[.='KABUL ET']")).click();
        LOG.info("Çerezleri kabul işlemi tamamlanır.");

    }

    @Given("Kullanıcı giriş yap butonuna tıklar.")
    public void kullanıcı_giriş_yap_butonuna_tıklar() {
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.girisYapButton));
        loginPage.girisYapButton.click();
        LOG.info("Kullanıcı girişi için giriş yap butonuna tıklanır.");

    }

    @When("Kullanıcı login sayfasının geldiğini doğrular.")
    public void kullanıcı_login_sayfasının_geldiğini_doğrular() {
        wait.until(ExpectedConditions.visibilityOf(loginPage.loginPageGirisYapButton));
        assertTrue(loginPage.loginPageGirisYapButton.isDisplayed());
        LOG.info("Kullanıcı login sayfasını başarı ile görür");
    }

    @And("Kullanıcı e-posta adresi olarak {string} değerini girer.")
    public void kullanıcı_e_posta_adresi_olarak_değerini_girer(String email) {
        wait.until(ExpectedConditions.visibilityOf(loginPage.emailInputBox));
        loginPage.emailInputBox.sendKeys(email);
        LOG.info("Kulllanıcı login sayfasında email olarak "+email+" değerini girer");
    }

    @And("Kullanıcı password değeri olarak {string} değerini girer.")
    public void kullanıcı_password_değeri_olarak_değerini_girer(String password) {
        wait.until(ExpectedConditions.visibilityOf(loginPage.passwordInputBox));
        loginPage.passwordInputBox.sendKeys(password);
        LOG.info("Kulllanıcı login sayfasında password olarak "+password+" değerini girer");
    }

    @And("Giriş yap butonuna tıklar.")
    public void Giriş_yap_butonuna_tıklar2() {
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.loginPageGirisYapButton));
        loginPage.loginPageGirisYapButton.click();
        LOG.info("Kulllanıcı giriş yap butonuna tıklar.");
    }

    @And("Arama alanına {string} yazılır ve arama butonuna tıklanır.")
    public void arama_alanına_yazılır_ve_arama_butonuna_tıklanır(String searchText) throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.searchBar));
        dashboardPage.searchBar.sendKeys(searchText);
        dashboardPage.searchButton.click();
        LOG.info("Arama alanına "+searchText+" kelimesi yazılır");
    }

    @Then("Gelen sayfada {string} için sonuç bulunduğu doğrulanır.")
    public void gelen_sayfada_için_sonuç_bulunduğu_doğrulanır(String searchText) {
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.searchResultElement));
        assertTrue(dashboardPage.searchResultElement.getText().contains(searchText));
        LOG.info("Gelen sayfasa "+searchText+" sonuçları görülür.");

    }

    @And("Sol menüden akıllı saat tıklanır.")
    public void sol_menüden_akıllı_saat_tıklanır() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.akıllıSaatLink));
        dashboardPage.akıllıSaatLink.click();
        LOG.info("Sol menüden akıllı saat linki tıklanır.");

    }

    @And("Üstten {int}. ürün tıklanır.")
    public void üstten_ürün_tıklanır(int nth) throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfAllElements(dashboardPage.productListContent));
        List<WebElement> productListContent = dashboardPage.productListContent;
        productListContent.get(--nth).click();
        LOG.info("Açılan menüden "+--nth+". ürün seçilir");

    }

    @And("Ürün detayında kalp butonuna tıklanarak favorilere eklenir.")
    public void ürün_detayında_kalp_butonuna_tıklanır() {
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String each : allWindowHandles
        ) {
            driver.switchTo().window(each);
        }
        wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.favoriButonu));
        dashboardPage.favoriButonu.click();
        LOG.info("Ürün favorilere eklenir.");

    }

    @And("Favorilerim kısmına tıklanır ve gelen sayfada ürün sepete eklenir.")
    public void favorilerim_kısmına_tıklanır_ve_gelen_sayfada_ürün_sepete_eklenir() {
        dashboardPage.favorilerimButonu.click();
        wait.until(ExpectedConditions.visibilityOf(cartpage.sepeteEkleButonu));
        executor.executeScript("arguments[0].click();", cartpage.sepeteEkleButonu);
        LOG.info("Ürün favoriler alanından sepete eklenir");

    }

    @Then("Sepete eklendi popup yazısının görüldüğü doğrulanır.")
    public void Sepete_eklendi_popup_yazısının_görüldüğü_doğrulanır() {
        Assert.assertTrue(cartpage.sepeteEklendiPopup.isDisplayed());
        LOG.info("Sepete ekledi popup yazısı görülür.");

    }

    @And("Kullanıcı sepetim butonuna tıklar.")
    public void kullanıcı_sepetim_butonuna_tıklar() {
        wait.until(ExpectedConditions.elementToBeClickable(cartpage.sepetimButton));
        cartpage.sepetimButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(cartpage.anladımButton));
        cartpage.anladımButton.click();
        LOG.info("Kullanıcı sepete gitmek için sepetim butonuna tıklar.");
    }

    @Then("Sepetim sayfasının açıldığı doğrulanır.")
    public void sepetim_sayfasının_açıldığı_doğrulanır() {
        wait.until(ExpectedConditions.visibilityOf(cartpage.sepetimSayfaTitle));
        actions.moveToElement(cartpage.sepetimSayfaTitle).click().perform();
        assertTrue(cartpage.sepetimSayfaTitle.isDisplayed());
        LOG.info("Sepetim sayfasının açıldığı görülür.");

    }

    @And("Kullanıcı sepetteki ürün için kaldır butonuna tıklar.")
    public void kullanıcı_sepetteki_ürün_için_kaldır_butonuna_tıklar() {
        wait.until(ExpectedConditions.elementToBeClickable(cartpage.sepettenKaldirButton));
        cartpage.sepettenKaldirButton.click();
        LOG.info("Kullanıcı ürünleri sepetten kaldırır.");

    }

    @Then("Sepetim sıfır ürün yazısının görüldüğü doğrulanır.")
    public void Sepetim_sıfır_ürün_yazısının_görüldüğ_doğrulanır() {
        wait.until(ExpectedConditions.visibilityOf(cartpage.sepetimSıfırÜrün));
        actions.moveToElement(cartpage.sepetimSıfırÜrün).click().perform();
        assertTrue(cartpage.sepetimSıfırÜrün.isDisplayed());
        LOG.info("Kullanıcı sepetin boş olduğunu doğrular.");

    }

    @And("Kullanıcı e-posta adresi olarak TrendyolUser excel dosyasındaki değerini girer.")
    public void kullanıcıEPostaAdresiOlarakExcelDosyasındakiDeğeriniGirer() {
        wait.until(ExpectedConditions.visibilityOf(loginPage.emailInputBox));
        String email = ExcelHelper.getUsername();
        loginPage.emailInputBox.sendKeys(email);
        LOG.info("Kullanıcı e posta adresi olarak excelden aldığı değeri girer.");
    }

    @And("Kullanıcı password değeri olarak TrendyolUser excel dosyasındaki değerini girer.")
    public void kullanıcıPasswordDeğeriOlarakExcelDosyasındakiDeğeriniGirer() {
        wait.until(ExpectedConditions.visibilityOf(loginPage.passwordInputBox));
        String password = ExcelHelper.getPassword();
        loginPage.passwordInputBox.sendKeys(password);
        LOG.info("Kullanıcı password olarak excelden aldığı değeri girer.");

    }
}
