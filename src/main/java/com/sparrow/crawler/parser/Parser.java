package com.sparrow.crawler.parser;

import java.util.List;

public interface Parser<T> {

	List<T> parse(String html);
	
}
