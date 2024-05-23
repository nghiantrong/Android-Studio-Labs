package com.example.bongdalistview;

public class CauThu {
    private String Ten;
    private String Mota;
    private int Hinh;
    private int Co;

    public CauThu(String ten, String mota, int hinh, int co) {
        Ten = ten;
        Mota = mota;
        Hinh = hinh;
        Co = co;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }

    public int getCo() {
        return Co;
    }

    public void setCo(int co) {
        Co = co;
    }
}
