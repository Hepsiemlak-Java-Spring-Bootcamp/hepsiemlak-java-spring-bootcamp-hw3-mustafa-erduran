package emlakburada.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Kullanici {

	String kullaniciTipi; // bireysel & kurumsal & yeniTip
	String isim;
	String email;
	String fotograf;
	String biyografi;
	String vkn;
	Set<Ilan> favoriIlanlar = new HashSet<>();
	List<Ilan> yayinladigiIlanlar = new ArrayList<>();
	List<Mesaj> mesajKutusu;

	public Kullanici(String kullaniciTipi, String isim, String email) {
		super();
		this.kullaniciTipi = kullaniciTipi;
		this.isim = isim;
		this.email = email;
	}

}
