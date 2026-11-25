package model;

public class VatPham {
    private String maVatPham;
    private String tenVatPham;
    private double khoiLuong; //kg
    public VatPham(String maVatPham, String tenVatPham, double khoiLuong){
        this.maVatPham = maVatPham;
        this.tenVatPham = tenVatPham;
        this.khoiLuong = khoiLuong;
    }

    public String getMaVatPham(){
        return maVatPham;
    }

    public void setMaVatPham(String maVatPham){
        this.maVatPham = maVatPham;
    }

    public String getTenVatPham(){
        return tenVatPham;
    }

    public void setTenVatPham(String tenVatPham){
        this.tenVatPham = tenVatPham;
    }

    public double getKhoiLuong(){
        return khoiLuong;
    }

    public void setKhoiLuong(double khoiLuong){
        this.khoiLuong = khoiLuong;
    }

    public String hienThiThongTin(){
        return String.format("[Mã: %s | Tên: %s | Nặng %.2f kg]", maVatPham, tenVatPham, khoiLuong);
    }
}
