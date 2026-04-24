package thigk2.nguyenthanhtai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Tin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tieuDe;
	private String noiDung;

	@ManyToOne
	@JoinColumn(name = "the_loai_id")
	private TheLoaiTin theLoaiTin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public TheLoaiTin getTheLoaiTin() {
		return theLoaiTin;
	}

	public void setTheLoaiTin(TheLoaiTin theLoaiTin) {
		this.theLoaiTin = theLoaiTin;
	}
}
