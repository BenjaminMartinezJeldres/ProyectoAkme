package Akme.IGUCreacion;

import Akme.IGUPrincipal.PantallaPrincipal;
import Akme.controller.ProductController;
import Akme.model.UserModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearNotebook extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton enviarButton;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JButton volverButton;
    private JPanel Ventana;
    private JTextField textField9;

    public CrearNotebook(UserModel userModel, ProductController productController){
        add(Ventana);
        setSize(300,400);
        setTitle("Crear Notebook");
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
                        CrearProducto crearProducto = new CrearProducto(userModel,productController);
                        crearProducto.setVisible(true);
                        crearProducto.setLocationRelativeTo(null);
                    }
                });
            }
        });
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id =Integer.parseInt(textField3.getText());
                String brand = textField4.getText();
                String model = textField5.getText();
                int ram = Integer.parseInt(textField6.getText());
                String processor = textField7.getText();
                double screenSize = Integer.parseInt(textField8.getText());
                double price =Integer.parseInt(textField9.getText());
                if(productController.validarNoteBookG(id,brand, model,ram,processor,screenSize,price)){
                    JOptionPane.showMessageDialog(Ventana,"Producto creado");
                }else{
                    JOptionPane.showMessageDialog(Ventana,"El Producto no se puedo crear ID repetida");
                }

            }
        });
    }
}
