package driver;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import config.ConfigReader;
import helper.ApkInfoHelper;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import javax.annotation.Nonnull;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class EmulatorDriver implements WebDriverProvider {
    protected static AndroidDriver driver;
    private static final String DEVICE_NAME = ConfigReader.emulatorConfig.deviceName();
    private static final String PLATFORM_NAME = ConfigReader.emulatorConfig.platformName();
    private static String APP_PACKAGE = ConfigReader.emulatorConfig.appPackage();
    private static String APP_ACTIVITY = ConfigReader.emulatorConfig.appActivity();
    private static final String APP = ConfigReader.emulatorConfig.app();
    private static final String URL = ConfigReader.emulatorConfig.remoteURL();

    public static URL getUrl(){
        try {
            return new URL(URL);
        } catch (MalformedURLException e){
            throw new RuntimeException(e);
        }
    }

    private void initPackageAndActivity(){
        ApkInfoHelper helper = new ApkInfoHelper();
        APP_PACKAGE = APP_PACKAGE.isEmpty() ? helper.getAppPackageFromApk() : APP_PACKAGE;
        APP_ACTIVITY = APP_ACTIVITY.isEmpty() ? helper.getAppMainActivity() : APP_ACTIVITY;
    }

    private String getAbsolutePath(String filePath) {
        File file = new File(filePath);
        //assertTrue(file.exists(), filePath + " not found");
        return file.getAbsolutePath();
    }

    @Nonnull
    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilitieses){
        initPackageAndActivity();
        desiredCapabilitieses.setCapability("autoGrantPermissions", "true");
        desiredCapabilitieses.setCapability("deviceName", DEVICE_NAME);
        desiredCapabilitieses.setCapability("platformName", PLATFORM_NAME);
        desiredCapabilitieses.setCapability("appPackage", APP_PACKAGE);
        desiredCapabilitieses.setCapability("appActivity", APP_ACTIVITY);
        desiredCapabilitieses.setCapability("app", getAbsolutePath(APP));

        driver = new AndroidDriver<>(getUrl(), desiredCapabilitieses);

        return driver;
    }
}
