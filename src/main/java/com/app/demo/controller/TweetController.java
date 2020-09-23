package com.app.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.dao.Tweet;
import com.app.demo.repository.TweetRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class TweetController {

	@Autowired
	private TweetRepository tweetRepository;

	@GetMapping("/tweets")
	public Flux<Tweet> getAllTweets() {
		return tweetRepository.findAll();
	}

	@PostMapping("/tweets")
	public Mono<Tweet> createTweets(@Valid @RequestBody Tweet tweet) {
		return tweetRepository.save(tweet);
	}

	
	
	
}
