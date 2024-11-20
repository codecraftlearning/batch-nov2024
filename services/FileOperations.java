package services;

import java.io.*;
import java.nio.charset.Charset;

public class FileOperations {

    public static File getFile(String fileName, String extension) {
        return new File(fileName+"."+extension);
    }

    public static File createFile(File file) {
        if (!check(file)) {
            return null;
        }

        try {
            if (file.createNewFile()) {
                System.out.println("File Created with name: "+ file.getName());
            } else {
                System.out.println("File with this name already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }

    public static File writeIntoFile (File file, String content) {
        if (!check(file)) {
            return null;
        }

        try (FileWriter fileWriter = new FileWriter(file.getPath(),true)) {
            fileWriter.write(content);
            System.out.println("File updated with the content");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }

    public static String readFromFile(File file) {
        if (!check(file)) {
            return null;
        }

        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return content.toString();
    }

    public static void deleteFile (File file) {

        if (file.delete()) {
            System.out.println("File deleted Successfully");
        } else {
            System.out.println("Failed to delete the file");
        }
    }

    public static void writeObject(Object object, String path) {
        try (FileOutputStream fileOut = new FileOutputStream(path)) {
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(object);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object readObject(String path) {
        Object object = null;
        try (FileInputStream fileInput = new FileInputStream(path)) {
            ObjectInputStream in = new ObjectInputStream(fileInput);
            object = in.readObject();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return object;
    }



    private static boolean check(File file) {
        if (file == null) {
            return false;
        }

        if (!file.getParent().contains("resourses\\blobs")) {
            return false;
        }

        return true;
    }
}
