package com.main;

import data.User;
import data.Student;
import books.Book;
import data.Admin;


import java.util.ArrayList;
import java.util.Scanner;



public class Main {
    private static final ArrayList<Student> students = new ArrayList<>();
    public static final ArrayList<Book> books = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);



    public static void main(String[] args) {

        Book book1 = new Book("1012", "Apalaha Dia", "Jhoni" , "Comedy"     , 2);
        Book book2 = new Book("1013", "Tinggal 1cm", "jimer" , "Petualangan", 6);
        Book book3 = new Book("1014", "Violet Evergarden", "Rin", "Romance", 1);

        books.add(book1);
        books.add(book2);
        books.add(book3);

        while (true) {
            System.out.println("===== Library System =====");
            System.out.println("1. Login sebagai Student");
            System.out.println("2. Login sebagai Admin");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi (1-3): ");
            int userInput = scanner.nextInt();

            switch (userInput) {
                case 1:
                    loginAsStudent();
                    break;
                case 2:
                    menuAdmin();
                    break;
                case 3:
                    System.out.println("Terima kasih. Keluar dari program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Input tidak valid. Silakan coba lagi.");
            }
        }
    }

    public static void loginAsStudent() {
        System.out.println("===== Student Menu ====");
        System.out.print("Masukkan NIM Anda (masukkan 99 untuk kembali): ");

        String nim = scanner.next();

        if (nim.equals("99")) {
            System.out.println("Kembali ke menu utama...");
            return;
        }

        Student student = findStudentByNim(nim); //mencari objek student berdasarkan nim

        if (student == null) {
            System.out.println("Mahasiswa tidak ditemukan. Kembali ke menu utama...");
            return;
        }
        Student student1 = new Student("","","","");
        while (true) {
            student1.menu();
            int userInput = scanner.nextInt();

            switch (userInput) {
                case 1 -> student.viewBorrowedBooks();//memanggil metode dari objek student
                case 2 -> {
                    student.choiceBook();
                    student.borrowBook(books, scanner);
                }
                case 3 -> student.returnBook(books, scanner);
                case 4 -> {
                    student.borrowAllBook(books, scanner);
                    System.out.println("Keluar dari akun mahasiswa...");
                    return;
                }
                default -> System.out.println("Input tidak valid. Silakan coba lagi.");
            }
        }
    }

    public static Student findStudentByNim(String nim) {
        for (Student s : students) {
            if (s.getNim().equals(nim)) {
                return s;
            }
        }
        return null;
    }

    public static void menuAdmin() {
        Scanner input = new Scanner(System.in);
        User user = new User();
        Admin admin = new Admin("","");
        System.out.print("Enter your username (admin): ");
        String username = input.next();
        System.out.print("Enter your password (admin): ");
        String password = input.next();

        if (username.equals("admin") && password.equals("admin")) {
            System.out.println("Successful Login as Admin");
            admin.menu();
            int userInput = scanner.nextInt();

            switch (userInput) {
                case 1 -> addStudent();
                case 2 -> user.addBook();
                case 3 -> displayRegisteredStudents();
                case 4 -> user.displayBook();
                case 5 -> logout();
                default -> System.out.println("Input tidak valid. Silakan coba lagi.");
            }
        } else {
            System.out.println("Admin User Not Found !!");
        }

    }

    public static void addStudent() {
        System.out.print("Masukkan nama mahasiswa: ");
        String name = scanner.next();
        System.out.print("Masukkan fakultas mahasiswa: ");
        String faculty = scanner.next();

        String nim = inputNim();

        System.out.print("Masukkan program studi mahasiswa: ");
        String program = scanner.next();

        students.add(new Student(name, faculty, nim, program));
        System.out.println("Mahasiswa berhasil ditambahkan!");
    }

    public static String inputNim(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Masukkan NIM Mahasiswa (panjang 15 angka): ");
            String nim = scanner.nextLine();
            if (nim.length() == 15) {
                return nim;
            } else {
                System.out.println("Panjang NIM harus 15 angka. Silakan coba lagi.");
            }
        }
    }

    public static void displayRegisteredStudents() {
        System.out.println("\n===== Mahasiswa Terdaftar =====");
        System.out.printf("%-20s %-20s %-15s %-20s\n", "Nama", "Fakultas", "NIM", "Program Studi");
        for (Student student : students) {
            System.out.printf("%-20s %-20s %-15s %-20s\n", student.getName(), student.getFaculty(), student.getNim(), student.getProgram());
        }
    }

    public static void logout(){
        System.out.println("Keluar dari akun admin...");
    }
}