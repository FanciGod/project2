package entity;

public class Product {
    private int id;
    private String proName;
    private double importPrice;
    private double sellPrice;
    private int quantity;
    private int categoryID;
    private String description;
    private String groupProduct;

    public Product() {
    }

    public Product(int id, String proName, double importPrice, double sellPrice, int quantity, int categoryID, String description, String groupProduct) {
        this.id = id;
        this.proName = proName;
        this.importPrice = importPrice;
        this.sellPrice = sellPrice;
        this.quantity = quantity;
        this.categoryID = categoryID;
        this.description = description;
        this.groupProduct = groupProduct;
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

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGroupProduct() {
        return groupProduct;
    }

    public void setGroupProduct(String groupProduct) {
        this.groupProduct = groupProduct;
    }
}
