package Akme.IGUActualizar;

import Akme.IGUPrincipal.PantallaPrincipal;
import Akme.controller.ProductController;
import Akme.model.UserModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActualizarProducto extends JFrame {
    private JButton tecladoButton;
    private JButton pantallaButton;
    private JButton mouseButton;
    private JButton notebookButton;
    private JButton PCDeEscritorioButton;
    private JTextField textField1;
    private JTextField textField2;
    private JButton volverButton;
    private JPanel Ventana;
    public ActualizarProducto(UserModel userModel, ProductController productController){
        add(Ventana);
        setSize(300,300);
        setTitle("Actualizar Producto");
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
        tecladoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        ActualizarTeclado actualizarTeclado = new ActualizarTeclado(userModel,productController);
                        actualizarTeclado.setVisible(true);
                        actualizarTeclado.setLocationRelativeTo(null);
                    }
                });
            }
        });
        mouseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        ActualizarMouse actualizarMouse = new ActualizarMouse(userModel,productController);
                        actualizarMouse.setVisible(true);
                        actualizarMouse.setLocationRelativeTo(null);
                    }
                });
            }
        });
        pantallaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        ActualizarPantalla actualizarPantalla = new ActualizarPantalla(userModel,productController);
                        actualizarPantalla.setVisible(true);
                        actualizarPantalla.setLocationRelativeTo(null);
                    }
                });
            }
        });
        notebookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        ActualizarNoteBook actualizarNoteBook = new ActualizarNoteBook(userModel,productController);
                        actualizarNoteBook.setVisible(true);
                        actualizarNoteBook.setLocationRelativeTo(null);
                    }
                });
            }
        });
        PCDeEscritorioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        ActualizarDesktopPC actualizarDesktopPC = new ActualizarDesktopPC(userModel,productController);
                        actualizarDesktopPC.setVisible(true);
                        actualizarDesktopPC.setLocationRelativeTo(null);
                    }
                });
            }
        });

    }
}
