package emlakburada.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import emlakburada.model.Advert;
import emlakburada.model.RealEstate;

@Repository
public class IlanRepository {

	private String url = "localhost";
	private String pass = "şifre";

	private static List<Advert> ilanListesi = new ArrayList<>();

	static {
		ilanListesi.add(prepareIlan("Sahibinden Acil Satılık"));
		ilanListesi.add(prepareIlan("Dosta GİDERRR ACİLLL!!!"));
		ilanListesi.add(prepareIlan("Metroya Koşarak 5 dk"));
		ilanListesi.add(prepareIlan("Öğrenciye ve Bekar uygun"));
	}

	public List<Advert> fetchAllAdverts() {
		return ilanListesi;
	}

	private static Advert prepareIlan(String baslik) {
		Advert ilan = new Advert();
		ilan.setBaslik(baslik);
		ilan.setGayrimenkul(makeGayrimenkul());

		// kullanici.mesajKutusu.add(new Mesaj("acil dönüş")); // NPE

		// ilan.setKullanici(kullanici);

		ilan.setAktifMi(true);

		ilan.setResimList(makeResimList());

		return ilan;
	}

	private static String[] makeResimList() {
		String[] resimList = new String[5];
		resimList[0] = "https://hecdnw01.hemlak.com/ds01/4/4/9/0/2/3/8/3/81d2e088-a551-485d-b2e9-664cc9200cdc.jpg";
		resimList[1] = "https://hecdnw01.hemlak.com/ds01/4/4/9/0/2/3/8/3/81d2e088-a551-485d-b2e9-664cc9200cdc.jpg";
		return resimList;
	}

	private static RealEstate makeGayrimenkul() {
		return new RealEstate();
	}

	public Advert saveAdvert(Advert advert) {
		ilanListesi.add(advert);
		System.out.println(advert.toString());
		return advert;
	}

}
