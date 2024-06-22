package DAO;

public class Book {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private String theLoai;
    private int soTrang;
    private String nhaSX;
    private int namXB;
    private int giaSach;
    private int soLuong;

    public Book(String maSach, String tenSach, String tacGia, String theLoai, int soTrang, String nhaSX, int namXB, int giaSach, int soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.theLoai = theLoai;
        this.soTrang = soTrang;
        this.nhaSX = nhaSX;
        this.namXB = namXB;
        this.giaSach = giaSach;
        this.soLuong = soLuong;
    }

    public String getMaSach() {
        return maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public String getNhaSX() {
        return nhaSX;
    }

    public int getNamXB() {
        return namXB;
    }

    public int getGiaSach() {
        return giaSach;
    }

    public int getSoLuong() {
        return soLuong;
    }
}
