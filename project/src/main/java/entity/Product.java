package entity;

public class Product {
    protected int id;
    protected String proName;
    protected double importPrice;
    protected double sellPrice;
    protected int quantity;
    protected String category;
    protected String description;
    protected String supplier;

    public Product(String proName, double importPrice, double sellPrice, int quantity, String category, String description, String supplier) {
        this.proName = proName;
        this.importPrice = importPrice;
        this.sellPrice = sellPrice;
        this.quantity = quantity;
        this.category = category;
        this.description = description;
        this.supplier = supplier;
    }

    public Product(String proName, double importPrice, double sellPrice, int quantity, String category, String supplier) {
        this.proName = proName;
        this.importPrice = importPrice;
        this.sellPrice = sellPrice;
        this.quantity = quantity;
        this.category = category;
        this.supplier = supplier;
    }

    public Product() {


    }

    public Product(int id, String proName, double importPrice, double sellPrice, int quantity, String category, String description, String supplier) {
        this.id = id;
        this.proName = proName;
        this.importPrice = importPrice;
        this.sellPrice = sellPrice;
        this.quantity = quantity;
        this.category = category;
        this.description = description;
        this.supplier = supplier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
