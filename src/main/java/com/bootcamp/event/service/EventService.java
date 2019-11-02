package com.bootcamp.event.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.event.domain.Category;
import com.bootcamp.event.domain.Event;
import com.bootcamp.event.domain.Organizer;
import com.bootcamp.event.dto.CategoryDto;
import com.bootcamp.event.dto.EventDto;
import com.bootcamp.event.dto.OrganizerDto;
import com.bootcamp.event.repository.CategoryRepository;
import com.bootcamp.event.repository.EventRepository;
import com.bootcamp.event.repository.OrganizerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventService {
	
	private final EventRepository eventRepository;
	private final CategoryRepository categoryRepository;
	private final OrganizerRepository organizerRepository;
	
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public String saveEvent(EventDto eventDto) {
		try {
			Category category = this.categoryRepository.findById(eventDto.getCategory().getId()).get();
			Organizer organizer = this.organizerRepository.findById(eventDto.getOrganizer().getId()).get();
			Event event = new Event();
			event.setName(eventDto.getName());
			event.setDescription(eventDto.getDescription());
			event.setImage(eventDto.getImage());
			event.setCity(eventDto.getCity());
			event.setCountry(eventDto.getCountry());
			event.setLatitude(eventDto.getLatitude());
			event.setLongitude(eventDto.getLongitude());
			event.setCategory(category);
			event.setOrganizer(organizer);
			event.setStatus("1");
			this.eventRepository.saveAndFlush(event);
			return "Guardado exitoso!!";
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e.getMessage(), e.getCause());
		}		
	}
	
	public List<EventDto> getAllEvent(){
		List<Event> eventList = this.eventRepository.findAll();
		return eventList.stream()
				.filter(e -> e.getStatus().equals("1"))
				.map(e -> EventDto.builder()
						.id(e.getId())
						.name(e.getName())
						.description(e.getDescription())
						.image(e.getImage())
						.city(e.getCity())
						.country(e.getCountry())
						.latitude(e.getLatitude())
						.longitude(e.getLongitude())
						.category(CategoryDto.builder()
								.id(e.getCategory().getId())
								.name(e.getCategory().getName())
								.build())
						.organizer(OrganizerDto.builder()
								.id(e.getOrganizer().getId())
								.name(e.getOrganizer().getName())
								.build())
						.build())
				.collect(Collectors.toList());
	}
	
	public EventDto getById (Long id) {
		try {
			Event e = this.eventRepository.findById(id).get();
			return EventDto.builder()
					.id(e.getId())
					.name(e.getName())
					.description(e.getDescription())
					.image(e.getImage())
					.city(e.getCity())
					.country(e.getCountry())
					.latitude(e.getLatitude())
					.longitude(e.getLongitude())
					.category(CategoryDto.builder()
							.id(e.getCategory().getId())
							.name(e.getCategory().getName())
							.build())
					.organizer(OrganizerDto.builder()
							.id(e.getOrganizer().getId())
							.name(e.getOrganizer().getName())
							.build())
					.build();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e.getMessage(), e.getCause());
		}
		
	}
}
