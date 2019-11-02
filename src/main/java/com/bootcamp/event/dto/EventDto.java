package com.bootcamp.event.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {
	private Long id;
	@NotBlank
	private String name;
	@NotBlank
	private String description;
	private String image;
	private String city;
	private String country;
	@NotBlank
	private String latitude;
	@NotBlank
	private String longitude;
	private String status;
	@NotNull
	private CategoryDto category;
	@NotNull
	private OrganizerDto organizer;
}
