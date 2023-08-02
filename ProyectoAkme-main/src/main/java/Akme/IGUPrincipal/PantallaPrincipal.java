package Akme.IGUPrincipal;

import Akme.IGUActualizar.ActualizarProducto;
import Akme.IGUCreacion.CrearProducto;
import Akme.controller.ProductController;
import Akme.model.UserModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaPrincipal extends JFrame {
    private JPanel Ventana;
    private JTextField textField1;
    private JTextField textField2;
    private JButton crearUnProductoButton;
    private JButton actualizarUnProductoButton;
    private JButton eliminarUnProductoButton;
    private JButton listarTodosLosProductosButton;
    private JButton buscarUnProductoPorButton;
    private JButton salirButton;

    public PantallaPrincipal(UserModel userModel, ProductController productController){
        add(Ventana);
        setSize(300,300);
        setTitle("Programa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textField1.setText(userModel.getFirstName());
        textField2.setText(userModel.getLastName());
        crearUnProductoButton.addActionListener(new ActionListener() {
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
        listarTodosLosProductosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        VerProductos verProductos = new VerProductos(userModel,productController);
                        verProductos.setVisible(true);
                        verProductos.setLocationRelativeTo(null);
                    }
                });
            }
        });
        eliminarUnProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        EliminarProducto eliminarProducto = new EliminarProducto(userModel,productController);
                        eliminarProducto.setVisible(true);
                        eliminarProducto.setLocationRelativeTo(null);
                    }
                });
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.exit(0);
            }
        });
        actualizarUnProductoButton.addActionListener(new ActionListener() {
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
        buscarUnProductoPorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        BuscarProducto buscarProducto= new BuscarProducto(userModel,productController);
                        buscarProducto.setVisible(true);
                        buscarProducto.setLocationRelativeTo(null);
                    }
                });
            }
        });
    }
}
