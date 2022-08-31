package fr.sdis;

public class PompierVolontaire extends Pompier {
	private String profession;

	public PompierVolontaire(String identite, String profession) {
		super(identite);
		this.profession = profession;
	}

	@Override
	public String toString() {
		return super.toString() + "PompierVolontaire [profession=" + profession + "]";
	}

}
