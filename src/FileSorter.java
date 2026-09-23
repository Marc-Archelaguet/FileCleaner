import javax.sound.sampled.Line;
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


        try {
            //Extract the extension.
            int lastIndexOf = nameFile.lastIndexOf(".");
            if (lastIndexOf >= 0) {
                //Return the extension
                extension = nameFile.toLowerCase().trim().substring(lastIndexOf + 1);
            } else {
                return null;
            }

        } catch (IndexOutOfBoundsException ex) {
            throw new IndexOutOfBoundsException("Error " + ex);
        }

        return extension;
    }

    //Sort the files to each directory
    public void moveToCategory(File file) {

        String extension;
        String nameDirectory;

        if (!file.isFile()) {
            return;
        }

        extension = getFileExtension(file);

        switch (extension) {
            case "txt":
                nameDirectory = "Text Files";
                break;

            case "png":
                nameDirectory = "Images";
                break;

            default:
                nameDirectory = "Others";
        }

        File destinyDirectory = new File(file.getParentFile(), nameDirectory);

        if (!destinyDirectory.exists()) {
            if (destinyDirectory.mkdir()) {
                System.out.println("Directory " + destinyDirectory.getName() + " created successfully");
            } else {
                System.out.println("Directory " + destinyDirectory.getName() + " could not be created");
            }
        }

        File finalFile = new File(destinyDirectory, file.getName());

        if (file.renameTo(finalFile)) {
            System.out.println("The file " + file.getName() + " has been moved to " + finalFile.getName());
        }
    }

}
