package tests;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

import java.io.File;

public class ScreenshotTests extends BaseTest{
    private TestInfo testInfo;

    @BeforeEach
    public void init(TestInfo testInfo){
        this.testInfo = testInfo;
    }

    @Test
    public void testMainCatalogScreenshot(){
//        File mainScreenshot = new MainPage()
//                .closePopUp()
//                .openCatalog()
//                .fullPageScreenshot;
//        assertScreenshot(mainScreenshot, testInfo.getDisplayName());
    }
}
