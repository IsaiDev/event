package com.bootcamp.event.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.event.dto.EventDto;
import com.bootcamp.event.service.EventService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/event")
public class EventController {
	
	private final EventService eventService;
	
	@PostMapping
	public String saveEvent(@RequestBody @Valid EventDto eventDto) {
		return this.eventService.saveEvent(eventDto);
	}
	
	@GetMapping
	public List<EventDto> getAllEvent(){
		return this.eventService.getAllEvent();
	}
	
	@GetMapping("/{id}")
	public EventDto getById(@PathVariable("id") Long id) {
		return this.eventService.getById(id);
	}

}
