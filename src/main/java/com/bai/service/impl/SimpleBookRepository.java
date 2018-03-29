package com.bai.service.impl;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.bai.entity.Book;
import com.bai.service.BookRepository;

@Component
public class SimpleBookRepository implements BookRepository {
	
    @Override
    @Cacheable("books")
    public Book getByIsbn(String isbn) {
    	
        simulateSlowService();
        return new Book(isbn, "Some book");
    }

    private void simulateSlowService() {
    	
        try {
        	
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            
        	throw new IllegalStateException(e);
        }
    }
}
