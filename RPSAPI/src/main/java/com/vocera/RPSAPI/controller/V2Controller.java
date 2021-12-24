package com.vocera.RPSAPI.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vocera.RPSAPI.bean.ScoreResponseBean;
import com.vocera.RPSAPI.bean.StartBean;
import com.vocera.RPSAPI.entity.RPAData;
import com.vocera.RPSAPI.service.RPAService;

@RestController
@RequestMapping(value = "/v2")
public class V2Controller {
	@Autowired
	private RPAService rpaService;
	
	@GetMapping(value = "/start", produces = MediaType.APPLICATION_JSON_VALUE)
	public StartBean startGame() {
		String token = generateRandomToken(10);
		while(this.rpaService.checkIfTokenExists(token)) {
			token = generateRandomToken(10);
		}
		this.rpaService.saveToken(token);
		return new StartBean("READY", token);
	}
	
	@GetMapping(value = "/{token}/{usrMove}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ScoreResponseBean playGame(@PathVariable String token, @PathVariable String usrMove) throws AccountNotFoundException {
		ArrayList<String> output = new ArrayList<String>();
		output.add("scissors");
		output.add("rock");
		output.add("paper");
		
		HashMap<String, String> winOutcome = new HashMap<String, String>();
		winOutcome.put("rock", "paper");
		winOutcome.put("paper", "scissors");
		winOutcome.put("scissors", "rock");
		
		if(this.rpaService.checkIfTokenExists(token) && output.contains(usrMove) && this.rpaService.getGameWithToken(token).isStatus()) {
			RPAData existingData = this.rpaService.getGameWithToken(token);
			System.out.println(existingData);
			String systemMove = winOutcome.get(usrMove);
			if(usrMove.equalsIgnoreCase(systemMove)) {
				return new ScoreResponseBean(systemMove, existingData.getUserScore(), existingData.getSystemScore());
			}else if(!winOutcome.get(usrMove).equalsIgnoreCase(systemMove)) {
				if(existingData.getUserScore()<2) {
					existingData.setUserScore(existingData.getUserScore()+1);
				}else {
					existingData.setStatus(false);
					existingData.setUserScore(existingData.getUserScore()+1);
				}
				this.rpaService.updateScore(existingData);
				return new ScoreResponseBean(systemMove, existingData.getUserScore(), existingData.getSystemScore());
			}else {
				if(existingData.getSystemScore()<2) {
					existingData.setSystemScore(existingData.getSystemScore()+1);
				}else {
					existingData.setStatus(false);
					existingData.setSystemScore(existingData.getSystemScore()+1);
				}
				System.out.println(existingData);
				this.rpaService.updateScore(existingData);
				return new ScoreResponseBean(systemMove, existingData.getUserScore(), existingData.getSystemScore());
			}
		}else {
			throw new AccountNotFoundException("Token Not Found");
		}
	}
	
	
	private String generateRandomToken(int len) {
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}
	
	private int generateRandomMove() {
		return new Random().nextInt(3);
	}
}
