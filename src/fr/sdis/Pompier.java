package fr.sdis;

public class Pompier {

	private String prenom;
	private String nom;

	public Pompier(String identite) {
		setIdentite(identite);
	}

	public String getPrenom() {
		return prenom;
	}

	public String getNom() {
		return nom;
	}

	private String tel;

	public String getIdentite() {
		return prenom + " " + nom;
	}

	public void setIdentite(String identite) {
		String[] tableau;
		identite = identite.trim();
		if (identite.contains(" ")) {
			tableau = identite.split(" ", 2);
			nom = tableau[1];
			prenom = tableau[0];
		} else {
			nom = identite;
			prenom = "";
		}
	}

	public String getTel() {
		return this.tel.replaceFirst("(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{2})", "$1 $2 $3 $4 $5");
	}

	public void setTel(String numero) throws InvalidTelNumberException {
		String numclear = numero.replaceAll("\\D", "");
		if (numclear.length() != 10) {
			throw new InvalidTelNumberException("Invalid phone number");
		}
		tel = numclear;
	}

	public char getStatut(Periode unePeriode) {
		return unePeriode.getStatut(this);
	}

	public void missionner(Periode unePeriode) {
		unePeriode.missionner(this);
	}

	public String toString() {
		return this.getIdentite();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Pompier)) {
			return false;
		}
		return ((Pompier) obj).getIdentite().equals(getIdentite());
	}
}
