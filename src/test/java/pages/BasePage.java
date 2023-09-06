package pages;

import static com.codeborne.selenide.Selenide.$;

import java.io.File;

import io.appium.java_client.MobileBy;

public class BasePage{
    public File fullPAgeScreenshot(){
        return $(MobileBy.id("composerRootCl")).screenshot();
    }
}
