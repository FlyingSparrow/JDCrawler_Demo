package com.sparrow.crawler.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sparrow.base.controller.BaseController;
import com.sparrow.crawler.entity.mtime.Movie;
import com.sparrow.crawler.entity.mtime.MovieUrl;
import com.sparrow.crawler.service.MovieCommentService;
import com.sparrow.crawler.service.MovieService;
import com.sparrow.crawler.service.MovieUrlService;
import com.sparrow.framework.beans.AjaxResult;

/**
 * 
 * <p>Title: MtimeMovieController</p>
 * <p>Description: 时光网电影信息管理的控制器</p>
 * @author wjc
 * @date 2017年2月18日
 */
@RestController
@RequestMapping(value="/mtime")
public class MtimeMovieController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(MtimeMovieController.class);
	
	@Autowired
	private MovieCommentService movieCommentService;
	@Autowired
	private MovieService movieService;
	@Autowired
	private MovieUrlService movieUrlService;
	
	/**
	 * 
	 * <p>Description: 添加电影url/更新电影url信息</p>
	 * @param movieUrl
	 * @return
	 * @author wjc
	 * @date 2017年2月18日
	 */
	@RequestMapping("/saveMovieUrl")
	@ResponseBody
	public AjaxResult saveMovieUrl(@RequestBody MovieUrl movieUrl){
		try {
			if(movieUrl == null){
				return fail("电影url信息不能为空");
			}
			movieUrlService.save(movieUrl);
		} catch (Exception e) {
			logger.error("电影url信息保存出错，电影url信息: {}，异常信息：{}", movieUrl, e);
		}
		return fail("电影url信息保存失败，请重试");
	}
	
	@RequestMapping("/batchAddMovieUrl")
	@ResponseBody
	public AjaxResult batchAddMovieUrl(@RequestBody List<MovieUrl> list, 
			@RequestBody String movieId){
		try {
			if(list == null){
				return fail("电影url信息不能为空");
			}
			if(StringUtils.isEmpty(movieId)){
				return fail("电影id不能为空");
			}
			List<MovieUrl> newList = new ArrayList<MovieUrl>();
			for(MovieUrl item : list){
				if(!movieUrlService.isExist(item.getPrmovieId())){
					newList.add(item);
				}
			}
			movieUrlService.batchAddMovieUrl(newList, movieId);
			
			return success("success");
		} catch (Exception e) {
			logger.error("批量添加电影url信息出错，电影url信息: {}，异常信息：{}", list, e);
		}
		return fail("批量添加电影url信息失败，请重试");
	}
	
	@RequestMapping("/batchAddMovie")
	@ResponseBody
	public AjaxResult batchAddMovie(@RequestBody List<Movie> list){
		try {
			if(list == null){
				return fail("电影信息不能为空");
			}
			List<Movie> newList = new ArrayList<Movie>();
			for(Movie item : list){
				if(!movieService.isExist(item.getMovieId())){
					newList.add(item);
				}
			}
			movieService.batchAddMovie(newList);
		} catch (Exception e) {
			logger.error("批量添加电影信息出错，电影信息: {}，异常信息：{}", list, e);
		}
		return fail("批量添加电影信息失败，请重试");
	}

	@RequestMapping("/findAllMovie")
	@ResponseBody
	public AjaxResult findAllMovie(){
		try {
			List<Movie> list = movieService.findAll();
			
			logger.info("list: {}", list);
			
			return success(list);
		} catch (Exception e) {
			logger.error(": {}，异常信息：{}", e);
		}
		return fail("失败，请重试");
	}
	
	@RequestMapping("/findMovieUrlList")
	@ResponseBody
	public AjaxResult findMovieUrlList(Integer isCrawler){
		try {
			if(isCrawler == null){
				return fail("参数不能为空");
			}
			List<MovieUrl> list = movieUrlService.findListByIsCrawler(isCrawler);
			
			logger.info("list: {}", list);
			
			return success(list);
		} catch (Exception e) {
			logger.error(": {}，异常信息：{}", e);
		}
		return fail("失败，请重试");
	}
	
}
