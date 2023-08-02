package Akme.controller;

import Akme.model.*;
import Akme.view.ProductView;

import java.util.List;
import java.util.ArrayList;

public class ProductController {
    private List<ProductModel> products;
    private List<KeyboardModel> keyboards;
    private List<MouseModel> mouses;
    private List<MonitorModel> monitors;
    private List<NotebookModel> notebooks;
    private List<DesktopPCModel> desktopPCs;
    private ProductView productView;

    public ProductController(ProductView productView) {
        this.products = new ArrayList<>();
        this.keyboards = new ArrayList<>();
        this.mouses = new ArrayList<>();
        this.monitors = new ArrayList<>();
        this.notebooks = new ArrayList<>();
        this.desktopPCs = new ArrayList<>();
        this.productView = productView;
    }

    public void createProduct() {
        int opcion=productView.SelecProduct();
        switch (opcion){
            case 1:
                crearKeyboard();
                break;
            case 2:
                crearMouse();
                break;
            case 3:
                crearMonitor();
                break;
            case 4:
                crearNotebook();
                break;
            case 5:
                crearDescktopPC();
                break;
        }
    }
    public void crearKeyboard(){
        KeyboardModel product = productView.crearKeyboar();
        if(ValidarID(product.getId())){
            createKeyboardG(product.getId(),product.getBrand(),product.getModel(),product.getLanguage(),product.getPrice());
            productView.showProductCreatedMessage();
        }else{
         productView.invalidID();
        }
    }
    public void crearMouse(){
        MouseModel product = productView.crearMouse();
        if(ValidarID(product.getId())){
            createMouseG(product.getId(),product.getBrand(),product.getModel(),product.getPrice());
            productView.showProductCreatedMessage();
        }else{
            productView.invalidID();
        }
    }
    public void crearMonitor(){
        MonitorModel product = productView.crearMonitor();
        if(ValidarID(product.getId())){
            createMonitorG(product.getId(),product.getBrand(),product.getModel(),product.getSize(),product.getPrice());
            productView.showProductCreatedMessage();
        }else{
            productView.invalidID();
        }
    }
    public void crearNotebook(){
        NotebookModel product = productView.crearNotebook();
        if(ValidarID(product.getId())){
            createNoteBookG(product.getId(),product.getBrand(),product.getModel(),product.getRam(),product.getProcessor(),product.getScreenSize(),product.getPrice());
            productView.showProductCreatedMessage();
        }else{
            productView.invalidID();
        }
    }
    public void crearDescktopPC(){
        DesktopPCModel product = productView.crearDesktopPC();
        if(ValidarID(product.getId())){
            createDesktopPCG(product.getId(),product.getBrand(),product.getModel(),product.getRam(),product.getProcessor(),product.getKeyboardData(),product.getMouseData(),product.getMonitorData(),product.getPrice());
            productView.showProductCreatedMessage();
        }else{
            productView.invalidID();
        }
    }

    public void createDefaultProduct(){
        KeyboardModel newProduct1 = new KeyboardModel(34,"pj","iso","ingles",100);
        keyboards.add(newProduct1);
        KeyboardModel newProduct2 = new KeyboardModel(12,"pj","iso","ingles",100);
        keyboards.add(newProduct2);
        KeyboardModel newProduct3 = new KeyboardModel(45,"pj","iso","ingles",100);
        keyboards.add(newProduct3);
        MouseModel newProduct4 = new MouseModel(78,"pj","iso",100);
        mouses.add(newProduct4);
        MouseModel newProduct5 = new MouseModel(23,"pj","iso",400);
        mouses.add(newProduct5);
        MouseModel newProduct6 = new MouseModel(67,"pj","iso",100);
        mouses.add(newProduct6);
        MonitorModel newProduct7 = new MonitorModel(21,"pj","iso",24,100);
        monitors.add(newProduct7);
        MonitorModel newProduct8 = new MonitorModel(43,"pj","iso",27,100);
        monitors.add(newProduct8);
        MonitorModel newProduct9 = new MonitorModel(59,"pj","iso",15,100);
        monitors.add(newProduct9);
        NotebookModel newProduct10 = new NotebookModel(68,"pj","iso",2,"lentium",23,821);
        notebooks.add(newProduct10);
        NotebookModel newProduct11 = new NotebookModel(83,"pj","iso",4,"intel",34,621);
        notebooks.add(newProduct11);
        NotebookModel newProduct12 = new NotebookModel(123,"pj","iso",8,"ryzer",14,342);
        notebooks.add(newProduct12);
        DesktopPCModel newProduct13 = new DesktopPCModel(732,"pj","iso",8,"intel","pj,iso,ingles","hd,tec","24,ph,F",721);
        desktopPCs.add(newProduct13);
        DesktopPCModel newProduct14 = new DesktopPCModel(234,"pj","iso",16,"intel","pj,iso,ingles","hd,tec","24,ph,F",1001);
        desktopPCs.add(newProduct14);
        DesktopPCModel newProduct15 = new DesktopPCModel(843,"pj","iso",32,"intel","pj,iso,ingles","hd,tec","24,ph,F",1200);
        desktopPCs.add(newProduct15);


    }

