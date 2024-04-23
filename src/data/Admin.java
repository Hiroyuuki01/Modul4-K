package data;

import util.iMenu;


import java.util.ArrayList;
import java.util.Scanner;


public class Admin implements iMenu {
    @Override
    public void menu() {
        System.out.println("===== Admin Menu =====");
        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Tambah Buku");
        System.out.println("3. Tampilkan Mahasiswa Terdaftar");
        System.out.println("4. Tampilkan Buku Tersedia");
        System.out.println("5. Keluar");
        System.out.print("Pilih opsi (1-5): ");
    }
    private final String adminUsername;
    private final String adminPassword;

    private final ArrayList<Student> students;

    public Admin(String adminUsername, String adminPassword) {
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
        this.students = new ArrayList<>();
    }

    //overloading
    public void addStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama mahasiswa: ");
        String name = scanner.nextLine();
        System.out.print("Masukkan fakultas mahasiswa: ");
        String faculty = scanner.nextLine();
        System.out.print("Masukkan NIM mahasiswa: ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan program studi mahasiswa: ");
        String program = scanner.nextLine();

        students.add(new Student(name, null, null, null));
        System.out.println("Mahasiswa berhasil ditambahkan!");
    }

    public void addStudent(String name, String faculty, String nim, String program) {
        students.add(new Student(name, faculty, nim, program));
        System.out.println("Mahasiswa berhasil ditambahkan!");
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Mahasiswa berhasil ditambahkan!");
    }

    public void displayRegisteredStudents() {
        System.out.println("\n===== Mahasiswa Terdaftar =====");
        System.out.printf("%-20s %-20s %-15s %-20s\n", "Nama", "Fakultas", "NIM", "Program Studi");
        for (Student student : students) {
            System.out.printf("%-20s %-20s %-15s %-20s\n", student.getName(), student.getFaculty(), student.getNim(), student.getProgram());
        }
    }


}
