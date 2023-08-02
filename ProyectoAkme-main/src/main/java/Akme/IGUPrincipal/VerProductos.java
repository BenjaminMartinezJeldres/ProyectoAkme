package Akme.IGUPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import Akme.controller.ProductController;
import Akme.model.*;

import javax.swing.DefaultListModel;

import javax.swing.*;
import java.awt.*;

public class VerProductos extends JFrame{
    private JTextField textField1;
    private JList<KeyboardModel> list1;
    private JButton volverButton;
    private JPanel Ventana;
    private JTextField textField2;
    private JList<MouseModel> list2;
    private JList<MonitorModel> list3;
    private JList<NotebookModel> list4;
    private JList<DesktopPCModel> list5;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;

    public VerProductos(UserModel userModel, ProductController productController){
        add(Ventana);
        setSize(750,600);
        setTitle("Ver Productos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textField1.setText(userModel.getFirstName());
        textField2.setText(userModel.getLastName());
        int aux=0,key=0,mon=0,mou=0,not=0,des=0;
        DefaultListModel<KeyboardModel> listModel1 = new DefaultListModel<>();
        List<KeyboardModel> keyboards = productController.listAllKeyboardsG();
        for (KeyboardModel keyboard : keyboards) {
            listModel1.addElement(keyboard);
            key=key+1;
        }
        list1.setModel(listModel1);
        list1.setCellRenderer(new KeyboardCellRenderer());

        DefaultListModel<MouseModel> listModel2 = new DefaultListModel<>();
        List<MouseModel> mouses = productController.listAllMousesG();
        for (MouseModel mouse : mouses) {
            listModel2.addElement(mouse);
            mou=mou+1;
        }
        list2.setModel(listModel2);
        list2.setCellRenderer(new MouseCellRenderer());

        DefaultListModel<MonitorModel> listModel3 = new DefaultListModel<>();
        List<MonitorModel> monitors = productController.listAllMonitorsG();
        for (MonitorModel monitor : monitors) {
            listModel3.addElement(monitor);
            mon=mon+1;
        }
        list3.setModel(listModel3);
        list3.setCellRenderer(new MonitorCellRenderer());

        DefaultListModel<NotebookModel> listModel4 = new DefaultListModel<>();
        List<NotebookModel> notebooks = productController.listAllNoteBooksG();
        for (NotebookModel notebook : notebooks) {
            listModel4.addElement(notebook);
            not=not+1;
        }
        list4.setModel(listModel4);
        list4.setCellRenderer(new NoteBookCellRenderer());

        DefaultListModel<DesktopPCModel> listModel5 = new DefaultListModel<>();
        List<DesktopPCModel> desktopPCs = productController.listAllDesktopPCsG();
        for (DesktopPCModel desktopPC : desktopPCs) {
            listModel5.addElement(desktopPC);
            des=des+1;
        }
        list5.setModel(listModel5);
        list5.setCellRenderer(new DesktopPCCellRenderer());

        aux=key+mou+mon+not+des;
        textField3.setText(Integer.toString(aux));
        textField4.setText(Integer.toString(key));
        textField5.setText(Integer.toString(mou));
        textField6.setText(Integer.toString(mon));
        textField7.setText(Integer.toString(not));
        textField8.setText(Integer.toString(des));

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
class KeyboardCellRenderer extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value instanceof KeyboardModel) {
            KeyboardModel keyboard = (KeyboardModel) value;
            String text= "ID: "+Integer.toString(keyboard.getId()) +", Marca: " +keyboard.getBrand() +", Modelo: "+ keyboard.getModel() +", Idioma: "+ keyboard.getLanguage()+", Precio: "+Double.toString(keyboard.getPrice());
            setText(text);
        }

        return this;
    }
}
class MouseCellRenderer extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value instanceof MouseModel) {
            MouseModel mouse = (MouseModel) value;
            String text= "ID: "+Integer.toString(mouse.getId()) +", Marca: " +mouse.getBrand() +", Modelo: "+ mouse.getModel() +", Precio: "+Double.toString(mouse.getPrice());
            setText(text);
        }

        return this;
    }
}
class MonitorCellRenderer extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value instanceof MonitorModel) {
            MonitorModel monitor = (MonitorModel) value;
            String text= "ID: "+Integer.toString(monitor.getId()) +", Marca: " +monitor.getBrand() +", Modelo: "+ monitor.getModel() +", Tamaño: "+ Double.toString(monitor.getSize())+", Precio: "+Double.toString(monitor.getPrice());
            setText(text);
        }

        return this;
    }
}
class NoteBookCellRenderer extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value instanceof NotebookModel) {
            NotebookModel notebook = (NotebookModel) value;
            String text= "ID: "+Integer.toString(notebook.getId()) +", Marca: " +notebook.getBrand() +", Modelo: "+ notebook.getModel() +", RAM: "+ Integer.toString(notebook.getRam()) +", Procesador:"+ notebook.getProcessor()+", Tamaño Pantalla: "+ Double.toString(notebook.getScreenSize())+", Precio: "+Double.toString(notebook.getPrice());
            setText(text);
        }

        return this;
    }
}
class DesktopPCCellRenderer extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value instanceof DesktopPCModel) {
            DesktopPCModel desktopPC = (DesktopPCModel) value;
            String text= "ID: "+Integer.toString(desktopPC.getId()) +", Marca: " +desktopPC.getBrand() +", Modelo: "+ desktopPC.getModel() +", RAM: "+ Integer.toString(desktopPC.getRam()) +", Procesador:"+ desktopPC.getProcessor()+", Pantalla: "+ desktopPC.getMonitorData()+", Mouse:"+ desktopPC.getMouseData()+", Teclado:"+desktopPC.getKeyboardData()+", Precio: "+Double.toString(desktopPC.getPrice());
            setText(text);
        }

        return this;
    }
}
