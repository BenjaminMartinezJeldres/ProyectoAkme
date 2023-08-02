package Akme.IGUPrincipal;

import Akme.controller.ProductController;
import Akme.model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuscarProducto extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton volverButton;
    private JTextField textField4;
    private JButton enviarButton;
    private JPanel Ventana;
    private JTextField textField5;

    public BuscarProducto(UserModel userModel, ProductController productController){
        add(Ventana);
        setSize(300,300);
        setTitle("Buscar Producto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textField1.setText(userModel.getFirstName());
        textField2.setText(userModel.getLastName());
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        PantallaPrincipal pantallaPrincipal = new PantallaPrincipal(userModel,productController);
                        pantallaPrincipal.setVisible(true);
                        pantallaPrincipal.setLocationRelativeTo(null);
                    }
                });
            }
        });
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(textField3.getText());
                int op = productController.listProductByIdG(id);
                switch (op){
                    case 1:
                        textField4.setText("Teclado");
                        KeyboardModel keyboard= productController.findKeyboardById(id);
                        textField5.setText("Marca:"+keyboard.getBrand() +", Modelo:"+ keyboard.getModel() +", Idioma:"+ keyboard.getLanguage() +", Precio:"+ keyboard.getPrice());
                        break;
                    case 2:
                        textField4.setText("Mouse");
                        MouseModel mouseModel = productController.findMouseById(id);
                        textField5.setText("Marca:"+mouseModel.getBrand() +", Modelo:"+ mouseModel.getModel() +", Precio:"+ mouseModel.getPrice());
                        break;
                    case 3:
                        textField4.setText("Pantalla");
                        MonitorModel monitorModel = productController.findMonitorById(id);
                        textField5.setText("Marca:"+ monitorModel.getBrand()+", Modelo:"+monitorModel.getModel()+", Tamaño:"+monitorModel.getSize()+", Precio:"+monitorModel.getPrice());
                        break;
                    case 4:
                        textField4.setText("Notebook");
                        NotebookModel notebookModel = productController.findNotebookById(id);
                        textField5.setText("Marca:"+ notebookModel.getBrand()+", Modelo:"+notebookModel.getModel()+", RAM:"+notebookModel.getRam()+", Procesador:"+notebookModel.getProcessor()+", Pantalla:"+notebookModel.getScreenSize()+", Precio:"+notebookModel.getPrice());
                        break;
                    case 5:
                        textField4.setText("PC de escritorio");
                        DesktopPCModel desktopPCModel = productController.findDesktopPCById(id);
                        textField5.setText("Marca:"+ desktopPCModel.getBrand()+", Modelo:"+desktopPCModel.getModel()+", RAM:"+desktopPCModel.getRam()+", Procesador:"+desktopPCModel.getProcessor()+", Pantalla:"+desktopPCModel.getMonitorData()+", Mouse:"+desktopPCModel.getMouseData()+", Teclado:"+desktopPCModel.getKeyboardData()+", Precio:"+desktopPCModel.getPrice());
                        break;
                }
            }
        });
    }
}
