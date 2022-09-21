package com.thuan.hibernate.main;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.thuan.hibernate.entity.BoPhan;
import com.thuan.hibernate.entity.KhachHang;
import com.thuan.hibernate.entity.LichSuaChua;
import com.thuan.hibernate.entity.LoaiKH;
import com.thuan.hibernate.entity.NhanVien;
import com.thuan.hibernate.utils.HibernateUtils;

public class MainApp {

	public static void main(String[] args) {
		inserData();
		List<KhachHang> khachHangChoSuaChua = hienTHiKHChoSuaChua();
		phanCongSuaChua(khachHangChoSuaChua);
		hoanTat();
	}

	private static void inserData() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		LoaiKH loaiKH1 = new LoaiKH("VIP");
		LoaiKH loaiKH2 = new LoaiKH("Gold");
		LoaiKH loaiKH3 = new LoaiKH("Silver");
		LoaiKH loaiKH4 = new LoaiKH("Vãng lai");

		KhachHang khachHang1 = new KhachHang(loaiKH1, "KH1", false, "Da Nang", "0989999991", "Cho Sua Chua",
				LocalDate.of(2022, 1, 10));
		KhachHang khachHang2 = new KhachHang(loaiKH1, "KH2", false, "Da Nang", "0989999992", "Cho Sua Chua",
				LocalDate.of(2022, 10, 10));
		KhachHang khachHang3 = new KhachHang(loaiKH2, "KH3", false, "Da Nang", "0989999993", "Cho Sua Chua",
				LocalDate.of(2022, 10, 10));
		KhachHang khachHang4 = new KhachHang(loaiKH2, "KH4", false, "Da Nang", "0989999994", "Cho Sua Chua",
				LocalDate.of(2022, 10, 10));
		KhachHang khachHang5 = new KhachHang(loaiKH3, "KH5", false, "Da Nang", "0989999995", "Cho Sua Chua",
				LocalDate.of(2022, 10, 10));
		KhachHang khachHang6 = new KhachHang(loaiKH3, "KH6", false, "Da Nang", "0989999996", "Cho Sua Chua",
				LocalDate.of(2022, 10, 10));
		KhachHang khachHang7 = new KhachHang(loaiKH4, "KH7", false, "Da Nang", "0989999997", "Cho Sua Chua",
				LocalDate.of(2022, 1, 10));
		KhachHang khachHang8 = new KhachHang(loaiKH4, "KH8", false, "Da Nang", "0989999998", "Cho Sua Chua",
				LocalDate.of(2022, 1, 10));

		BoPhan boPhan1 = new BoPhan("Kinh chieu Hau", 1000);
		BoPhan boPhan2 = new BoPhan("Den truoc", 2000);
		BoPhan boPhan3 = new BoPhan("Gat Nuoc", 3000);

		NhanVien nhanVien1 = new NhanVien("NV1", "DN1", "099999999", 1);
		NhanVien nhanVien2 = new NhanVien("NV2", "DN2", "099999999", 2);
		NhanVien nhanVien3 = new NhanVien("NV3", "DN3", "099999999", 3);
		NhanVien nhanVien4 = new NhanVien("NV4", "DN4", "099999999", 4);
		NhanVien nhanVien5 = new NhanVien("NV5", "DN5", "099999999", 5);
		NhanVien nhanVien6 = new NhanVien("NV6", "DN6", "099999999", 6);

		session.save(loaiKH1);
		session.save(loaiKH2);
		session.save(loaiKH3);
		session.save(loaiKH4);

		session.save(khachHang1);
		session.save(khachHang2);
		session.save(khachHang3);
		session.save(khachHang4);
		session.save(khachHang5);
		session.save(khachHang6);
		session.save(khachHang7);
		session.save(khachHang8);

		session.save(boPhan1);
		session.save(boPhan2);
		session.save(boPhan3);

		session.save(nhanVien1);
		session.save(nhanVien2);
		session.save(nhanVien3);
		session.save(nhanVien4);
		session.save(nhanVien5);
		session.save(nhanVien6);

		t.commit();

