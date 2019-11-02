package com.bootcamp.event.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Event")
@Setter
@Getter
@NoArgsConstructor
public class Event {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "image")
	private String image;
	@Column(name = "city")
	private String city;
	@Column(name = "country")
	private String country;
	@Column(name = "latitude")
	private String latitude;
	@Column(name = "longitude")
	private String longitude;
	@Column(name = "status")
	private String status;
	
	@JoinColumn(name = "id_category", referencedColumnName = "id")
	@ManyToOne
	private Category category;
	
	@JoinColumn(name = "id_organizer", referencedColumnName = "id")
	@ManyToOne
	private Organizer organizer;

}
