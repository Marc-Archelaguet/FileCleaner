import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class OldFilesChecker {

    public long limitDays = 30;

    //Default Constructor (30 days)
    public OldFilesChecker() {

    }

    public OldFilesChecker(long limitDays) {
        this.limitDays = limitDays;
    }

    public List<File> getOldFiles(File[] file) {
        long lastModification = 0;
        List<File> oldFilesList = new ArrayList<>();

        for (File f : file) {

            if (f != null && f.isFile()) {
                long diferenceMillis = System.currentTimeMillis() - f.lastModified();
                long passedDays = diferenceMillis / (1000L * 60 * 60 * 24);

                if (passedDays >= limitDays) {
                    oldFilesList.add(f);
                }

            }

        }

        return oldFilesList;
    }

}
