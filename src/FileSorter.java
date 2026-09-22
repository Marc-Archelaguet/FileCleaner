import javax.swing.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSorter {

    //Return the extension of the file
    public String getFileExtension(File file) {
        String nameFile = file.getName();
        String extension;


        //Extract the extension.
        int lastIndexOf = nameFile.lastIndexOf(".");
        if (lastIndexOf >= 0) {
            //Return the extension
            extension = nameFile.toLowerCase().trim().substring(lastIndexOf + 1);
        } else {
            return null;
        }

        return extension;
    }

    //Sort the files to each directory
    public void moveToCategory(File file) {

        String extension;
        String nameDirectory;

        if (file.isFile()) {
            extension = getFileExtension(file);

            switch (extension) {
                case "txt":
                    nameDirectory = "Text Files";
                    File path = new File("C:/Prova/" + nameDirectory);
                    if (!path.exists()) {
                        if (path.mkdir()) {
                            System.out.println("The directory " + path.getName() + " has been created successfully!");

                            //Once directory is created, move the file to the directory
                            if (file.renameTo(path)){
                                System.out.println("The file " + file.getName() + " has been moved to " + path.getName());
                            }

                        } else {
                            System.out.println("The directory " + path.getName() + " could not been created");
                        }
                    } else {
                        System.out.println("The directory " + path.getName() + " already exists");
                    }
                    break;

                case "png":
                    nameDirectory = "Images";
                    File path2 = new File("C:/Prova/" + nameDirectory);

                    if (!path2.exists()) {
                        if (path2.mkdir()) {
                            System.out.println("The directory " + path2.getName() + " has been created successfully!");
                            //Once directory is created, move the file to the directory
                            if (file.renameTo(path2)){
                                System.out.println("The file " + file.getName() + " has been moved to " + path2.getName());
                            }
                        } else {
                            System.out.println("The directory " + path2.getName() + " could not be created");
                        }
                    } else {
                        System.out.println("The directory " + path2.getName() + " already exists");
                    }
                    break;
            }



        }

    }

    public void moveToDirectory(File file){




    }

}
