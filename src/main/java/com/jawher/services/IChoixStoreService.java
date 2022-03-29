package com.jawher.services;

import java.util.List;

import com.jawher.entity.Choix;

public interface IChoixStoreService {
	
	List<Choix> getChoixs();
	Choix createChoix(Choix Choix);
	Choix updateChoix(int ChoixId, Choix Choix);
	Choix getChoix(int ChoixId);
	boolean deleteChoix(int ChoixId);

}
