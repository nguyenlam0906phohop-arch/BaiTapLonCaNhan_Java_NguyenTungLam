package model;

import java.util.ArrayList;
import java.util.List;

public abstract class TuDo {
    private String maTu;
    private String viTri;
    private double sucChuaToiDa;
    private boolean daKhoa;
    private List<VatPham> danhSachVatPham;

    public TuDo(String maTu, String viTri, double sucChuaToiDa){
        this.maTu = maTu;
        this.viTri = viTri;
        this.sucChuaToiDa = sucChuaToiDa;
        this.daKhoa = true;
        this.danhSachVatPham = new ArrayList<>();
    }

    public String getMaTu(){
        return maTu;
    }

    public void setMaTu(String maTu){
        this.maTu = maTu;
    }

    public String getViTri(){
        return viTri;
    }

    public void setViTri(String viTri){
        this.viTri = viTri;
    }

    public double getSucChuaToiDa(){
        return sucChuaToiDa;
    }

    public void setSucChuaToiDa(double sucChuaToiDa){
        this.sucChuaToiDa = sucChuaToiDa;
    }

    public boolean getDaKhoa(){
        return daKhoa;
    }

    public void setDaKhoa(boolean daKhoa){
        this.daKhoa = daKhoa;
    }

    public List<VatPham> getDanhSachVatPham(){
        return danhSachVatPham;
    }

    public void setDanhSachVatPham(List<VatPham> danhSachVatPham) {
        this.danhSachVatPham = danhSachVatPham;
    }

    public abstract boolean moKhoa();

    public boolean khoaTu(){
        this.daKhoa = true;
        System.out.println("-> Tủ [" + maTu + "] đã được khóa an toàn.");
        return true;
    }

    public double tinhTongKhoiLuong(){
        double tong = 0;
        for(VatPham vp : danhSachVatPham){
            tong += vp.getKhoiLuong();
        }
        return tong;
    }

    public boolean themVatPham(VatPham item){
        if(daKhoa){
            System.out.println("-> Thất bại: Tủ [" + maTu + "] đang khóa! Cần mở tủ trước");
            return false;
        }
        if(tinhTongKhoiLuong() + item.getKhoiLuong() > sucChuaToiDa){
            System.out.println("-> Thất bại: Quá tải trọng tối đa (" + sucChuaToiDa + "kq)!");
            return false;
        }
        danhSachVatPham.add(item);
        System.out.println("-> Đã thêm vào tủ: " + item.getTenVatPham());
        return true;
    }

    public VatPham layVatPham(String maVatPham){
        if(daKhoa){
            System.out.println("-> Thất bại: Tủ đang khóa!");
            return null;
        }
        for(int i = 0; i < danhSachVatPham.size(); i++){
            if(danhSachVatPham.get(i).getMaVatPham().equalsIgnoreCase(maVatPham)){
                return danhSachVatPham.remove(i);
            }
        }
        System.out.println("-> Không tìm thấy đồ có mã: " + maVatPham);
        return null;
    }

    public String kiemTraTrangThai(){
        return String.format("Tủ [%s] | Vị trí: %s | Trạng thái: %s | Đã chứa: %.2f/%.2f kg | Số lượng: %d món",
                maTu, viTri, daKhoa ? "ĐANG KHÓA" : "ĐANG MỞ",
                tinhTongKhoiLuong(), sucChuaToiDa, danhSachVatPham.size());
    }
}
