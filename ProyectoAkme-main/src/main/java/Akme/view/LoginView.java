package Akme.view;

import java.util.Scanner;

public class LoginView {
    private Scanner scanner;

    public LoginView() {
        scanner = new Scanner(System.in);
    }

    public int getUserId() {
        System.out.print("Ingrese el ID del usuario: ");
        return scanner.nextInt();
    }

    public String getUsername() {
        System.out.print("Ingrese su nombre de usuario: ");
        return scanner.nextLine();
    }

    public String getPassword() {
        System.out.print("Ingrese su contraseña: ");
        return scanner.nextLine();
    }

    public String getFirstName() {
        System.out.print("Ingrese su nombre: ");
        return scanner.nextLine();
    }

    public String getLastName() {
        System.out.print("Ingrese su apellido paterno: ");
        return scanner.nextLine();
    }

    public String getMiddleName() {
        System.out.print("Ingrese su apellido materno: ");
        return scanner.nextLine();
    }

    public void showLoginSuccessMessage() {
        System.out.println("Inicio de sesión exitoso!");
    }

    public void showLoginErrorMessage() {
        System.out.println("Nombre de usuario o contraseña incorrectos. Inténtelo de nuevo.");
    }
}
