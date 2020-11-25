package tietokantasovellus;

public class viini {
	private int id;
	private String tyyppi;
	private String nimi;
	private String valmistusMaa;
	private int arvoSana;

	

	public viini(int id, String tyyppi, String nimi, String valmistusMaa, int arvoSana) {
		super();
		this.id = id;
		this.tyyppi = tyyppi;
		this.nimi = nimi;
		this.valmistusMaa = valmistusMaa;
		this.arvoSana = arvoSana;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTyyppi() {
		return tyyppi;
	}
	
	public void setTyyppi(String tyyppi) {
		this.tyyppi = tyyppi;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getValmistusMaa() {
		return valmistusMaa;
	}

	public void setValmistusMaa(String valmistusMaa) {
		this.valmistusMaa = valmistusMaa;
	}

	public int getArvoSana() {
		return arvoSana;
	}

	public void setArvoSana(int arvoSana) {
		this.arvoSana = arvoSana;
	}

	@Override
	public String toString() {
		return "viini [tyyppi=" + tyyppi + ", nimi=" + nimi + ", valmistusMaa=" + valmistusMaa + ", arvoSana="
				+ arvoSana + "]";
	}

	
}
