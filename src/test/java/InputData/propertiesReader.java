package InputData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class propertiesReader {
	
	public static String read(String filepath, String key) {
		
        Properties pro = new Properties();
        
        
        try {
        	File file = new File(System.getProperty("user.dir")+filepath);
			FileInputStream stream = new FileInputStream(file);
			pro.load(stream);
		} catch (FileNotFoundException e) {
		System.out.println("Error occurred :  " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error occurred :  " + e.getMessage());
		} 
		catch (NullPointerException e) {
			System.out.println("Error occurred :  " + e.getMessage());
		} 
        
        //stream for reading file
        /*File file = new File(System.getProperty("user.dir")+filepath);
        FileInputStream stream = new FileInputStream(file);
          pro.load(stream);*/

        return pro.getProperty(key);
    }

}
