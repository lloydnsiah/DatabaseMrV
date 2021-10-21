package com.example.databasemrv.extras;

public class ReportObject {
    private String id;
    private String amount;
    private String date;

    public ReportObject(String id, String amount, String date) {
        this.id = id;
        this.amount = amount;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
