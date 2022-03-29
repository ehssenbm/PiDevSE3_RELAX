package com.jawher.dao;

import java.util.List;

import com.jawher.entity.Badge;

public interface IBadgeStoreDAO {
	
	List<Badge> getAdministrateurs();
	Badge getAdministrateur(int AdministrateurId);
	Badge createAdministrateur(Badge Administrateur);
	Badge updateAdministrateur(int AdministrateurId,Badge Administrateur);
	boolean deleteAdministrateur(int AdministrateurId);

}