    public void updateProduct() {
        int productId = productView.getProductId();
        KeyboardModel product1 = findKeyboardById(productId);
        MouseModel product2 = findMouseById(productId);
        MonitorModel product3 = findMonitorById(productId);
        NotebookModel product4 = findNotebookById(productId);
        DesktopPCModel product5 = findDesktopPCById(productId);

        if (product1!= null) {
            KeyboardModel updatedProduct = productView.crearKeyboar();
            keyboards.remove(product1);
            keyboards.add(updatedProduct);
            productView.showProductUpdatedMessage();
        } else if(product2 != null){
            MouseModel updatedProduct = productView.crearMouse();
            mouses.remove(product2);
            mouses.add(updatedProduct);
            productView.showProductUpdatedMessage();
        }else if(product3 !=null){
            MonitorModel updatedProduct = productView.crearMonitor();
            monitors.remove(product3);
            monitors.add(updatedProduct);
            productView.showProductUpdatedMessage();
        } else if(product4 != null) {
            NotebookModel updatedProduct = productView.crearNotebook();
            notebooks.remove(product4);
            notebooks.add(updatedProduct);
            productView.showProductUpdatedMessage();
        }else if(product5 != null){
            DesktopPCModel updatedProduct = productView.crearDesktopPC();
            desktopPCs.remove(product5);
            desktopPCs.add(updatedProduct);
            productView.showProductUpdatedMessage();
        }else{
            productView.showProductNotFoundMessage();
        }

    }


    public void listAllProducts() {
        productView.displayProducts(keyboards,mouses,monitors,notebooks,desktopPCs);
    }

    public void listProductById() {
        int id = productView.getProductId();
        KeyboardModel p1 = findKeyboardById(id);
        MouseModel p2 = findMouseById(id);
        MonitorModel p3 = findMonitorById(id);
        NotebookModel p4 = findNotebookById(id);
        DesktopPCModel p5 = findDesktopPCById(id);

        if (p1 != null) {
            productView.displayKeyboard(p1);
        } else if(p2 != null){
            productView.displayMouse(p2);
        }else if(p3 !=null){
            productView.displayMonitor(p3);
        } else if(p4 != null) {
            productView.displayNotebook(p4);
        }else if(p5 != null){
            productView.displayDesktopPC(p5);
        }else{
            productView.showProductNotFoundMessage();
        }

    }

    public void deleteProduct() {
        int id = productView.getProductId();
        KeyboardModel ToDelete1 = findKeyboardById(id);
        MouseModel ToDelete2 = findMouseById(id);
        MonitorModel ToDelete3 = findMonitorById(id);
        NotebookModel ToDelete4 = findNotebookById(id);
        DesktopPCModel ToDelete5 = findDesktopPCById(id);


        if (ToDelete1 != null) {
            keyboards.remove(ToDelete1);
            productView.showProductDeletedMessage();
        } else if(ToDelete2 != null){
            mouses.remove(ToDelete2);
            productView.showProductDeletedMessage();
        }else if(ToDelete3 !=null){
            monitors.remove(ToDelete3);
            productView.showProductDeletedMessage();
        } else if(ToDelete4 != null) {
            notebooks.remove(ToDelete4);
            productView.showProductDeletedMessage();
        }else if(ToDelete5 != null){
            desktopPCs.remove(ToDelete5);
            productView.showProductDeletedMessage();
        }else{
            productView.showProductNotFoundMessage();
        }


    }

