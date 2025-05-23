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

        if (option.equals("a")) {
            System.out.println("Loading data ...");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")))) {
                for (String student : reader.readLine().split(",")) {
                    System.out.println(student.trim());
                }
                System.out.println("Data Loaded.");
            } catch (Exception exception) {
                System.out.println("Error reading data.");
            }

        } else if (option.equals("r")) {
            System.out.println("Loading data ...");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")))) {
                String[] students = reader.readLine().split(",");
                System.out.println(students[new Random().nextInt(students.length)].trim());
                System.out.println("Data Loaded.");
            } catch (Exception exception) {
                System.out.println("Error reading data.");
            }

        } else if (option.startsWith("+")) {
            System.out.println("Loading data ...");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt", true))) {
                String dateTime = new SimpleDateFormat("dd/mm/yyyy-hh:mm:ss a").format(new Date());
                writer.write(", " + option.substring(1) + "\nList last updated on " + dateTime);
                System.out.println("Data Loaded.");
            } catch (Exception exception) {
                System.out.println("Error writing data.");
            }

        } else if (option.startsWith("?")) {
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

        } else if (option.equals("c")) {
            System.out.println("Loading data ...");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")))) {
                char[] chars = reader.readLine().toCharArray();
                boolean inWord = false;
                int wordCount = 0;
                for (char c : chars) {
                    if (c == ' ') {
                        if (!inWord) {
                            wordCount++;
                            inWord = true;
                        }
                    } else {
                        inWord = false;
                    }
                }
                System.out.println(wordCount + " word(s) found");
                System.out.println("Data Loaded.");
            } catch (Exception exception) {
                System.out.println("Error reading data.");
            }

        } else {
            System.out.println("Unknown command: " + option);
        }
    }
}
