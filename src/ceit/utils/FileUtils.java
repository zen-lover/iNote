package ceit.utils;

import java.io.*;
import java.util.Scanner;

public class FileUtils {

    private static final String NOTES_PATH = "./notes/";

    //It's a static initializer. It's executed when the class is loaded.
    //It's similar to constructor
    static {
        boolean isSuccessful = new File(NOTES_PATH).mkdirs();
        System.out.println("Creating " + NOTES_PATH + " directory is successful: " + isSuccessful);
    }

    public static File[] getFilesInDirectory() {
        return new File(NOTES_PATH).listFiles();
    }

    public static String fileReader(File file) {
        String content = "";
        try {
            File myObj = file;
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                content += data + "\n";
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return content;
    }

    public static void fileWriter(String content) {

        String fileName = getProperFileName(content);

        // Create file
//        try {
//            File myObj = new File("./notes/" + fileName);
//            if (myObj.createNewFile()) {
//                System.out.println("File created: " + myObj.getName());
//            } else {
//                System.out.println("File already exists.");
//            }
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }

        // Write content in file
        try {
            FileWriter myWriter = new FileWriter("./notes/" + fileName);
            myWriter.write(content);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String fileInputStream(File file) {
        String content = "";
        try {
            FileInputStream fin = new FileInputStream(file.getPath());
            int i = 0;
            while ((i = fin.read()) != -1) {
                char c = (char) i;
                content += c;
            }
            fin.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return content;
    }

    public static void fileOutputStream(String content) {
        String fileName = getProperFileName(content);
        try {
            FileOutputStream fout = new FileOutputStream("./notes/" + fileName);
            byte b[] = content.getBytes();//converting string into byte array
            fout.write(b);
            fout.close();
            System.out.println("success...");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //TODO: Phase2: proper methods for handling serialization

    private static String getProperFileName(String content) {
        int loc = content.indexOf("\n");
        if (loc != -1) {
            return content.substring(0, loc);
        }
        if (!content.isEmpty()) {
            return content;
        }
        return System.currentTimeMillis() + "_new file.txt";
    }
}
