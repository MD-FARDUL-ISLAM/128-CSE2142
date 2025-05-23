// File Name: StudentList.java
import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {
        // STEP #2: Exit early if no arguments are provided
        if (args.length != 1) {
            System.out.println("Invalid number of arguments. Usage: java StudentList [option]");
            return;
        }

        String command = args[0];

        if (command.equals("a")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream("students.txt"))
                );
                String line = reader.readLine();
                String[] students = line.split(",");
                for (String student : students) {
                    System.out.println(student.trim());
                }
                reader.close();
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("Error reading data.");
            }

        } else if (command.equals("r")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream("students.txt"))
                );
                String line = reader.readLine();
                String[] students = line.split(",");
                Random random = new Random();
                int index = random.nextInt(students.length);
                System.out.println(students[index].trim());
                reader.close();
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("Error reading data.");
            }

        } else if (command.contains("+")) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt", true));
                String newStudent = command.substring(1);
                Date date = new Date();
                String dateFormat = "dd/mm/yyyy-hh:mm:ss a";
                DateFormat formatter = new SimpleDateFormat(dateFormat);
                String formattedDate = formatter.format(date);
                writer.write(", " + newStudent + "\nList last updated on " + formattedDate);
                writer.close();
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("Error writing data.");
            }

        } else if (command.contains("?")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream("students.txt"))
                );
                String line = reader.readLine();
                String[] students = line.split(",");
                String target = command.substring(1);
                boolean found = false;

                for (String student : students) {
                    if (student.trim().equals(target)) {
                        System.out.println("We found it!");
                        found = true;
                        break;
                    }
                }

                reader.close();
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("Error reading data.");
            }

        } else if (command.equals("c")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream("students.txt"))
                );
                String line = reader.readLine();
                char[] characters = line.toCharArray();
                boolean inWord = false;
                int wordCount = 0;

                for (char ch : characters) {
                    if (ch == ' ') {
                        if (!inWord) {
                            wordCount++;
                            inWord = true;
                        }
                    } else {
                        inWord = false;
                    }
                }

                System.out.println(wordCount + " word(s) found");
                reader.close();
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("Error reading data.");
            }

        } else {
            System.out.println("Unknown command: " + command);
        }
    }
}
