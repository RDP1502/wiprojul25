package com.tcs.entity.relationdemo.entity;
import java.util.Set;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "movie")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name = "movie_name")
	String movieName;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
	        name = "movie_genre",
	        joinColumns = @JoinColumn(name = "movie_id"),
	        inverseJoinColumns = @JoinColumn(name = "genre_id")
	    )
	
	Set<Genre> genre;
	
	

}
