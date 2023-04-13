package Utilities;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class UtilityParserJSON {

    public static <T> T getTestData(String key){

        Logger log = LoggerObject.getLogger();

        try {
            File f = new File("src/test/java/Resources/TestDataJson");
            if (f.exists()){
                InputStream is = new FileInputStream("src/test/java/Resources/TestDataJson");
                String jsonValue = IOUtils.toString(is, StandardCharsets.UTF_8);
                JSONObject json = new JSONObject(jsonValue);

                switch (key) {
                    case "FirstAlertText" -> {
                        return (T) json.getString(key);
                    }
                    case  "users" -> {
                        return (T) json.getJSONArray(key);
                    }
                }
            }
        } catch (IOException e) {
            log.info("TestDataJson File not found exception");
        }
        return null;
    }
}



