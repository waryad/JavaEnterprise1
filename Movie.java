package ca.sheridancollege.waryad.beans;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Movie {
	private Long id;
	private String name;
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
	private LocalDate reviewDate;
	@DateTimeFormat(iso=DateTimeFormat.ISO.TIME)
    private LocalTime reviewTime;
	private String review;	
	private String streamservices;

}



	
		
	


