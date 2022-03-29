package com.jawher.dao;

import java.util.List;

import com.jawher.entity.Choix;

public interface IChoixStoreDAO {
	
	List<Choix> getChoixs();
	Choix getChoix(int ChoixId);
	Choix createChoix(Choix Choix);
	Choix updateChoix(int ChoixId,Choix Choix);
	boolean deleteChoix(int ChoixId);

}
