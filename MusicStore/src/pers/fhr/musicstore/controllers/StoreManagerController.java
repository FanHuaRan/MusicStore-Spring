package pers.fhr.musicstore.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pers.fhr.musicstore.component.AlbumNotFoundException;
import pers.fhr.musicstore.models.Album;
import pers.fhr.musicstore.models.Artist;
import pers.fhr.musicstore.models.Genre;
import pers.fhr.musicstore.services.IAlbumService;
import pers.fhr.musicstore.services.IArtistService;
import pers.fhr.musicstore.services.IGenreService;
import pers.fhr.musicstore.services.impl.ArtistServiceClass;

@Controller
@RequestMapping("/StoreManager")
public class StoreManagerController {
	private static Logger logger = Logger.getLogger(StoreManagerController.class);
	@Autowired
	private IArtistService artistService=null;
	@Autowired
	 private  IAlbumService albumService =null;
	@Autowired
     private  IGenreService genreService = null;
	@RequestMapping()
	public ModelAndView index(){
		List<Album> albums=albumService.FindAlbums();
		return new ModelAndView("storemanager/index","albums",albums);
	}
	@RequestMapping("/Details")
	public ModelAndView Details(Integer id){
		if(id==null){
			return null;
		}
		Album album = albumService.FindAlbumById(id);
        if (album == null){
               return null;
         }
         return new ModelAndView("storemanager/details","album",album);
	}
	@RequestMapping("/Create")
	public String create(HttpServletRequest request,Model model){
		List<Artist> artists=artistService.findArtists();
		List<Genre> genres=genreService.FindGenres();
		model.addAttribute("artists",artists);
		model.addAttribute("genres",genres);
		return "storemanager/create";
	}
	@RequestMapping(value="/Create",
					method=RequestMethod.POST)
	public String create(Album album){
		try{
			albumService.CreateAlbum(album);
	        return "redirect:index";
		}catch(Exception e){
			logger.error(e.getMessage());
			return "storemanager/create";
		}
	}
	@RequestMapping("/Edit")
	public String edit(HttpServletRequest request,Model model,Integer id){
		if (id == null){
            throw new AlbumNotFoundException();
        }
        Album album = albumService.FindAlbumById(id);
        if (album == null){
             throw new AlbumNotFoundException();
        }
		List<Artist> artists=artistService.findArtists();
		List<Genre> genres=genreService.FindGenres();
		model.addAttribute(artists);
		model.addAttribute(genres);
		model.addAttribute(album);
		return "storemanager/edit";
	}
	@RequestMapping(value="/Edit",
			method=RequestMethod.POST)
	public String edit(Album album){
		try{
			albumService.EditAlbum(album);
		    return "redirect:/index";
		}catch(Exception e){
			logger.error(e.getMessage());
			return "storemanager/edit";
		}
	}
	@RequestMapping("/Delete")
    public String Delete(Integer id)
    {
        if (id == null){
            throw new AlbumNotFoundException();
        }
        Album album = albumService.FindAlbumById(id);
        if (album == null){
             throw new AlbumNotFoundException();
        }
        return "storemanager/delete";
    }
	@RequestMapping(value="/Delete",
			method=RequestMethod.POST)
    public String DeleteConfirmed(Integer id)
    {
        albumService.DeleteAlbum(id);
        //采用重定向
        return "redirect:/index";
    }
}
