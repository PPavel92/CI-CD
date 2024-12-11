import java.io.*;
import java.nio.file.*;

public class BackupFiles {
    public static void main(String[] args) {
        String sourceDir = ".";
        String backupDir = "./backup";

        File backupFolder = new File(backupDir);
        if (!backupFolder.exists()) {
            backupFolder.mkdir();
        }

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(sourceDir))) {
            for (Path entry : stream) {

                if (Files.isRegularFile(entry)) {

                    Path backupPath = Paths.get(backupDir, entry.getFileName().toString());
                    Files.copy(entry, backupPath, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Файл " + entry.getFileName() + " успешно скопирован в " + backupDir);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
