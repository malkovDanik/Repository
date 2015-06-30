import javafx.scene.image.Image;
import org.apache.log4j.Logger;

import java.io.File;
import java.nio.file.Path;

/**
 * Created by Даник
 * on 29.06.2015.
 */
public class Main {
    public static final String LOG_PROPERTIES_FILE = "log4j.properties";
    private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Config config  = new Config(LOG_PROPERTIES_FILE);
        config.init();

        logger.info("Program run...");
        System.out.println("Hello");
    }
}
