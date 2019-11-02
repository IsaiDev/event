package com.bootcamp.event.service;

import org.springframework.stereotype.Service;

import com.bootcamp.event.domain.Organizer;
import com.bootcamp.event.dto.OrganizerDto;
import com.bootcamp.event.repository.OrganizerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrganizerService {
	
	private final OrganizerRepository organizerRepository;
	
	public String saveOrganizer(OrganizerDto organizerDto) {
		try {
			Organizer organizer = new Organizer();
			organizer.setName(organizerDto.getName());
			organizer.setStatus("1");
			this.organizerRepository.saveAndFlush(organizer);
			return "Guardado exitoso!!";			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e.getMessage(), e.getCause());
		}
		
	}

}
