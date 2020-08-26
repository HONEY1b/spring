package com.word.service;

import javax.annotation.Resource;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordSearchServiceAutowired {
	
//	@Autowired
//	@Qualifier("usedDao")
	@Resource
	private WordDao wordDao;
	
	public WordSearchServiceAutowired() {
		// TODO Auto-generated constructor stub
	}
	
//	@Autowired
	public WordSearchServiceAutowired(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
	public WordSet searchWord(String wordKey) {
		if(verify(wordKey)) {
			return wordDao.select(wordKey);
		} else {
			System.out.println("WordKey information is available.");
		}
		
		return null;
	}
	
	public boolean verify(String wordKey){
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet != null ? true : false;
	}
	
//	@Autowired
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
}
