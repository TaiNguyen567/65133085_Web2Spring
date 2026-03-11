package tai65133085.thspringboot;

public class SinhVien {

	private String mssv;
	private String hoTen;
	private double diemTrungBinh;

	public SinhVien() {
	}

	public SinhVien(String mssv, String hoTen, double diemTrungBinh) {
		this.mssv = mssv;
		this.hoTen = hoTen;
		this.diemTrungBinh = diemTrungBinh;
	}

	public String getMssv() {
		return mssv;
	}

	public void setMssv(String mssv) {
		this.mssv = mssv;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public double getDiemTrungBinh() {
		return diemTrungBinh;
	}

	public void setDiemTrungBinh(double diemTrungBinh) {
		this.diemTrungBinh = diemTrungBinh;
	}
}
