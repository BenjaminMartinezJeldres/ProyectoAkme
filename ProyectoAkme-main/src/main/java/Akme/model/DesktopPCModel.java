package Akme.model;

public class DesktopPCModel extends ProductModel {
    private int ram;
    private String processor;
    private String keyboardData;
    private String mouseData;
    private String monitorData;

    public DesktopPCModel(int id, String brand, String model, int ram, String processor,
                          String keyboardData, String mouseData, String monitorData,double price) {
        super(id, brand, model, price);
        this.ram = ram;
        this.processor = processor;
        this.keyboardData = keyboardData;
        this.mouseData = mouseData;
        this.monitorData = monitorData;
    }



    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getKeyboardData() {
        return keyboardData;
    }

    public void setKeyboardData(String keyboardData) {
        this.keyboardData = keyboardData;
    }

    public String getMouseData() {
        return mouseData;
    }

    public void setMouseData(String mouseData) {
        this.mouseData = mouseData;
    }

    public String getMonitorData() {
        return monitorData;
    }

    public void setMonitorData(String monitorData) {
        this.monitorData = monitorData;
    }
}
