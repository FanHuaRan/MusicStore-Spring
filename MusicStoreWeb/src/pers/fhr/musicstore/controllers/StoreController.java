package pers.fhr.musicstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pers.fhr.musicstore.models.Album;
import pers.fhr.musicstore.models.Genre;
import pers.fhr.musicstore.services.IAlbumService;
import pers.fhr.musicstore.services.IGenreService;

@Controller
@RequestMapping("/Store")
public class StoreController {
		@Autowired
	   private  IGenreService genreService =null;
		@Autowired
       private  IAlbumService albumService =null;
	   @RequestMapping()
	   public ModelAndView index(){
		   List<Genre> genres=genreService.FindGenres();
		   return new ModelAndView("store/index","genres",genres);
	   }
	   @RequestMapping("/Browse")
	   public ModelAndView Browse(String genre){
		   Genre exampleGenre=genreService.FindGenreByName(genre);
		   return new ModelAndView("store/browse","genre",exampleGenre);
	   }
	   @RequestMapping("/Details")
	   public ModelAndView Details(Integer id){
		   if (id == null)
           {
              // return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
           }
           Album album = albumService.FindAlbumById(id);
           return new ModelAndView("store/details","album",album);
	   }
}
