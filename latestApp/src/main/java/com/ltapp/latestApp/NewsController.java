package com.ltapp.latestApp;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {
	@Autowired
	private NewsService service;
	
	@RequestMapping(value = "/news", produces = "application/json", method = RequestMethod.GET)
	public List<News> getNews() {
		return service.getAllNews();
	}
	
	@RequestMapping(value = "/news",consumes = "application/json", method = RequestMethod.POST)
	public void createNews(@RequestBody News news) {
		service.createNewNews(news);
	}
	
	@RequestMapping(value = "/news/{id}", method = RequestMethod.DELETE)
	public void deleteNews(@PathVariable ("id") Integer id)
	{
		service.deleteNews(id);
	}

}
