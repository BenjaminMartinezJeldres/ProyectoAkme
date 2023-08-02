package Akme.model;

public class MonitorModel extends ProductModel {
    private double size;

    public MonitorModel(int id, String brand, String model, double size,double price) {
        super(id, brand, model, price);
        setSize(size);
    }


    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        if(size>=0)
        this.size = size;
    }
}
