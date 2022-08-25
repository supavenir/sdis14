package fr.sdis;

import java.util.List;

public class Periode {
	private List<Pompier> enMission;
	private List<Pompier> disponible;
	private List<Pompier> auTravail;

	public char getStatut(Pompier unPompier) {
		return ' ';
	}
}
