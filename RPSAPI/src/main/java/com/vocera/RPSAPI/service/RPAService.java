package com.vocera.RPSAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vocera.RPSAPI.entity.RPAData;
import com.vocera.RPSAPI.repository.RPARepository;

@Service
public class RPAService {
	
	@Autowired
	private RPARepository rpaRepo;
	
	public RPAData saveToken(String token) {
		RPAData rpaData = new RPAData(token, 0, 0, true);
		return this.rpaRepo.save(rpaData);
	}
	
	public RPAData updateScore(RPAData updatedData) {
		return this.rpaRepo.save(updatedData);
	}
	
	public RPAData getGameWithToken(String token) {
		return this.rpaRepo.getById(token);
	}
	
	public boolean checkIfTokenExists(String token) {
		return this.rpaRepo.existsById(token);
	}
}
