package Akme.IGUCreacion;

import Akme.IGUPrincipal.PantallaPrincipal;
import Akme.controller.ProductController;
import Akme.model.UserModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearProducto extends JFrame {
    private JButton tecladoButton;
    private JButton pantallaButton;
    private JButton mouseButton;
    private JButton notebookButton;
    private JButton PCDeEscritorioButton;
    private JTextField textField1;
    private JTextField textField2;
    private JPanel Ventana;
    private JButton volverButton;

    public CrearProducto(UserModel userModel,ProductController productController){
        add(Ventana);
        setSize(300,300);
        setTitle("Crear Producto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textField1.setText(userModel.getFirstName());
        textField2.setText(userModel.getLastName());
        tecladoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        CrearTeclado crearTeclado = new CrearTeclado(userModel,productController);
                        crearTeclado.setVisible(true);
                        crearTeclado.setLocationRelativeTo(null);
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
                        CrearPantalla crearPantalla = new CrearPantalla(userModel,productController);
                        crearPantalla.setVisible(true);
                        crearPantalla.setLocationRelativeTo(null);
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
                        CrearMouse crearMouse = new CrearMouse(userModel,productController);
                        crearMouse.setVisible(true);
                        crearMouse.setLocationRelativeTo(null);
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
                        CrearNotebook crearNotebook = new CrearNotebook(userModel,productController);
                        crearNotebook.setVisible(true);
                        crearNotebook.setLocationRelativeTo(null);
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
                        CrearDesktopPC crearDesktopPC = new CrearDesktopPC(userModel,productController);
                        crearDesktopPC.setVisible(true);
                        crearDesktopPC.setLocationRelativeTo(null);
                    }
                });
            }
        });
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
    }
}
