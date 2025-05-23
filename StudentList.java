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
            try {
                BufferedReader fileReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream("students.txt"))
                );
                String studentData = fileReader.readLine();
                String[] studentList = studentData.split(",");
                for (String student : studentList) {
                    System.out.println(student.trim());
                }
                fileReader.close();
                System.out.println("Data Loaded.");
            } catch (Exception exception) {
                System.out.println("Error reading data.");
            }

        } else if (option.equals("r")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader fileReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream("students.txt"))
                );
                String studentData = fileReader.readLine();
                String[] studentList = studentData.split(",");
                Random randomGenerator = new Random();
                int randomIndex = randomGenerator.nextInt(studentList.length);
                System.out.println(studentList[randomIndex].trim());
                fileReader.close();
                System.out.println("Data Loaded.");
            } catch (Exception exception) {
                System.out.println("Error reading data.");
            }

        } else if (option.startsWith("+")) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter("students.txt", true));
                String newStudent = option.substring(1);
                Date currentDate = new Date();
                String dateFormatPattern = "dd/mm/yyyy-hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);
                String formattedDate = dateFormat.format(currentDate);
                fileWriter.write(", " + newStudent + "\nList last updated on " + formattedDate);
                fileWriter.close();
                System.out.println("Data Loaded.");
            } catch (Exception exception) {
                System.out.println("Error writing data.");
            }

        } else if (option.startsWith("?")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader fileReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream("students.txt"))
                );
                String studentData = fileReader.readLine();
                String[] studentList = studentData.split(",");
                String searchName = option.substring(1);
                boolean studentFound = false;

                for (String student : studentList) {
                    if (student.trim().equals(searchName)) {
                        System.out.println("We found it!");
                        studentFound = true;
                        break;
                    }
                }

                fileReader.close();
                System.out.println("Data Loaded.");
            } catch (Exception exception) {
                System.out.println("Error reading data.");
            }

        } else if (option.equals("c")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader fileReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream("students.txt"))
                );
                String studentData = fileReader.readLine();
                char[] characters = studentData.toCharArray();
                boolean inWord = false;
                int wordCount = 0;

                for (char character : characters) {
                    if (character == ' ') {
                        if (!inWord) {
                            wordCount++;
                            inWord = true;
                        }
                    } else {
                        inWord = false;
                    }
                }

                System.out.println(wordCount + " word(s) found");
                fileReader.close();
                System.out.println("Data Loaded.");
            } catch (Exception exception) {
                System.out.println("Error reading data.");
            }

        } else {
            System.out.println("Unknown command: " + option);
        }
    }
}
