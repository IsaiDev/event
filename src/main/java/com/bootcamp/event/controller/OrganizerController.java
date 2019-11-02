package com.bootcamp.event.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.event.dto.OrganizerDto;
import com.bootcamp.event.service.OrganizerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/organizer")
public class OrganizerController {
	
	private final OrganizerService organizerService;
	
	@PostMapping
	public String saveOrganizer(@RequestBody @Valid OrganizerDto organizerDto) {
		return this.organizerService.saveOrganizer(organizerDto);
	}

}
