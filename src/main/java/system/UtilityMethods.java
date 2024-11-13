package system;

import driver.AppDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UtilityMethods {

    public static String getScreenShot(String imageName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) AppDriver.getReferenceOfDriver();
        File file = ts.getScreenshotAs(OutputType.FILE);
        String filePath = "./target/screenshots/screenshot_" + imageName + ".jpg";
        FileUtils.copyFile(file,new File(filePath));
        return filePath;
    }

    public static String getJsonBodyFromFile(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
