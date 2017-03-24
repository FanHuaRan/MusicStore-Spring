package com.fhr.musicstorerest.apicontrollers;

import java.util.ArrayList;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fhr.musicstorerest.component.AlbumNotFoundException;
import com.fhr.musicstorerest.component.GenreNotFoundException;
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
    @ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Album create(@RequestBody Album album) {
		return albumService.createAlbum(album);
	}

	@RequestMapping(value="/{id}",
				    method = RequestMethod.PUT,
				    produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Album update(@PathVariable("id") Integer id, @RequestBody Album album) {
		Album originAlbum=null;
		if(id==null||(originAlbum=albumService.findAlbumById(id))==null){
			throw new AlbumNotFoundException();
		}
		return albumService.editAlbum(album);
	}

	@RequestMapping( value="/{id}",
					 method = RequestMethod.DELETE,
					 produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
	@ResponseBody
	public void delete(@PathVariable("id") Integer id) {
		albumService.deleteAlbum(id);
	}
	
	@RequestMapping( value="/search",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Album> search(@RequestParam(value="genreId",required=false)Integer genreId,
							  @RequestParam(value="title",required=false)String title,
							  @RequestParam(value="minPrice",required=false,defaultValue="0")Double minPrice,
							  @RequestParam(value="maxPrice",required=false,defaultValue="100000")Double maxPrice) {
		String hqlString="from Album album ";
		List<String> whereHQLS=new ArrayList<String>();
		if(genreId!=null){
			whereHQLS.add(String.format("album.genreId = %d",genreId));
		}
		if(title!=null&&!title.equals("")){
			whereHQLS.add(String.format("album.title = '%s'",title));
		}
		whereHQLS.add(String.format(" album.price between %f and %f ",minPrice,maxPrice));
		hqlString+=whereHQLS.stream().collect(Collectors.joining(" and ", "where ", " "));
		return albumService.findAlbums(hqlString);
	}
}
