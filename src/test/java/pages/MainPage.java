package pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

public class MainPage extends BasePage{
    private SelenideElement elementMenu = $(MobileBy.id("menu_main"));

    @Step("Open menu")
    public void clickMenu(){
        //elementMenu.click();
        System.out.println("info: click menu");
    }
}