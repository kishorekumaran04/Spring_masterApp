package com.kishore.masterapp;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ChallengeService {
	
	private Long nextId = 1L;
	
	ChallengeRepository challengeRepository;
	
	public ChallengeService(ChallengeRepository challengeRepository) {
		this.challengeRepository = challengeRepository;
	}
	
	public List<Challenge> getAllChallenges() {
		return challengeRepository.findAll();
	}
	
	public boolean addChallenge(Challenge challenge) {
		if(challenge != null) {
			challenge.setId(nextId++);
			challengeRepository.save(challenge);
			return true; 
		}
		else
			return false;
	}

	public Challenge getChallenges(String month) {
		Optional<Challenge> challenge = challengeRepository.findByMonthIgnoreCase(month);
		
		return challenge.orElse(null);
	}

	public boolean updateChallenge(Long id, Challenge updatedChallenge) {

		Optional<Challenge> challenge = challengeRepository.findById(id);
		if (challenge.isPresent()) {
			Challenge challengeToUpdate = challenge.get();
			challengeToUpdate.setMonth(updatedChallenge.getMonth());
			challengeToUpdate.setDescription(updatedChallenge.getDescription());
			challengeRepository.save(challengeToUpdate);
			return true;
		}
		return false;
	}

	public boolean deleteChallenge(Long id) {
		Optional<Challenge> challenge = challengeRepository.findById(id);
		if (challenge.isPresent()) {
			challengeRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
