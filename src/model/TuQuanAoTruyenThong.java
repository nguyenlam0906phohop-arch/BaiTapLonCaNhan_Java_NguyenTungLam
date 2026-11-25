package model;

public class TuQuanAoTruyenThong extends TuDo{
    private int soNganTreo;
    private int soNganKeo;
    private boolean coGuong;
    public TuQuanAoTruyenThong(String maTu, String viTri, double sucChuaToiDa,
                    int soNganTreo, int soNganKeo, boolean coGuong) {
        super(maTu, viTri, sucChuaToiDa);
        this.soNganTreo = soNganTreo;
        this.soNganKeo = soNganKeo;
        this.coGuong = coGuong;
    }
    public int getSoNganTreo() {
        return soNganTreo;
    }
    public void setSoNganTreo(int soNganTreo) {
        this.soNganTreo = soNganTreo;
    }
    public int getSoNganKeo() {
        return soNganKeo;
    }
    public void setSoNganKeo(int soNganKeo) {
        this.soNganKeo = soNganKeo;
    }

    public boolean getCoGuong(){
        return coGuong;
    }

    public void setCoGuong(boolean coGuong){
        this.coGuong = coGuong;
    }

    @Override
    public boolean moKhoa(){
        setDaKhoa(false);
        System.out.println("-> Mở cánh tủ quần ảo [" + getMaTu() + "] bằng tay nắm");
        return true;
    }

    public void treoQuanAo(VatPham item){
        if(themVatPham(item)){
            System.out.println(       "(Vị trí cất : Móc treo quần áo)");
        }
    }

    public boolean gapDoVaoNganKeo(VatPham item, int viTriNgan){
        if(viTriNgan > soNganKeo || viTriNgan <= 0){
            System.out.println("-> Lỗi: Tủ chỉ có "+ soNganKeo +" ngắn kéo!");
            return false;
        }
        if(themVatPham(item)){
            System.out.println("    (Vị trí cất: Ngắn kéo số " + viTriNgan +")");
            return true;
        }
        return false;
    }
}
