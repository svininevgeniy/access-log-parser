import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numberFile = 0;

        while (true) {
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);
            boolean fileExists = file.exists();
            boolean isDirectory = file.isDirectory();

            if (!fileExists || isDirectory) {
                System.out.println("File is not exist or you entered path to directory. Please repeat enter:");
                continue;
            } else {
                numberFile++;
                System.out.println("Path is correct. It is file №" + numberFile);

            }
        }
    }
}

