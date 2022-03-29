package com.jawher.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jawher.dao.IChoixStoreDAO;
import com.jawher.entity.Choix;
 

@Service
public class ChoixStoreService implements IChoixStoreService {
	
	@Autowired
	private IChoixStoreDAO dao;

	@Override
	public List<Choix> getChoixs() {
		return dao.getChoixs();
	}


	@Override
	public Choix createChoix(Choix Choix) {
		return dao.createChoix(Choix);
	}

	@Override
	public Choix updateChoix(int ChoixId, Choix Choix) {
		return dao.updateChoix(ChoixId, Choix);
	}

	@Override
	public Choix getChoix(int ChoixId) {
		return dao.getChoix(ChoixId);
	}

	@Override
	public boolean deleteChoix(int ChoixId) {
		return dao.deleteChoix(ChoixId);
	}

}
