package com.agora.springapi.request;

public class BookRequest {
    private int page;
    private int sci_fi;
    private int novel;
    private int romance;
    private int mystery;

    public int getNovel() {
        return novel;
    }

    public void setNovel(int novel) {
        this.novel = novel;
    }

    public int getRomance() {
        return romance;
    }

    public void setRomance(int romance) {
        this.romance = romance;
    }

    public int getMystery() {
        return mystery;
    }

    public void setMystery(int mystery) {
        this.mystery = mystery;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSci_fi() {
        return sci_fi;
    }

    public void setSci_fi(int sci_fi) {
        this.sci_fi = sci_fi;
    }
}
