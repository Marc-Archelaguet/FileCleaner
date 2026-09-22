import java.io.File;
import java.util.List;
import java.util.Scanner;

public class FileCleanerApp {
    final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        OldFilesChecker oldFilesChecker = new OldFilesChecker(1);
        FileSorter fileSorter = new FileSorter();

        //Ask the user for a directory to clean
        File directory = getPath();
        File[] listFiles;


        try {

            int option;
            do {
                //Show Menu
                showMenu(directory);

                //Ask for an option to the User
                option = getOptionMenu();

                switch (option) {

                    //Case 1 -> List all the files
                    case 1:
                        System.out.println("Files list: ");
                        listAllFiles(directory);
                        break;

                    //Case 2 -> Show the old files found, and for each file ask if he wants to delete it
                    case 2:
                        //Get a list of the old files
                        listFiles = directory.listFiles();
                        List<File> oldFiles;

                        if (listFiles != null) {
                            oldFiles = oldFilesChecker.getOldFiles(listFiles);
                        } else {
                            oldFiles = null;
                        }

                        //Show the list and ask the user if want to delete it
                        handleOldFiles(oldFiles);

                        break;

                    //Case 3 -> Create one directory for each type of file, and sort them.
                    case 3:
                        listFiles = directory.listFiles();
                        for (File file : listFiles) {
                            fileSorter.moveToCategory(file);
                        }
                        break;

                        //Default option
                    default:
                        System.out.println("Invalid option. Select an option 0-3");
                }

            } while (option != 0);

        } catch (NumberFormatException e) {
            throw new NumberFormatException("The option must be a number from 0 to 3 " + e);
        }


    }

    private static void handleOldFiles(List<File> oldFiles) {

        if (oldFiles.isEmpty()) {
            System.out.println("No old files were found");
        } else {
            System.out.println(oldFiles.size() + " old files have been found");
            for (File f : oldFiles) {
                System.out.print("Do you want to delete " + f.getName() + "? (y/n): ");
                String answer = sc.nextLine().trim().toLowerCase();
                if (answer.equals("y")) {
                    if (f.delete()) {
                        System.out.println("Deleted!");
                    } else {
                        System.out.println("The file couldn't be deleted");
                    }
                }
            }
        }
    }

    private static void listAllFiles(File directory) {
        File[] list = directory.listFiles();
        if (list != null) {
            for (File f : list) {
                System.out.println(f.getName());
            }
        } else {
            System.out.println("There are not files in the directory " + directory);
        }
    }

    private static File getPath() {
        String directory;
        File path;
        do {
            //Ask the User for a directory
            System.out.print("Write the full path of the directory you want to clean: ");
            directory = sc.nextLine();
            path = new File(directory);

            if (!path.exists() || !path.isDirectory()) {
                System.out.println("It is not a directory or it doesn't exist");
            }

        } while (!path.isDirectory());

        return path;
    }

    private static int getOptionMenu() {
        System.out.print("Choose an option: ");
        return Integer.parseInt(sc.nextLine());
    }

    private static void showMenu(File directory) {
        System.out.println("=== FILE CLEANER APP ===");
        System.out.println("1. List all the files");
        System.out.println("2. Delete the old files");
        System.out.println("3. Sort the files of the directory " + directory.getName());
        System.out.println("0. Exit the app");
    }
}
