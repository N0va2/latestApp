package com.ltapp.latestApp;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import com.ltapp.latestApp.News;

@Service
public class NewsService {
	@Autowired
	private News newsObject;
	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private Queue queue;
	
	private static List<News> list = new ArrayList<News>();
	
	
	public void createNews()
	{
		newsObject.setAuthor("Aakash");
		newsObject.setCategory("Sports");
		newsObject.setBody("Bulls select Patrick Williams as 4th pick");
		newsObject.setId(1);
		
	    // Send a message with a POJO - the template reuse the message converter
	    System.out.println("Publishing news");
	    jmsTemplate.convertAndSend(queue, newsObject);
	    //News n = (News) jmsTemplate.receiveAndConvert("sports");
	    //System.out.println(n.getAuthor());
	}
	
	public List<News> getAllNews()
	{
		
		return list;
	}
	
	public void createNewNews(News news)
	{
		System.out.println("Publishing news" +news.getAuthor());
		jmsTemplate.convertAndSend(queue, news);
	    //News n = (News) jmsTemplate.receiveAndConvert("sports");
	    //System.out.println(n.getAuthor());
	    list.add(news);
	}
	
	public void deleteNews(int id)
	{
		for(News news: list)
		{
			if(news.getId() == id) {
				list.remove(news);
				break;
			}
		}
	}

}
