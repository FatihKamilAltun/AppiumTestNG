package appiumtestng;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DenemeTest {
    public AppiumDriver<WebElement> driver;
    public WebDriverWait wait;

    By kurumsalButon = By.id("mobi.appcent.apponte:id/btnInstitutional");

    By girisYapButon = By.id("mobi.appcent.apponte:id/ibSignIn");

    By telefonNoButon = By.id("mobi.appcent.apponte:id/etPhoneNumber");

    By kodGonderButon = By.id("mobi.appcent.apponte:id/btnSendCode");

    By otpGonderButon = By.id("mobi.appcent.apponte:id/btnOTPContinue");



    @BeforeTest

    public void setup(){

        try {
            DesiredCapabilities cap;
            cap = new DesiredCapabilities();

            cap.setCapability("deviceName", "pixel_2");
            cap.setCapability("platformName", "Android");
            cap.setCapability("udid", "emulator-5554");
            cap.setCapability("platformVersion", "11.0");
            cap.setCapability("appPackage", "mobi.appcent.apponte");
            cap.setCapability("appActivity", "mobi.appcent.apponte.ui.activity.login.LoginActivity");
            cap.setCapability("skipUnlock", "true");
            cap.setCapability("noReset", "false");

            driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
            wait = new WebDriverWait(driver, 10);


        } catch (MalformedURLException test){
            System.out.println("HATA");
        }
    }

    @Test
    public void test01() {

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

       // WebElement kurumsalSecim = driver.findElement(kurumsalButon);
        driver.findElement(By.id("mobi.appcent.apponte:id/btnInstitutional")).click();
       // kurumsalSecim.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement girisYapSecim = driver.findElement(girisYapButon);
        girisYapSecim.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement telefon= driver.findElement(telefonNoButon);
        telefon.click();
        driver.getKeyboard().pressKey("5437709118");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement kod = driver.findElement(kodGonderButon);
        kod.click();



    }
}
