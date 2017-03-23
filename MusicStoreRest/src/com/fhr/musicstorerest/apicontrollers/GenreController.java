package com.fhr.musicstorerest.apicontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fhr.musicstorerest.models.Genre;
import com.fhr.musicstorerest.services.IGenreService;

@Controller
@RequestMapping("/Genre")
public class GenreController {
	@Autowired
	private IGenreService  genreService=null;
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<Genre> findAll(){
		return genreService.findGenres();
	}
	@RequestMapping( value="/{id}",
					 produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Genre findOne(@PathVariable("id") Integer id) {
		return genreService.findGenreById(id);
	}
}
