package entity;

import javafx.scene.control.TextField;

public class ImportProduct extends Product{
    protected TextField quantityImport;

    protected long totalPriceImport;

    public ImportProduct() {
    }

    public ImportProduct(String proName, double importPrice, double sellPrice, int quantity, String category, String description, String supplier, TextField quantityImport) {
        super(proName, importPrice, sellPrice, quantity, category, description, supplier);
        this.quantityImport = quantityImport;
        this.totalPriceImport = (long) (Double.valueOf(this.quantityImport.getText()) * super.getImportPrice());
    }

    public ImportProduct(String proName, double importPrice, double sellPrice, int quantity, String category, String supplier, TextField quantityImport) {
        super(proName, importPrice, sellPrice, quantity, category, supplier);
        this.quantityImport = quantityImport;
        this.totalPriceImport = (long) (Double.valueOf(this.quantityImport.getText()) * super.getImportPrice());
    }

    public ImportProduct(int id, String proName, double importPrice, double sellPrice, int quantity, String category, String description, String supplier, TextField quantityImport) {
        super(id, proName, importPrice, sellPrice, quantity, category, description, supplier);
        this.quantityImport = quantityImport;
        this.totalPriceImport = (long) (Double.valueOf(this.quantityImport.getText()) * super.getImportPrice());
    }

    public TextField getQuantityImport() {
        return quantityImport;
    }

    public void setQuantityImport(TextField quantityImport) {
        this.quantityImport = quantityImport;
    }

    public long getTotalPriceImport() {
        return totalPriceImport;
    }

    public void setTotalPriceImport() {
        this.totalPriceImport = (long) (Double.valueOf(this.quantityImport.getText()) * super.getImportPrice()) ;
    }
}
