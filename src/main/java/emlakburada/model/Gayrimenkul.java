package emlakburada.model;

import emlakburada.model.enums.KonutType;
import lombok.Data;

@Data
public class Gayrimenkul {

	private Adres adres;
	private KonutType konutType;
	private String odaSayisi = "3+1";
	private int alan = 145;
	private int bulunduguKat = 3;

}