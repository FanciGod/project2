package entity;

import java.util.Date;

public class Purchase {
    private int purchaeId;
    private String purchaseName;
    private int supplierId;
    private int accountId;
    private Date createTime;

    public Purchase() {
    }

    public Purchase(int purchaeId, String purchaseName, int supplierId, int accountId, Date createTime) {
        this.purchaeId = purchaeId;
        this.purchaseName = purchaseName;
        this.supplierId = supplierId;
        this.accountId = accountId;
        this.createTime = createTime;
    }

    public int getPurchaeId() {
        return purchaeId;
    }

    public void setPurchaeId(int purchaeId) {
        this.purchaeId = purchaeId;
    }

    public String getPurchaseName() {
        return purchaseName;
    }

    public void setPurchaseName(String purchaseName) {
        this.purchaseName = purchaseName;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
