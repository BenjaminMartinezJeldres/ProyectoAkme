package Akme.IGUActualizar;

import Akme.IGUCreacion.CrearProducto;
import Akme.controller.ProductController;
import Akme.model.UserModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActualizarNoteBook extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JButton enviarButton;
    private JButton volverButton;
    private JPanel Ventana;
    public ActualizarNoteBook(UserModel userModel, ProductController productController){
        add(Ventana);
        setSize(300,400);
        setTitle("Actualizar Notebook");
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
                        ActualizarProducto actualizarProducto = new ActualizarProducto(userModel,productController);
                        actualizarProducto.setVisible(true);
                        actualizarProducto.setLocationRelativeTo(null);
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
                if(productController.updateNotebook(id,brand, model,ram,processor,screenSize,price)){
                    JOptionPane.showMessageDialog(Ventana,"Producto actualizado");
                }else{
                    JOptionPane.showMessageDialog(Ventana,"No se pudo actualizar el producto.Intente de nuevo");
                }
            }
        });
    }
}
