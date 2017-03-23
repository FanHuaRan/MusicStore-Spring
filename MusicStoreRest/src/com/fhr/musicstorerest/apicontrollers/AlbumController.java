package com.fhr.musicstorerest.apicontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fhr.musicstorerest.models.Album;
import com.fhr.musicstorerest.services.IAlbumService;

@Controller
@RequestMapping("/Album")
public class AlbumController {
	@Autowired
	private IAlbumService  albumService=null;
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<Album> findAll(){
		return albumService.findAlbums();
	}
	@RequestMapping( value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Album findOne(@PathVariable("id") Integer id) {
		return albumService.findAlbumById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST,
					produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Album create(@RequestBody Album album) {
		return albumService.createAlbum(album);
	}

	@RequestMapping( value="/{id}",
				     method = RequestMethod.PUT,
				     produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Album update(@PathVariable("id") Integer id, @RequestBody Album album) {
		return albumService.editAlbum(album);
	}

	@RequestMapping( value="/{id}",
					 method = RequestMethod.DELETE,
					 produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("id") Integer id) {
		albumService.deleteAlbum(id);
	}
}
