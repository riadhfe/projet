package application;

import model.Administrateur;
import model.Caissier;

public interface UsersI {

	public Administrateur getAdmin(Administrateur e);
	public Caissier getCaissier(Caissier caissier);
	
}
