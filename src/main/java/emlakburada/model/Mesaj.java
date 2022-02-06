package emlakburada.model;

import java.util.Date;

public class Mesaj {

	String baslik;
	String icerigi;
	Date gonderilenTarih;
	Date okunduguTarihi;
	boolean gorulduMu;
	Kullanici gonderici;
	Kullanici alici;

	public Mesaj(String baslik) {
		super();
		this.baslik = baslik;
	}

}
