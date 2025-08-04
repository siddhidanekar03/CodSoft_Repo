import java.io.*;
import java.util.*;

public class StudentManagementSystem {
    private List<Student> students = new ArrayList<>();
    private final String filePath = "students.dat";

    public StudentManagementSystem() {
        loadFromFile();
    }

    public void addStudent(Student s) {
        students.add(s);
        System.out.println("✅ Student added successfully.");
        saveToFile();
    }

    public boolean removeStudent(int rollNo) {
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            if (it.next().getRollNumber() == rollNo) {
                it.remove();
                System.out.println("✅ Student removed.");
                saveToFile();
                return true;
            }
        }
        return false;
    }

    public Student searchStudent(int rollNo) {
        for (Student s : students) {
            if (s.getRollNumber() == rollNo)
                return s;
        }
        return null;
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("⚠️ No students to display.");
            return;
        }
        for (Student s : students)
            System.out.println(s);
    }

    public void editStudent(int rollNo, String newName, String newGrade, String newEmail) {
        Student s = searchStudent(rollNo);
        if (s != null) {
            s.setName(newName);
            s.setGrade(newGrade);
            s.setEmail(newEmail);
            System.out.println(" Student updated.");
            saveToFile();
        } else {
            System.out.println("Student not found.");
        }
    }

    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println(" Error saving to file.");
        }
    }

    private void loadFromFile() {
        File file = new File(filePath);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            students = (List<Student>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Error loading student data.");
        }
    }
}

