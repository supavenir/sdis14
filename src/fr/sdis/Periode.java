package fr.sdis;

import java.util.ArrayList;
import java.util.List;

public class Periode {

	private List<Pompier> enMission;
	private List<Pompier> disponible;
	private List<Pompier> auTravail;

	public Periode() {
		enMission = new ArrayList<>();
		disponible = new ArrayList<>();
		auTravail = new ArrayList<>();
	}

	private void selectEquipeDans(List<Pompier> dansListe, List<Pompier> selectionnes, int nbPompiers) {
		int i = dansListe.size() - 1;
		while (selectionnes.size() < nbPompiers && i >= 0) {
			selectionnes.add(dansListe.get(i));
			i--;
		}
	}

	public char getStatut(Pompier unPompier) {
		if (auTravail.contains(unPompier)) {
			return 't';
		}
		if (enMission.contains(unPompier)) {
			return 'm';
		}
		if (disponible.contains(unPompier)) {
			return 'd';
		}
		return 'x';
	}

	public void missionner(Pompier unPompier) {
		enMission.add(unPompier);
	}

	/**
	 * Retourne une collection d’au maximum “nbPompiers” pompiers pouvant être
	 * mobilisés pour une intervention lors de la période courante. Si un nombre
	 * suffisant de pompiers ne peut pas être sélectionné, une équipe incomplète
	 * sera constituée. Cette méthode mobilise en priorité les pompiers disponibles,
	 * puis ceux qui sont au travail si nécessaire. Le statut des pompiers n’est pas
	 * modifié par cette méthode.
	 * 
	 * @param nbPompiers
	 * @return
	 */
	public List<Pompier> selectEquipe(int nbPompiers) {
		List<Pompier> pompiers = new ArrayList<>();
		selectEquipeDans(disponible, pompiers, nbPompiers);
		selectEquipeDans(auTravail, pompiers, nbPompiers);
		return pompiers;
	}

	public void affecter(Pompier p, char c) {
		switch (c) {
		case 'm':
			enMission.add(p);
			break;
		case 'd':
			disponible.add(p);
			break;
		case 't':
			auTravail.add(p);
			break;
		}
	}
}
