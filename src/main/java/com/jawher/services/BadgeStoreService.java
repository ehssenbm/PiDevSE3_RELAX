package com.jawher.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jawher.dao.IBadgeStoreDAO;
import com.jawher.entity.Badge;

@Service
public class BadgeStoreService implements IBadgeStoreService {
	
	@Autowired
	private IBadgeStoreDAO dao;

	@Override
	public List<Badge> getAdministrateurs() {
		return dao.getAdministrateurs();
	}

	@Override
	public Badge createAdministrateur(Badge Administrateur) {
		return dao.createAdministrateur(Administrateur);
	}

	@Override
	public Badge updateAdministrateur(int AdministrateurId, Badge Administrateur) {
		return dao.updateAdministrateur(AdministrateurId, Administrateur);
	}

	@Override
	public Badge getAdministrateur(int AdministrateurId) {
		return dao.getAdministrateur(AdministrateurId);
	}

	@Override
	public boolean deleteAdministrateur(int AdministrateurId) {
		return dao.deleteAdministrateur(AdministrateurId);
	}
	
 
	
	

}
