package com.thuan.hibernate.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "KHACH_HANG")
public class KhachHang {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "loai_khach_hang_id", referencedColumnName = "id")
	private LoaiKH loaiKH;

	private String tenKH;

	private boolean goiTinh;
	private String diaChi;
	private String soDT;
	private String trangthai;
	private LocalDate ngayHetHanBH;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "khachHang")
	private List<LichSuaChua> lichSuaChuas;

	public KhachHang() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LoaiKH getLoaiKH() {
		return loaiKH;
	}

	public void setLoaiKH(LoaiKH loaiKH) {
		this.loaiKH = loaiKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public boolean isGoiTinh() {
		return goiTinh;
	}

	public void setGoiTinh(boolean goiTinh) {
		this.goiTinh = goiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public KhachHang(LoaiKH loaiKH, String tenKH, boolean goiTinh, String diaChi, String soDT, String trangthai,
			LocalDate ngayHetHanBH) {
		super();
		this.loaiKH = loaiKH;
		this.tenKH = tenKH;
		this.goiTinh = goiTinh;
		this.diaChi = diaChi;
		this.soDT = soDT;
		this.trangthai = trangthai;
		this.ngayHetHanBH = ngayHetHanBH;
	}

	public String getSoDT() {
		return soDT;
	}

	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}

	public String getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}

	public LocalDate getNgayHetHanBH() {
		return ngayHetHanBH;
	}

	public void setNgayHetHanBH(LocalDate ngayHetHanBH) {
		this.ngayHetHanBH = ngayHetHanBH;
	}

	public List<LichSuaChua> getLichSuaChuas() {
		return lichSuaChuas;
	}

	public void setLichSuaChuas(List<LichSuaChua> lichSuaChuas) {
		this.lichSuaChuas = lichSuaChuas;
	}

	@Override
	public String toString() {
		return "KhachHang [id=" + id + ", loaiKH=" + loaiKH + ", tenKH=" + tenKH + ", goiTinh=" + goiTinh + ", diaChi="
				+ diaChi + ", soDT=" + soDT + ", trangthai=" + trangthai + ", ngayHetHanBH=" + ngayHetHanBH + "]";
	}

}
