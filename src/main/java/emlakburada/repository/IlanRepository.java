package emlakburada.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import emlakburada.model.Gayrimenkul;
import emlakburada.model.Ilan;

@Repository
@Scope(value = "prototype")
public class IlanRepository {
	
	private String url = "localhost";
	private String pass= "şifre";

	public List<Ilan> fetchAllIlan() {
		List<Ilan> ilanListesi = new ArrayList<>();
		ilanListesi.add(prepareIlan("Sahibinden Acil Satılık"));
		ilanListesi.add(prepareIlan("Dosta GİDERRR ACİLLL!!!"));
		ilanListesi.add(prepareIlan("Metroya Koşarak 5 dk"));
		ilanListesi.add(prepareIlan("Öğrenciye ve Bekar uygun"));
		return ilanListesi;
	}

	private static Ilan prepareIlan(String baslik) {
		Ilan ilan = new Ilan();
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

	private static Gayrimenkul makeGayrimenkul() {
		return new Gayrimenkul();
	}

}
