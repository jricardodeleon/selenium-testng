package Utils.dataProvider.DataReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.io.FileReader;
import java.io.IOException;

public class DataFileReader {

    private static final String propertyFilePath= "src/test/resources/datainfofile.properties";

    public static String getKey(String key){
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(propertyFilePath));
            Properties properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
            return properties.getProperty(key);
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
            throw new RuntimeException("datainfofile.properties not found at " + propertyFilePath);
        }
        
    }

}
