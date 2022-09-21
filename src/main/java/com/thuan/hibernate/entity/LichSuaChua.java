package com.thuan.hibernate.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LICH_SU_SUA_CHUA")
public class LichSuaChua {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "khach_hang_id", referencedColumnName = "id")
	private KhachHang khachHang;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "nhan_vien_id", referencedColumnName = "id")
	private NhanVien nhanVien;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "bo_phan_id", referencedColumnName = "id")
	private BoPhan boPhan;

	private LocalDate ngaySuaChua;
	private Double tongTien;

	public LichSuaChua() {
		super();
	}

	public LichSuaChua(KhachHang khachHang, NhanVien nhanVien, BoPhan boPhan, LocalDate ngaySuaChua, Double tongTien) {
		super();
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.boPhan = boPhan;
		this.ngaySuaChua = ngaySuaChua;
		this.tongTien = tongTien;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public BoPhan getBoPhan() {
		return boPhan;
	}

	public void setBoPhan(BoPhan boPhan) {
		this.boPhan = boPhan;
	}

	public LocalDate getNgaySuaChua() {
		return ngaySuaChua;
	}

	public void setNgaySuaChua(LocalDate ngaySuaChua) {
		this.ngaySuaChua = ngaySuaChua;
	}

	public Double getTongTien() {
		return tongTien;
	}

	public void setTongTien(Double tongTien) {
		this.tongTien = tongTien;
	}

}
