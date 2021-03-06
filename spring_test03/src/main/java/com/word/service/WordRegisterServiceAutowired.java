package com.word.service;

import javax.annotation.Resource;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordRegisterServiceAutowired {

//	@Autowired
//	@Qualifier("usedDao")
	@Resource
	private WordDao wordDao;
	
	public WordRegisterServiceAutowired() {
		// TODO Auto-generated constructor stub
	}
	
//	@Autowired
	public WordRegisterServiceAutowired(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
	public void register(WordSet wordSet) {
		String wordKey = wordSet.getWordKey();
		if(verify(wordKey)) {
			wordDao.insert(wordSet);
		} else {
			System.out.println("The word has already registered.");
		}
	}
	
	public boolean verify(String wordKey){
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet == null ? true : false;
	}
	
//	@Autowired
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
}
