package com.sparrow.crawler.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sparrow.base.controller.BaseController;
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
@RequestMapping(value="/book")
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
	
}