		System.out.println("successfully saved");
		session.close();
	}

	private static List<KhachHang> hienTHiKHChoSuaChua() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM KhachHang AS KH where KH.trangthai =:trangthai";
		Query<KhachHang> query = session.createQuery(hql, KhachHang.class);
		query.setParameter("trangthai", "Cho Sua Chua");
		List<KhachHang> khachHangChoSuaChua = query.getResultList();
		if (khachHangChoSuaChua != null && khachHangChoSuaChua.size() > 0) {
			khachHangChoSuaChua.forEach(System.out::println);
		} else {
			System.out.println("khong co KH co lich sua chua");
		}

		session.close();
		return khachHangChoSuaChua;
	}

	private static void phanCongSuaChua(List<KhachHang> khachHangChoSuaChua) {
		if (khachHangChoSuaChua == null || khachHangChoSuaChua.size() == 0) {
			return;
		}
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM NhanVien";
		Query<NhanVien> query = session.createQuery(hql, NhanVien.class);
		List<NhanVien> nhanViens = query.getResultList();
		BoPhan boPhan = session.get(BoPhan.class, 1L);
		Transaction t = session.beginTransaction();
		for (KhachHang khachHang : khachHangChoSuaChua) {
			NhanVien nhanVienSuaChua = getNhanVien(khachHang.getLoaiKH().getMota(), nhanViens);
			LichSuaChua lichSuaChua = new LichSuaChua(khachHang, nhanVienSuaChua, boPhan, LocalDate.now(), 0d);
			session.save(lichSuaChua);
			khachHang.setTrangthai("dang sua chua");
			session.save(khachHang);
		}
		t.commit();
		session.close();
	}

	private static NhanVien getNhanVien(String loaiKH, List<NhanVien> nhanViens) {
		Random rand = new Random();
		if ("VIP".equalsIgnoreCase(loaiKH)) {
			List<NhanVien> list = nhanViens.stream().filter(nv -> nv.getSoNamKN() >= 5).collect(Collectors.toList());
			return list.get(rand.nextInt(list.size()));
		} else if ("Gold".equalsIgnoreCase(loaiKH)) {
			List<NhanVien> list = nhanViens.stream().filter(nv -> nv.getSoNamKN() >= 3).collect(Collectors.toList());
			return list.get(rand.nextInt(list.size()));
		} else if ("Silver".equalsIgnoreCase(loaiKH)) {
			List<NhanVien> list = nhanViens.stream().filter(nv -> nv.getSoNamKN() >= 2).collect(Collectors.toList());
			return list.get(rand.nextInt(list.size()));
		} else {
			List<NhanVien> list = nhanViens.stream().filter(nv -> nv.getSoNamKN() >= 1).collect(Collectors.toList());

			return list.get(rand.nextInt(list.size()));
		}
	}

	private static void hoanTat() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		String hql = "FROM KhachHang AS KH where KH.trangthai =:trangthai";
		Query<KhachHang> query = session.createQuery(hql, KhachHang.class);
		query.setParameter("trangthai", "Dang Sua Chua");
		List<KhachHang> khachHangChoSuaChua = query.getResultList();
		if (khachHangChoSuaChua != null && khachHangChoSuaChua.size() > 0) {
			for (KhachHang khachHang : khachHangChoSuaChua) {
				List<LichSuaChua> lichSuaChuas = khachHang.getLichSuaChuas();
				for (LichSuaChua lichSuaChua : lichSuaChuas) {
					Double tongTien = tinhTien(khachHang.getLoaiKH().getMota(), lichSuaChua.getBoPhan().getGiaTri(),
							khachHang.getNgayHetHanBH());
					lichSuaChua.setTongTien(tongTien);
					session.save(lichSuaChua);
				}
			}
		}
		t.commit();
		session.close();
	}

	private static Double tinhTien(String loaiKH, Double giaBoPhan, LocalDate ngayHetHanBH) {
		if (ngayHetHanBH.isAfter(LocalDate.now())) {
			return 500d;
		}
		Double phanTramGiamGia = 0d;
		if ("VIP".equalsIgnoreCase(loaiKH)) {
			phanTramGiamGia = 0.2;
		} else if ("Gold".equalsIgnoreCase(loaiKH)) {
			phanTramGiamGia = 0.1;
		} else if ("Silver".equalsIgnoreCase(loaiKH)) {
			phanTramGiamGia = 0.05;
		}
		return giaBoPhan - (giaBoPhan * phanTramGiamGia);
	}
}
