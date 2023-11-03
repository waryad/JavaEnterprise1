package ca.sheridancollege.waryad.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.waryad.beans.Movie;

@Repository
public class DatabaseAccess {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	public void insertMovie(Movie movie) {
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query="INSERT INTO movie(name,reviewDate,reviewTime,review,streamservices) VALUES (:name,:reviewDate,:reviewTime,:review,:streamservices)";

		namedParameters.addValue("name", movie.getName());
		namedParameters.addValue("reviewDate", movie.getReviewDate());
		namedParameters.addValue("reviewTime", movie.getReviewTime());
		namedParameters.addValue("review", movie.getReview());
		namedParameters.addValue("streamservices", movie.getStreamservices());
		
		int rowsAffected = jdbc.update(query, namedParameters);
		if (rowsAffected > 0) System.out.println("inserted movie with name"+ movie);
	 }

	public List<Movie> getMovieList() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		String query ="SELECT * FROM movie ";
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Movie>(Movie.class));
	}
	
	}

