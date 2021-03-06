package pers.fhr.musicstore.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

@Controller
@RequestMapping("/StoreManager")
public class StoreManagerController {
	private static final Logger logger = Logger.getLogger(StoreManagerController.class);
	@Autowired
	private IArtistService artistService=null;
	@Autowired
	 private  IAlbumService albumService =null;
	@Autowired
     private  IGenreService genreService = null;
	@RequestMapping()
	public ModelAndView index(){
		List<Album> albums=albumService.findAlbums();
		return new ModelAndView("storemanager/index","albums",albums);
	}
	@RequestMapping("/Details")
	public ModelAndView Details(Integer id){
		if(id==null){
			throw new AlbumNotFoundException();
		}
		Album album = albumService.findAlbumById(id);
        if (album == null){
        	throw new AlbumNotFoundException();
         }
         return new ModelAndView("storemanager/details","album",album);
	}
	@RequestMapping("/Create")
	public String create(HttpServletRequest request,Model model){
		List<Artist> artists=artistService.findArtists();
		List<Genre> genres=genreService.findGenres();
		model.addAttribute("artists",artists);
		model.addAttribute("genres",genres);
		return "storemanager/create";
	}
	@RequestMapping(value="/Create",
					method=RequestMethod.POST)
	public String create(Album album){
		try{
			albumService.createAlbum(album);
	        return "redirect:/StoreManager";
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
        Album album = albumService.findAlbumById(id);
        if (album == null){
             throw new AlbumNotFoundException();
        }
		List<Artist> artists=artistService.findArtists();
		List<Genre> genres=genreService.findGenres();
		model.addAttribute("artists",artists);
		model.addAttribute("genres",genres);
		model.addAttribute("album",album);
		return "storemanager/edit";
	}
	@RequestMapping(value="/Edit",
			method=RequestMethod.POST)
	public String edit(Album album){
		try{
			albumService.editAlbum(album);
		    return "redirect:/StoreManager";
		}catch(Exception e){
			logger.error(e.getMessage());
			return "storemanager/edit";
		}
	}
	@RequestMapping("/Delete")
    public String Delete(Model model,Integer id){
        if (id == null){
            throw new AlbumNotFoundException();
        }
        Album album = albumService.findAlbumById(id);
        if (album == null){
             throw new AlbumNotFoundException();
        }
        model.addAttribute(album);
        return "storemanager/delete";
    }
	@RequestMapping(value="/Delete",
			method=RequestMethod.POST)
    public String DeleteConfirmed(Album album)
    {
        albumService.deleteAlbum(album.getAlbumId());
        //采用重定向
        return "redirect:/StoreManager";
    }
}
