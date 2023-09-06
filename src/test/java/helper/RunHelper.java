package helper;

import config.ConfigReader;
import driver.EmulatorDriver;

public class RunHelper {
    private RunHelper(){
    }

    public static RunHelper runHelper(){
        return new RunHelper();
    }

    public Class<?> getDriverClass(){
        String deviceHost = ConfigReader.testConfig.deviceHost();

        switch (deviceHost){
            case "browserstack":
                //return BrowserStackMobile.class
            case "selenoid":
                //return SelenoidMobileDriver.class
            case "emulator":
                return EmulatorDriver.class;
            case "real":
                //return RealMobileDriver.class;
            default:
                throw new RuntimeException("not parameters");
        }
    }
}
