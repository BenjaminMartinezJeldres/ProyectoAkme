package Akme.model;

public class KeyboardModel extends ProductModel {
    private String language;

    public KeyboardModel(int id, String brand, String model, String language,double price) {
        super(id, brand, model,price);
        this.language = language;
    }



    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
