package iopractice;

import java.io.*;

/**
 *
 * @author schra_000
 */
public class Startup {
    
    public static void main(String[] args) {
        File data = new File(File.separatorChar + "temp" + File.separatorChar 
                        + "lab1.txt");
        
        BufferedReader in = null;
        try {
	   in = new BufferedReader(new FileReader(data));  // **opening stream**
	   String line = in.readLine();
	   while(line != null){
		  System.out.println(line);
		  line = in.readLine();  
	   }
	 
        } catch(IOException ioe) {
            System.out.println("Houston, we have a problem! reading this file");
        } finally {
            try {
                in.close();  // **closing stream**
            } catch(Exception e) {
                System.out.println("Sorry could not close stream.");
            }
        }
    }
}
