package org.personal.bean;

public class Bill {

    private int id;
    private String username;
    private String month;
    private String totalAmount;
    private String status;

    protected Bill() {
    }

    public Bill(int id, String username, String month, String totalAmount, String isDone) {
        this.id = id;
        this.username = username;
        this.month = month;
        this.totalAmount = totalAmount;
        this.status = isDone;
    }

    public Bill(String username, String month, String totalAmount, String isDone) {
        this.username = username;
        this.month = month;
        this.totalAmount = totalAmount;
        this.status = isDone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
