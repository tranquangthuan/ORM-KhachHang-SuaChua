package com.thuan.hibernate.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LOAI_KHACH_HANG")
public class LoaiKH {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String mota;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "loaiKH")
	private List<KhachHang> khachHangs;

	public LoaiKH() {
		super();
	}

	public LoaiKH(String mota) {
		super();
		this.mota = mota;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public List<KhachHang> getKhachHangs() {
		return khachHangs;
	}

	public void setKhachHangs(List<KhachHang> khachHangs) {
		this.khachHangs = khachHangs;
	}

	@Override
	public String toString() {
		return "LoaiKH [id=" + id + ", mota=" + mota + "]";
	}

}
