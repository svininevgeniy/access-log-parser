import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
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

            try {
                FileReader fileReader = new FileReader(path);
                BufferedReader reader =
                        new BufferedReader(fileReader);
                String line;
                ArrayList<Integer> lengthsOfLines = new ArrayList<Integer>();
                while ((line = reader.readLine()) != null) {
                    int length = line.length();
                    if (length > 1024) throw new RuntimeException("Some line in the file has length over 1024 symbols");
                    lengthsOfLines.add(length);
                }
                System.out.println(lengthsOfLines.size());
                System.out.println(Collections.max(lengthsOfLines));
                System.out.println(Collections.min(lengthsOfLines));
            } catch (FileNotFoundException exception1) {
                exception1.printStackTrace();
            } catch (IOException exception2) {
                exception2.printStackTrace();
            }
        }
    }
}

