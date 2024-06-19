package com.kishore.masterapp;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChallengeController {
	
	private ChallengeService challengeService;
	
	public ChallengeController(ChallengeService challengeService) {
		this.challengeService = challengeService;
	}
	
	@GetMapping("/challenges")
	public ResponseEntity<List<Challenge>> getAllChallenges() {
		
		return new ResponseEntity<>(challengeService.getAllChallenges(), HttpStatus.OK);
	}

	@PostMapping("/challenges")
	public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge) {
		boolean isChallengeAdded = challengeService.addChallenge(challenge);
		if(isChallengeAdded)
			return new ResponseEntity<>("Challenge added successfully", HttpStatus.OK);
		else
			return new ResponseEntity<>("Challenge not added successfully", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/challenges/{month}")
	public ResponseEntity<Challenge> getChallenges(
			@PathVariable String month) {
		Challenge challenge = challengeService.getChallenges(month);
		if(challenge != null)
			return new ResponseEntity<>(challenge, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
	}
}
