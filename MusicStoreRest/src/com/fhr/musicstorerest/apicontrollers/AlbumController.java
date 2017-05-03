package com.fhr.musicstorerest.apicontrollers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

import com.fhr.musicstorerest.component.AlbumNotFoundException;
import com.fhr.musicstorerest.component.Error;
import com.fhr.musicstorerest.models.Album;
import com.fhr.musicstorerest.services.IAlbumService;
/**
 * RestController注解继承自Controller,是Controller注解和ResponseBody注解的结合体
 * 返回对象不再需要ResponseBody
*  RequestMapping中的produces代表的是accept，consumes代表Content-type
*  ExceptionHandler帮我们实现错误处理
 * @author fhr
 * @date 2017/05/03
 */
@RestController
@RequestMapping("/Albums")
public class AlbumController {
	@Autowired
	private IAlbumService  albumService=null;
	/**
	 * 查询所有album
	 * @return
	 */
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<Album> findAll(){
		return albumService.findAlbums();
	}
	/**
	 * 查询单个album
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	public Album findOne(@PathVariable("id")int id) {
		Album album=albumService.findAlbumById(id);
		if(album==null){
			throw new AlbumNotFoundException(id);
		}
		return album;
	}
	/**
	 * 动态查询，查询参数是以url查询参数进行传递的
	 * 这儿有问题，查询参数都为空时，应该返回空集合
	 * @param genreId
	 * @param title
	 * @param minPrice
	 * @param maxPrice
	 * @return
	 */
	@RequestMapping( value="/search",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
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
	/**
	 * 创建album
	 * 这儿使用ResponseEntity将创建后的资源的地址和响应状态进行手动返回
	 * @param album
	 * @param uriBuilder 用于以相对路径的方式构造url,建造者模式
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST,
					produces = MediaType.APPLICATION_JSON_VALUE,
					consumes="application/json")
	public ResponseEntity<Album> create(@RequestBody Album album,UriComponentsBuilder uriBuilder) {
		Album saveAlbum=albumService.createAlbum(album);
		HttpHeaders headers=new HttpHeaders();
		headers.setLocation(uriBuilder.path("/Albums/")
									  .path(String.valueOf(saveAlbum.getAlbumId()))
									  .build()
									  .toUri());
		return new ResponseEntity<Album>(saveAlbum,headers,HttpStatus.CREATED);
	}
	/**
	 * 更新Album
	 * @param id
	 * @param album
	 * @return
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.PUT,
				    produces = MediaType.APPLICATION_JSON_VALUE,
					consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
	public Album update(@PathVariable("id")int id, @RequestBody Album album) {
		if(albumService.findAlbumById(id)==null){
			throw new AlbumNotFoundException(id);
		}
		return albumService.editAlbum(album);
	}
	/**
	 * 根据ID删除album
	 * @param id
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE,
					 produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id")int id) {
		if(albumService.findAlbumById(id)==null){
			throw new AlbumNotFoundException(id);
		}
		albumService.deleteAlbum(id);
	}
	/**
	 * 错误处理器 当本控制器方法中抛出AlbumNotFoundException异常时
	 * 则会直接运行此方法，并将其返回结果作为请求的返回结果
	 * @param e
	 * @return
	 */
	@ExceptionHandler(AlbumNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error albumNotFount(AlbumNotFoundException e){
		int albumId=e.getAlbumId();
		return new Error(4, "Album["+albumId+"] not found");
	}
	/***************************后面可加上诸如分页查询等方法***********************/
}
