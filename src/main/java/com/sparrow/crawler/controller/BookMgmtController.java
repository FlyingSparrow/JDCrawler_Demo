package com.sparrow.crawler.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sparrow.base.controller.BaseController;
import com.sparrow.crawler.entity.Book;
import com.sparrow.crawler.service.BookService;
import com.sparrow.framework.beans.AjaxResult;

/**
 * 
 * <p>Title: BookMgmtController</p>
 * <p>Description: 图书管理的控制器</p>
 * @author wjc
 * @date 2017年2月14日
 */
@RestController
@RequestMapping(value="/book")
public class BookMgmtController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(BookMgmtController.class);
	
	@Autowired
	private BookService bookService;
	
	/**
	 * 
	 * <p>Description: 添加图书/更新图书信息</p>
	 * @param book
	 * @return
	 * @author wjc
	 * @date 2017年2月14日
	 */
	@RequestMapping("/saveBook")
	@ResponseBody
	public AjaxResult saveBook(@RequestBody Book book){
		try {
			if(book != null){
				if(book.getId() == null){
					//如果是添加图书，那么图书id不能重复
					Book bookObj = bookService.findByBookId(book.getBookId());
					if(bookObj != null){
						return fail("该图书已经存在");
					}
				}
				bookService.save(book);
				return success("success");
			}else{
				return fail("图书信息不能为空");
			}
		} catch (Exception e) {
			logger.error("图书信息保存出错，图书信息: {}，异常信息：{}", book, e);
		}
		return fail("图书信息保存失败，请重试");
	}
	
	/**
	 * 
	 * <p>Description: 批量添加图书</p>
	 * @param list
	 * @return
	 * @author wjc
	 * @date 2017年2月15日
	 */
	@RequestMapping("/batchAddBook")
	@ResponseBody
	public AjaxResult batchAddBook(@RequestBody List<Book> list){
		try {
			if(list != null){
				bookService.batchAddBook(list);
				return success("success");
			}else{
				return fail("图书信息不能为空");
			}
		} catch (Exception e) {
			logger.error("批量添加图书出错，图书信息: {}，异常信息：{}", list, e);
		}
		return fail("批量添加图书失败，请重试");
	}
	
}
