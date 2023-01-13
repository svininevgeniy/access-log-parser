import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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
                ArrayList<Integer> lengthsOfLines = new ArrayList<>();

                ArrayList<String> ipAndDate = new ArrayList<>();
                ArrayList<String> methodsAndPaths = new ArrayList<>();
                ArrayList<String> statusCodesAndBytes = new ArrayList<>();
                ArrayList<String> refererLinks = new ArrayList<>();
                ArrayList<String> spaces = new ArrayList<>();
                ArrayList<String> userAgentData = new ArrayList<>();

                while ((line = reader.readLine()) != null) {
                    int length = line.length();
                    if (length > 1024) throw new RuntimeException("Some line in the file has length over 1024 symbols");
                    lengthsOfLines.add(length);

                    //разделяем каждую строку кавычками на массив строк
                    String[] array = line.split("\"");

                    //распределяем элементы файла по листам
                    ipAndDate.add(array[0]);
                    methodsAndPaths.add(array[1]);
                    statusCodesAndBytes.add(array[2]);
                    refererLinks.add(array[3]);
                    userAgentData.add(array[5]);
                }
                System.out.println(lengthsOfLines.size());


                //рассчет запросов от Googlebot
                int counter = 0;
                for (int i = 0; i < userAgentData.size(); i++) {
                    if (userAgentData.get(i).contains("Googlebot")) counter++;
                }
                System.out.println(counter);

                //рассчет запросов от YandexBot
                int counter2 = 0;
                for (int i = 0; i < userAgentData.size(); i++) {
                    if (userAgentData.get(i).contains("YandexBot")) counter2++;
                }
                System.out.println(counter2);

            } catch (FileNotFoundException exception1) {
                exception1.printStackTrace();
            } catch (IOException exception2) {
                exception2.printStackTrace();
            }
        }
    }
}

