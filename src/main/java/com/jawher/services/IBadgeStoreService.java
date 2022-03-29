package com.jawher.services;

import java.util.List;

import com.jawher.entity.Badge;

public interface IBadgeStoreService {
	
	List<Badge> getAdministrateurs();
	Badge createAdministrateur(Badge Administrateur);
	Badge updateAdministrateur(int AdministrateurId, Badge Administrateur);
	Badge getAdministrateur(int AdministrateurId);
	boolean deleteAdministrateur(int AdministrateurId);
	 
}
