package com.kishore.masterapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ChallengeService {
	
	private List<Challenge> challenges = new ArrayList<>();
	private Long nextId = 1L;
	
	public ChallengeService() {
	}
	
	public List<Challenge> getAllChallenges() {
		return challenges;
	}
	
	public boolean addChallenge(Challenge challenge) {
		if(challenge != null) {
			challenge.setId(nextId++);
			challenges.add(challenge);
			return true; 
		}
		else
			return false;
	}

	public Challenge getChallenges(String month) {
		for(Challenge ch: challenges) {
			if(ch.getMonth().equalsIgnoreCase(month))
				return ch;
		}
		return null;
	}

}
