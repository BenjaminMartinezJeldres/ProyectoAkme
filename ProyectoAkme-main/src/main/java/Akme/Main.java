package Akme;


import Akme.IGUPrincipal.Login;
import Akme.controller.LoginController;
import Akme.controller.ProductController;
import Akme.model.KeyboardModel;
import Akme.model.ProductModel;
import Akme.model.UserModel;
import Akme.view.LoginView;
import Akme.view.ProductView;

import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserModel userDefaul= new UserModel(001,"userDefault","user123","Camilo","Figueroa","valderrama");
        LoginView loginView = new LoginView();
        LoginController loginController = new LoginController(loginView);
        loginController.AddUser(userDefaul);
        ProductView productView = new ProductView();
        ProductController productController = new ProductController(productView);
        productController.createDefaultProduct();
        Scanner scanner = new Scanner(System.in);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Login login = new Login(loginController,productController);
                login.setVisible(true);
                login.setLocationRelativeTo(null);

            }

        });
        boolean In=false;
        while(!In){
            String code=".";
            code = scanner.nextLine();
            if(code.equals("--no-gui")){
                In = true;
            }
        }

        boolean authenticated = false;

        while (!authenticated) {
            authenticated = loginController.authenticateUser();

            if (!authenticated) {
                System.out.println("Nombre de usuario o contraseña incorrectos. Inténtelo de nuevo.");
            }
        }




        boolean exit = false;

        while (!exit) {
            System.out.println("Elige una opción:");
            System.out.println("1. Crear un producto");
            System.out.println("2. Actualizar un producto");
            System.out.println("3. Eliminar un producto");
            System.out.println("4. Listar todos los productos");
            System.out.println("5. Buscar un producto por ID");
            System.out.println("6.Crear un usuario");
            System.out.println("0. Salir");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        productController.createProduct();
                        break;
                    case 2:
                        productController.updateProduct();
                        break;
                    case 3:
                        productController.deleteProduct();
                        break;
                    case 4:
                        productController.listAllProducts();
                        break;
                    case 5:
                        productController.listProductById();
                        break;
                    case 6:
                        UserModel userModel = createUser();
                        loginController.AddUser(userModel);
                        break;
                    case 0:
                        exit = true;
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, intenta nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Opción inválida. Por favor, intenta nuevamente.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static UserModel createUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID del usuario: ");
        int userId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el nombre de usuario: ");
        String username = scanner.nextLine();

        System.out.print("Ingrese la contraseña: ");
        String password = scanner.nextLine();

        System.out.print("Ingrese los nombres: ");
        String firstName = scanner.nextLine();

        System.out.print("Ingrese el apellido paterno: ");
        String lastName = scanner.nextLine();

        System.out.print("Ingrese el apellido materno: ");
        String middleName = scanner.nextLine();

        UserModel newUserModel = new UserModel(userId, username, password, firstName, lastName, middleName);
        return newUserModel;
    }
}
