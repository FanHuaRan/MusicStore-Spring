package com.fhr.musicstorerest.apicontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fhr.musicstorerest.component.Error;
import com.fhr.musicstorerest.component.GenreNotFoundException;
import com.fhr.musicstorerest.models.Genre;
import com.fhr.musicstorerest.services.IGenreService;

@RestController
@RequestMapping("/Genres")
public class GenreController {
	@Autowired
	private IGenreService  genreService=null;
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<Genre> findAll(){
		return genreService.findGenres();
	}
	
	@RequestMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	public Genre findOne(@PathVariable("id")int id) {
		Genre genre=genreService.findGenreById(id);
		if(genre==null){
			throw new GenreNotFoundException(id);
		}
		return genre;
	}
	
	@RequestMapping(value="/search",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	public List<Genre> search(@RequestParam(value="name",required=false)String name){
		if(name!=null&&!name.equals("")){
			return genreService.findGenreByName(name);
		}
		return genreService.findGenres();
	}
	
	@ExceptionHandler(GenreNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error artistNotFount(GenreNotFoundException e){
		int genreId=e.getGenreId();
		return new Error(4, "Genre["+genreId+"] not found");
	}
}
