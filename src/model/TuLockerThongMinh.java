package model;

import java.util.ArrayList;
import java.util.List;

public class TuLockerThongMinh  extends TuDo {
    private String maPin;
    private int soLanNhapSai;
    private int soMonToiDa;

    public TuLockerThongMinh(String maTu, String viTri, double sucChuaToiDa, String maPin, int soMonToiDa) {
        super(maTu, viTri, sucChuaToiDa);
        this.maPin = maPin;
        this.soMonToiDa = soMonToiDa;
        this.soLanNhapSai = 0;
    }

    public String getMaPin() {
        return maPin;
    }

    public void setMaPin(String maPin) {
        this.maPin = maPin;
    }

    public int getSoLanNhapSai() {
        return soLanNhapSai;
    }

    public void setSoLanNhapSai(int soLanNhapSai) {
        this.soLanNhapSai = soLanNhapSai;
    }

    public int getSoMonToiDa() {
        return soMonToiDa;
    }

    public void setSoMonToiDa(int soMonToiDa) {
        this.soMonToiDa = soMonToiDa;
    }

    @Override
    public boolean moKhoa() {
        System.out.println("-> Cảnh báo: Tủ locker thông minh bắt buộc phải mở bằng mã PIN");
        return false;
    }

    public boolean moKhoaBangPin(String pinNhap) {
        if (soLanNhapSai > 3) {
            System.out.println("-> BÁO ĐỘNG: Tủ [" + getMaTu() + "] đã bị khóa cứng do nhập sai PIN quá 3 lần");
            return false;
        }
        if (this.maPin.equals(pinNhap)) {
            setDaKhoa(false);
            this.soLanNhapSai = 0;
            System.out.println("-> Mã PIN chính xác! Chốt điện tử bặt ở tủ [" + getMaTu() + "]");
            return true;
        } else {
            this.soLanNhapSai++;
            System.out.println("-> Sai mã PIN lần" + soLanNhapSai + "/3");
            return false;
        }
    }

    public boolean doiMaPin(String pinCu, String pinMoi) {
        if (this.maPin.equals(pinCu)) {
            this.maPin = pinMoi;
            System.out.println(("-> Đổi mã PIN thành công!"));
            return true;
        }
        System.out.println("-> Lỗi: Mã PIN cũ không đúng!");
        return false;
    }

    public boolean guiDo(VatPham item){
        if(getDaKhoa()){
            System.out.println("-> Thất bại: Vui lòng mở khóa tủ bằng mã PIN trước khi gửi đồ");
            return false;
        }
        if(getDanhSachVatPham().size() >= soMonToiDa){
            System.out.println("-> Thất bại: Ngăn tủ đã chứa tối đa " + soMonToiDa + "món đồ!");
            return false;
        }
        return themVatPham(item);
    }

    public List<VatPham> layHetDoVaTraTu(String pinNhap){
        System.out.println("-> Đang xác thực mã PIN để trả tủ [" + getMaTu() + "]...");
        if (!this.maPin.equals(pinNhap)) {
            System.out.println("-> Thất bại: Sai mã PIN, không thể lấy đồ và trả tủ!");
            return new ArrayList<>();
        }
        setDaKhoa(false);
        List<VatPham> doTraVe = new ArrayList<>(getDanhSachVatPham());
        getDanhSachVatPham().clear();
        System.out.println("-> Xác thực thành công! Đã lấy toàn bộ " + doTraVe.size() + " món đồ ra khỏi tủ.");
        khoaTu();
        System.out.println("-> Hoàn tất trả tủ. Ngăn tủ sẵn sàng phục vụ lượt mới!");
        return doTraVe;
    }
}