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

	public boolean updateChallenge(Long id, Challenge updatedChallenge) {

		for (Challenge ch: challenges) {
			if (ch.getId().equals(id)) {
				ch.setMonth(updatedChallenge.getMonth());
				ch.setDescription(updatedChallenge.getDescription());
				return true;
			}
		}
		return false;
	}

	public boolean deleteChallenge(Long id) {
		return challenges.removeIf(challenge -> challenge.getId().equals(id));
	}

}
