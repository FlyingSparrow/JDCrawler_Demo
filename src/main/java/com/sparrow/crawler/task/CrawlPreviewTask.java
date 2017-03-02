package com.sparrow.crawler.task;

import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sparrow.crawler.entity.mtime.Movie;
import com.sparrow.crawler.service.MovieService;
import com.sparrow.crawler.service.MovieUrlService;

@Component
public class CrawlPreviewTask {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private MovieService movieService;
	@Autowired
	private MovieUrlService movieUrlService;
	
	/**
	 * 
	 * <p>Description: 每天晚上11点30分执行</p>
	 * @author wjc
	 * @date 2017年3月1日
	 */
	@Scheduled(cron = "0 48 9 * * ?")
	public void execute() {
		try {
			logger.info("抓取预告片信息开始");
			
			ThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5);
			List<Movie> list = movieService.findAll();
			if(list != null){
				for(Movie item : list){
					executor.execute(new MtimeThread(item.getUrl(), item.getMovieId(), 
							movieUrlService));
				}
			}
			executor.shutdown();
			
			logger.info("抓取预告片信息结束");
		} catch (Exception e) {
			logger.error("抓取预告片信息出错，异常信息：{} ", e);
		}
	}
	
}
