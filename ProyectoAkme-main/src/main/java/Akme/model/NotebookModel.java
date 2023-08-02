package Akme.model;

public class NotebookModel extends ProductModel {
    private int ram;
    private String processor;
    private double screenSize;

    public NotebookModel(int id, String brand, String model, int ram, String processor, double screenSize, double price){
        super(id, brand, model, price);
        setRam(ram);
        this.processor = processor;
        setScreenSize(screenSize);
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        if(ram>=0)
        this.ram = ram;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        if(screenSize>=0)
        this.screenSize = screenSize;
    }
}
