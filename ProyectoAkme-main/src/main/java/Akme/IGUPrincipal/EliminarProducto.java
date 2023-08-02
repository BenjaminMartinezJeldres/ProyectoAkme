package Akme.IGUPrincipal;

import Akme.controller.ProductController;
import Akme.model.UserModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EliminarProducto extends JFrame{
    private JPanel Ventana;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton enviarButton;
    private JButton volverButton;
    public EliminarProducto(UserModel userModel, ProductController productController){
        add(Ventana);
        setSize(300,300);
        setTitle("Eliminar Producto");
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

                if(productController.deleteProductG(id)){
                    textField3.setText("");
                    JOptionPane.showMessageDialog(Ventana,"Producto con ID = "+ id +" fue eliminado correctamente");
                }else{
                    textField3.setText("");
                    JOptionPane.showMessageDialog(Ventana,"ID no encontrada o incorrecta. Intente de nuevo");
                }
            }
        });
    }
}
