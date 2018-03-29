package com.bai.service;

import com.bai.entity.Book;

public interface BookRepository {
    
	Book getByIsbn(String isbn);
}
