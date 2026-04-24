package thigk2.nguyenthanhtai.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TheLoaiTin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tenTheLoai;

	@OneToMany(mappedBy = "theLoaiTin", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Tin> tins;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTenTheLoai() {
		return tenTheLoai;
	}

	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}

	public List<Tin> getTins() {
		return tins;
	}

	public void setTins(List<Tin> tins) {
		this.tins = tins;
	}
}
