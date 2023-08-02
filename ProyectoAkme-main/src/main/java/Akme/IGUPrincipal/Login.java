package Akme.IGUPrincipal;

import Akme.controller.LoginController;
import Akme.controller.ProductController;
import Akme.model.UserModel;
import Akme.view.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    private JPanel Ventana;
    private JLabel title;
    private JLabel name;
    private JTextField textField1;
    private JLabel password;
    private JPasswordField textField2;
    private JButton button1;

    public Login(LoginController loginController, ProductController productController){

        add(Ventana);
        setSize(300,300);
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = textField1.getText();
                String texto2 = textField2.getText();
                    boolean authenticated = false;

                    authenticated = loginController.authenticateUserG(texto,texto2);
                    if (!authenticated) {
                        textField1.setText("");
                        textField2.setText("");
                        JOptionPane.showMessageDialog(Ventana,"Nombre de usuario o contraseña incorrectos. Inténtelo de nuevo.");
                    }else{
                        dispose();
                        UserModel userDefault = loginController.findUser(texto2);
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                PantallaPrincipal panta = new PantallaPrincipal(userDefault,productController);
                                panta.setVisible(true);
                                panta.setLocationRelativeTo(null);

                            }

                        });
                    }

            }
        });

    }
}
