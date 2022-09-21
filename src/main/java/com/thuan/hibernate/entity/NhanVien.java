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
@Table(name = "NHAN_VIEN")
public class NhanVien {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String tenNV;
	private String diaChi;
	private String soDT;
	private int soNamKN;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nhanVien")
	private List<LichSuaChua> lichSuaChuas;

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NhanVien(String tenNV, String diaChi, String soDT, int soNamKN) {
		super();
		this.tenNV = tenNV;
		this.diaChi = diaChi;
		this.soDT = soDT;
		this.soNamKN = soNamKN;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDT() {
		return soDT;
	}

	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}

	public int getSoNamKN() {
		return soNamKN;
	}

	public void setSoNamKN(int soNamKN) {
		this.soNamKN = soNamKN;
	}

	public List<LichSuaChua> getLichSuaChuas() {
		return lichSuaChuas;
	}

	public void setLichSuaChuas(List<LichSuaChua> lichSuaChuas) {
		this.lichSuaChuas = lichSuaChuas;
	}
}
