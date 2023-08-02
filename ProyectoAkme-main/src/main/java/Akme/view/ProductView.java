package Akme.view;

import Akme.controller.ProductController;
import Akme.model.*;
import java.util.List;
import java.util.Scanner;

public class ProductView {
    private Scanner scanner;

    public ProductView() {
        scanner = new Scanner(System.in);
    }

    public void displayKeyboard(KeyboardModel product) {
        System.out.println("ID: " + product.getId());
        System.out.println("Marca: " + product.getBrand());
        System.out.println("Modelo: " + product.getModel());
        System.out.println("Idioma: "+ product.getLanguage());
        System.out.println("precio; " + product.getPrice());
        System.out.println();
    }
    public void displayMouse(MouseModel product) {
        System.out.println("ID: " + product.getId());
        System.out.println("Marca: " + product.getBrand());
        System.out.println("Modelo: " + product.getModel());
        System.out.println("Precio: " + product.getPrice());
        System.out.println();
    }
    public void displayNotebook(NotebookModel product) {
        System.out.println("ID: " + product.getId());
        System.out.println("Marca: " + product.getBrand());
        System.out.println("Modelo: " + product.getModel());
        System.out.println("RAM: " + product.getRam());
        System.out.println("Procesador: " + product.getProcessor());
        System.out.println("Tamaño de pantalla: " + product.getScreenSize());
        System.out.println("Precio: " + product.getPrice());
        System.out.println();
    }
    public void displayMonitor(MonitorModel product) {
        System.out.println("ID: " + product.getId());
        System.out.println("Marca: " + product.getBrand());
        System.out.println("Modelo: " + product.getModel());
        System.out.println("Tamaño: " + product.getSize());
        System.out.println("Precio: " + product.getPrice());
        System.out.println();
    }
    public void displayDesktopPC(DesktopPCModel product) {
        System.out.println("ID: " + product.getId());
        System.out.println("Marca: " + product.getBrand());
        System.out.println("Modelo: " + product.getModel());
        System.out.println("RAM: " + product.getRam());
        System.out.println("Procesador: " + product.getProcessor());
        System.out.println("Datos del teclado: "+product.getKeyboardData());
        System.out.println("Datos del mouse: "+product.getMouseData());
        System.out.println("Datos del monitor: "+product.getMonitorData());
        System.out.println("Precio: " + product.getPrice());
        System.out.println();
    }

    public void displayProducts(List<KeyboardModel> keyboardModels, List<MouseModel> mouseModels,List<MonitorModel> monitorModels,List<NotebookModel>notebookModels,List<DesktopPCModel>desktopPCModels) {
        for (KeyboardModel product : keyboardModels) {
            displayKeyboard(product);
        }
        for (MonitorModel product : monitorModels) {
            displayMonitor(product);
        }
        for (MouseModel product : mouseModels) {
            displayMouse(product);
        }
        for (NotebookModel product : notebookModels) {
            displayNotebook(product);
        }
        for (DesktopPCModel product : desktopPCModels) {
            displayDesktopPC(product);
        }
    }
    public int SelecProduct(){
        int opcion=0;
        System.out.println("Seleccione el tipo de producto:");
        System.out.println("1. Teclado");
        System.out.println("2. Mouse");
        System.out.println("3. Monitor");
        System.out.println("4. Notebook");
        System.out.println("5. PC de escritorio");
        opcion= scanner.nextInt();
        switch (opcion){
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
        }
        return 0;
    }

    public KeyboardModel crearKeyboar(){
        System.out.print("Ingrese el identificador único del producto: ");
        int id = scanner.nextInt();
        System.out.print("Ingrese la marca del producto: ");
        String brand = scanner.nextLine();
        System.out.print("Ingrese el modelo del producto: ");
        String model = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double price = scanner.nextInt();
        System.out.print("Ingrese el idioma del teclado: ");
        String language = scanner.nextLine();
        return new KeyboardModel(id, brand, model, language,price);
    }
    public MouseModel crearMouse(){
        System.out.print("Ingrese el identificador único del producto: ");
        int id = scanner.nextInt();
        System.out.print("Ingrese la marca del producto: ");
        String brand = scanner.nextLine();
        System.out.print("Ingrese el modelo del producto: ");
        String model = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double price = scanner.nextInt();
        return new MouseModel(id, brand, model,price);
    }
    public MonitorModel crearMonitor(){
        System.out.print("Ingrese el identificador único del producto: ");
        int id = scanner.nextInt();
        System.out.print("Ingrese la marca del producto: ");
        String brand = scanner.nextLine();
        System.out.print("Ingrese el modelo del producto: ");
        String model = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double price = scanner.nextInt();
        System.out.print("Ingrese el tamaño del monitor: ");
        double size = scanner.nextInt();
        return new MonitorModel(id, brand, model,size,price);
    }

    public NotebookModel crearNotebook(){
        System.out.print("Ingrese el identificador único del producto: ");
        int id = scanner.nextInt();
        System.out.print("Ingrese la marca del producto: ");
        String brand = scanner.nextLine();
        System.out.print("Ingrese el modelo del producto: ");
        String model = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double price = scanner.nextInt();
        System.out.print("Ingrese la cantidad de RAM de la notebook: ");
        int ram = scanner.nextInt();
        System.out.print("Ingrese el procesador de la notebook: ");
        String processor = scanner.nextLine();
        System.out.print("Ingrese el tamaño de pantalla de la notebook: ");
        double screenSize = scanner.nextInt();
        return new NotebookModel(id, brand, model, ram, processor, screenSize,price);
    }
    public DesktopPCModel crearDesktopPC(){
        System.out.print("Ingrese el identificador único del producto: ");
        int id = scanner.nextInt();
        System.out.print("Ingrese la marca del producto: ");
        String brand = scanner.nextLine();
        System.out.print("Ingrese el modelo del producto: ");
        String model = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double price = scanner.nextInt();
        System.out.print("Ingrese la cantidad de RAM de la PC de escritorio: ");
        int desktopRam = scanner.nextInt();
        System.out.print("Ingrese el procesador de la PC de escritorio: ");
        String desktopProcessor = scanner.nextLine();
        System.out.print("Ingrese los datos del teclado de la PC de escritorio: ");
        String keyboardData = scanner.nextLine();
        System.out.print("Ingrese los datos del mouse de la PC de escritorio: ");
        String mouseData = scanner.nextLine();
        System.out.print("Ingrese los datos del monitor de la PC de escritorio: ");
        String monitorData = scanner.nextLine();

        return new DesktopPCModel(id, brand, model, desktopRam, desktopProcessor, keyboardData, mouseData, monitorData,price);
    }


    public int getProductId() {
        System.out.print("Ingrese el ID del producto: ");
        return scanner.nextInt();
    }

    public void showProductNotFoundMessage() {
        System.out.println("Producto no encontrado.");
    }

    public void showProductCreatedMessage() {
        System.out.println("Producto creado exitosamente.");
    }

    public void showProductUpdatedMessage() {
        System.out.println("Producto actualizado exitosamente.");
    }

    public void showProductDeletedMessage() {
        System.out.println("Producto eliminado exitosamente.");
    }
    public void invalidID(){
        System.out.println("ID invalida. Intentelo de nuevo");
    }
}
