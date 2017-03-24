package com.fhr.musicstorerest.apicontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fhr.musicstorerest.models.Artist;
import com.fhr.musicstorerest.services.IArtistService;

@Controller
@RequestMapping("/Artist")
public class ArtistController {
	@Autowired
	private IArtistService  artistService=null;
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<Artist> findAll(){
		return artistService.findArtists();
	}
	@RequestMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Artist findOne(@PathVariable("id") Integer id) {
		return artistService.findArtistById(id);
	}
	@RequestMapping(value="/search",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Artist> search(@RequestParam(value="name",required=false)String name){
		if(name!=null||name.equals("")){
			return artistService.findArtistByName(name);
		}
		return artistService.findArtists();
	}
}
