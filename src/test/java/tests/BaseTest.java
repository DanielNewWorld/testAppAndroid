package tests;

import static helper.Constans.SCREENSHOT_TO_SAVE_FOLDER;
import static helper.DeviceHelper.executeBash;
import static helper.RunHelper.runHelper;
import static io.qameta.allure.Allure.step;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import config.ConfigReader;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import listeners.AllureListener;

@ExtendWith(AllureListener.class)
public class BaseTest {
    @BeforeAll
    public static void setup(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.reportsFolder = SCREENSHOT_TO_SAVE_FOLDER;
        Configuration.browser = runHelper().getDriverClass().getName();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;

        //disableAnimationOnEmulator();
        System.out.println("info: init base");
    }

    private static void disableAnimationOnEmulator(){
        executeBash("adb -s shell settings put global transition_animation_scale 0.0");
        executeBash("adb -s shell settings put global window_animation_scale 0.0");
        executeBash("adb -s shell settings put global animator_duration_scale 0.0");
    }

    public void assertScreenshot(File actualScreenshot, String expectedFileName){
        expectedFileName = expectedFileName.replace("()",".png");
        String expectedScreenDir = "src/test/resources/expectedScreenshots/";

        if (ConfigReader.testConfig.isScreenshotsNeedToUpdate()){
            try {
                Files.move(actualScreenshot.toPath(), new File(expectedScreenDir + expectedFileName).toPath(),
                        StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e){
                throw new RuntimeException(e);
            }
            return;
        }

//        BufferedImage expectedImage = ImageComparisonUtil
//                .readImageFromResources(expectedScreenDir + expectedFileName);
//
//        BufferedImage actualImage = ImageComparisonUtil
//                .readImageFromResources(SCREENSHOT_TO_SAVE_FOLDER + actualScreenshot.getName());

        File resultDestination = new File("diff/diff_" + expectedFileName);
        //ImageComparisonResult imageComparisonResult = ImageComparison(expectedImage, actualImage, resultDestination)
        //        .compareImages();
//        if (imageComparisonResult.getImageComparisonState().equals(ImageComparisonState.MISMATCH)){
//            try {
//                byte[] diffImageBytes = Files.readAllBytes(resultDestination.toPath());
//                AllureListener.saveScreenshot(diffImageBytes);
//            } catch (IOException e){
//                throw new RuntimeException(e);
//            }
//        }

        //assertEquals(ImageComparisonState.MATCH, imageComparisonResult.getImageComparisonState());
    }

    @BeforeEach
    public void startDriver(){
        step("Open app", (Allure.ThrowableRunnableVoid) Selenide::open);
        System.out.println("info: start driver");
    }

    @AfterEach
    public void AfterEach(){
        //step("Close app", Selenide::closeWebDriver);
    }
}