    private ProductModel findProductById(int productId) {
        for (ProductModel product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }
    public KeyboardModel findKeyboardById(int id) {
        for (KeyboardModel keyboard : keyboards) {
            if (keyboard.getId() == id) {
                return keyboard;
            }
        }
        return null;
    }
    public MouseModel findMouseById(int id) {
        for (MouseModel mouse : mouses) {
            if (mouse.getId() == id) {
                return mouse;
            }
        }
        return null;
    }
    public MonitorModel findMonitorById(int id) {
        for (MonitorModel monitor : monitors) {
            if (monitor.getId() == id) {
                return monitor;
            }
        }
        return null;
    }
    public NotebookModel findNotebookById(int id) {
        for (NotebookModel notebook : notebooks) {
            if (notebook.getId() == id) {
                return notebook;
            }
        }
        return null;
    }
    public DesktopPCModel findDesktopPCById(int id) {
        for (DesktopPCModel desktopPC : desktopPCs) {
            if (desktopPC.getId() == id) {
                return desktopPC;
            }
        }
        return null;
    }

    public KeyboardModel createKeyboardG(int id, String brand, String model,String language,double price){
        KeyboardModel newProduct = new KeyboardModel(id,brand,model,language,price);
        keyboards.add(newProduct);
        return newProduct;
    }
    public MonitorModel createMonitorG(int id, String brand, String model,double size,double price){
        MonitorModel newProduct = new MonitorModel(id,brand,model,size,price);
        monitors.add(newProduct);
        return newProduct;
    }
    public NotebookModel createNoteBookG(int id, String brand, String model,int ram, String processor,double screenSize, double price ){
        NotebookModel newProduct = new NotebookModel(id,brand,model,ram,processor,screenSize,price);
        notebooks.add(newProduct);
        return newProduct;
    }
    public MouseModel createMouseG(int id,String brand,String model, double price){
        MouseModel newProduct = new MouseModel(id,brand,model,price);
        mouses.add(newProduct);
        return newProduct;
    }
    public DesktopPCModel createDesktopPCG(int id,String brand, String model,int ram,String processor, String keyboardData, String mouseData, String monitorData,double price){
        DesktopPCModel newProduct = new DesktopPCModel(id,brand, model,ram,processor,keyboardData,mouseData,monitorData,price);
        desktopPCs.add(newProduct);
        return newProduct;
    }
    public List<KeyboardModel> listAllKeyboardsG(){
        return keyboards;
    }
    public List<MouseModel> listAllMousesG(){
        return mouses;
    }
    public List<MonitorModel> listAllMonitorsG(){
        return monitors;
    }
    public List<NotebookModel> listAllNoteBooksG(){
        return notebooks;
    }
    public List<DesktopPCModel> listAllDesktopPCsG(){
        return desktopPCs;
    }

    public boolean deleteProductG(int id) {
        KeyboardModel ToDelete1 = findKeyboardById(id);
        MouseModel ToDelete2 = findMouseById(id);
        MonitorModel ToDelete3 = findMonitorById(id);
        NotebookModel ToDelete4 = findNotebookById(id);
        DesktopPCModel ToDelete5 = findDesktopPCById(id);


        if (ToDelete1 != null) {
            keyboards.remove(ToDelete1);
            return true;
        } else if(ToDelete2 != null){
            mouses.remove(ToDelete2);
            return true;
        }else if(ToDelete3 !=null){
            monitors.remove(ToDelete3);
            return true;
        } else if(ToDelete4 != null) {
            notebooks.remove(ToDelete4);
            return true;
        }else if(ToDelete5 != null){
            desktopPCs.remove(ToDelete5);
            return true;
        }else{
            return false;
        }
    }

    public boolean updateKeyboard(int id, String brand, String model,String language,double price){
        KeyboardModel ToUpdate = findKeyboardById(id);

        if (ToUpdate != null) {
            KeyboardModel updatedProduct = createKeyboardG(id,brand, model,language,price);
            if (updatedProduct != null) {
                keyboards.remove(ToUpdate);
                return true;
            }
        } else {
            return false;
        }
        return false;
    }
    public boolean updateMonitor(int id, String brand, String model,double size,double price){
        MonitorModel ToUpdate = findMonitorById(id);

        if (ToUpdate != null) {
            MonitorModel updatedProduct = createMonitorG(id, brand, model,size,price);
            if (updatedProduct != null) {
                keyboards.remove(ToUpdate);
                return true;
            }
        } else {
            return false;
        }
        return false;
    }
    public boolean updateMouse(int id,String brand,String model, double price){
        MouseModel ToUpdate = findMouseById(id);

        if (ToUpdate != null) {
            MouseModel updatedProduct = createMouseG( id, brand, model, price);
            if (updatedProduct != null) {
                keyboards.remove(ToUpdate);
                return true;
            }
        } else {
            return false;
        }
        return false;
    }
    public boolean updateNotebook(int id, String brand, String model,int ram, String processor,double screenSize, double price){
        NotebookModel ToUpdate = findNotebookById(id);

        if (ToUpdate != null) {
            NotebookModel updatedProduct = createNoteBookG(id, brand, model,ram, processor,screenSize, price);
            if (updatedProduct != null) {
                keyboards.remove(ToUpdate);
                return true;
            }
        } else {
            return false;
        }
        return false;
    }
    public boolean updateDesktopPC(int id,String brand, String model,int ram,String processor, String keyboardData, String mouseData, String monitorData,double price){
        DesktopPCModel ToUpdate = findDesktopPCById(id);

        if (ToUpdate != null) {
            DesktopPCModel updatedProduct = createDesktopPCG(id,brand, model,ram,processor, keyboardData,mouseData, monitorData,price);
            if (updatedProduct != null) {
                keyboards.remove(ToUpdate);
                return true;
            }
        } else {
            return false;
        }
        return false;
    }
    public int listProductByIdG(int id) {
        KeyboardModel product1 = findKeyboardById(id);
        MouseModel product2 = findMouseById(id);
        MonitorModel product3 = findMonitorById(id);
        NotebookModel product4 = findNotebookById(id);
        DesktopPCModel product5 = findDesktopPCById(id);

        if (product1!= null) {
            return 1;
        } else if(product2 != null){
            return 2;
        }else if(product3 !=null){
            return 3;
        } else if(product4 != null) {
            return 4;
        }else if(product5 != null){
            return 5;
        }else{
            return 6;
        }
    }
    public boolean ValidarID(int id){
        KeyboardModel p1 = findKeyboardById(id);
        MouseModel p2 = findMouseById(id);
        MonitorModel p3 = findMonitorById(id);
        NotebookModel p4 = findNotebookById(id);
        DesktopPCModel p5 = findDesktopPCById(id);


        if (p1 != null) {
            return false;
        } else if(p2 != null){
            return false;
        }else if(p3 !=null){
            return false;
        } else if(p4 != null) {
            return false;
        }else if(p5 != null){
            return false;
        }else{
            return true;
        }

    }
    public boolean validarKeyboardG(int id, String brand, String model,String language,double price){
        if(ValidarID(id)) {
            createKeyboardG(id, brand, model, language, price);
            return true;
        }else{
            return false;
        }
    }
    public boolean validarMonitorG(int id, String brand, String model,double size,double price){

        if(ValidarID(id)) {
            createMonitorG(id,brand,model,size,price);
            return true;
        }else{
            return false;
        }
    }
    public boolean validarNoteBookG(int id, String brand, String model,int ram, String processor,double screenSize, double price ){
        if(ValidarID(id)) {
            createNoteBookG(id,brand,model,ram,processor,screenSize,price);
            return true;
        }else{
            return false;
        }
    }
    public boolean validarMouseG(int id,String brand,String model, double price){
        if(ValidarID(id)) {
            createMouseG(id,brand,model,price);
            return true;
        }else{
            return false;
        }
    }
    public boolean validarDesktopPCG(int id,String brand, String model,int ram,String processor, String keyboardData, String mouseData, String monitorData,double price){
        if(ValidarID(id)) {
            createDesktopPCG(id,brand, model,ram,processor,keyboardData,mouseData,monitorData,price);
            return true;
        }else{
            return false;
        }
    }

}
