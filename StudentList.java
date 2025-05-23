// File Name: StudentList.java
import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {
        // STEP #2: Exit early if the number of arguments is incorrect
        if (args.length != 1) {
            System.out.println("Invalid number of arguments. Usage: java StudentList [option]");
            return;
        }

        String option = args[0];

        switch (option.charAt(0)) {
            case 'a':
                if (!option.equals("a")) break;
                System.out.println("Loading data ...");
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")))) {
                    for (String student : reader.readLine().split(",")) {
                        System.out.println(student.trim());
                    }
                    System.out.println("Data Loaded.");
                } catch (Exception exception) {
                    System.out.println("Error reading data.");
                }
                break;

            case 'r':
                if (!option.equals("r")) break;
                System.out.println("Loading data ...");
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")))) {
                    String[] students = reader.readLine().split(",");
                    System.out.println(students[new Random().nextInt(students.length)].trim());
                    System.out.println("Data Loaded.");
                } catch (Exception exception) {
                    System.out.println("Error reading data.");
                }
                break;

            case '+':
                if (option.length() < 2) {
                    System.out.println("Invalid format. Use: +Name");
                    break;
                }
                System.out.println("Loading data ...");
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt", true))) {
                    String dateTime = new SimpleDateFormat("dd/mm/yyyy-hh:mm:ss a").format(new Date());
                    writer.write(", " + option.substring(1) + "\nList last updated on " + dateTime);
                    System.out.println("Data Loaded.");
                } catch (Exception exception) {
                    System.out.println("Error writing data.");
                }
                break;

            case '?':
                if (option.length() < 2) {
                    System.out.println("Invalid format. Use: ?Name");
                    break;
                }
                System.out.println("Loading data ...");
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")))) {
                    for (String student : reader.readLine().split(",")) {
                        if (student.trim().equals(option.substring(1))) {
                            System.out.println("We found it!");
                            break;
                        }
                    }
                    System.out.println("Data Loaded.");
                } catch (Exception exception) {
                    System.out.println("Error reading data.");
                }
                break;

            case 'c':
                if (!option.equals("c")) break;
                System.out.println("Loading data ...");
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")))) {
                    String[] words = reader.readLine().trim().split("\\s+");
                    System.out.println(words.length + " word(s) found");
                    System.out.println("Data Loaded.");
                } catch (Exception exception) {
                    System.out.println("Error reading data.");
                }
                break;

            default:
                System.out.println("Invalid option. Available options:");
                System.out.println("  a       : Display all students");
                System.out.println("  r       : Display a random student");
                System.out.println("  +Name   : Add a new student");
                System.out.println("  ?Name   : Search for a student");
                System.out.println("  c       : Count words in the file");
                break;
        }
    }
}
