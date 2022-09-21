package com.thuan.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BO_PHAN")
public class BoPhan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String tenBP;

	private double giaTri;

	public BoPhan() {
		super();
	}

	public BoPhan(String tenBP, double giaTri) {
		super();
		this.tenBP = tenBP;
		this.giaTri = giaTri;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTenBP() {
		return tenBP;
	}

	public void setTenBP(String tenBP) {
		this.tenBP = tenBP;
	}

	public double getGiaTri() {
		return giaTri;
	}

	public void setGiaTri(double giaTri) {
		this.giaTri = giaTri;
	}

}
