package com.fhr.musicstorerest.apicontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fhr.musicstorerest.component.ArtistNotFoundException;
import com.fhr.musicstorerest.component.Error;
import com.fhr.musicstorerest.models.Artist;
import com.fhr.musicstorerest.services.IArtistService;

@RestController
@RequestMapping("/Artists")
public class ArtistController {
	@Autowired
	private IArtistService artistService=null;
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<Artist> findAll(){
		return artistService.findArtists();
	}
	
	@RequestMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	public Artist findOne(@PathVariable("id")int id) {
		Artist artist=artistService.findArtistById(id);
		if(artist==null){
			throw new ArtistNotFoundException(id);
		}
		return artist;
	}
	
	@RequestMapping(value="/search",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	public List<Artist> search(@RequestParam(value="name",required=false)String name){
		if(name!=null&&!name.equals("")){
			return artistService.findArtistByName(name);
		}
		return new ArrayList<Artist>();
	}
	
	@RequestMapping(method = RequestMethod.POST,
					produces = MediaType.APPLICATION_JSON_VALUE,
					consumes="application/json")
	public ResponseEntity<Artist> create(@RequestBody Artist artist,UriComponentsBuilder uriBuilder) {
		Artist saveArtist=artistService.saveArtist(artist);
		HttpHeaders headers=new HttpHeaders();
		headers.setLocation(uriBuilder.path("/Artists/")
									  .path(String.valueOf(saveArtist.getArtistId()))
									  .build()
									  .toUri());
		return new ResponseEntity<Artist>(saveArtist,headers,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.PUT,
				    produces = MediaType.APPLICATION_JSON_VALUE,
					consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
	public Artist update(@PathVariable("id")int id, @RequestBody Artist artist) {
		if(artistService.findArtistById(id)==null){
			throw new ArtistNotFoundException(id);
		}
		return artistService.ediArtist(artist);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE,
					 produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id")int id) {
		if(artistService.findArtistById(id)==null){
			throw new ArtistNotFoundException(id);
		}
		artistService.deleteArtist(id);
	}
	
	@ExceptionHandler(ArtistNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error artistNotFount(ArtistNotFoundException e){
		int artistId=e.getArtistId();
		return new Error(4, "Artist["+artistId+"] not found");
	}
}
