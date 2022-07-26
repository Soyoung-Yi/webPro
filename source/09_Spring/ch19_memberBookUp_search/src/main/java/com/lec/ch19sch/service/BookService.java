package com.lec.ch19sch.service;
import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19sch.dto.Book;
public interface BookService {
	public List<Book> mainList();
	public List<Book> bookList(String pageNum, Book book);
	public int totCntBook(Book book);
	public Book getDetailBook(int bnum);
	public int registerBook(MultipartHttpServletRequest mRequest, Book book);
	public int registerBook(MultipartHttpServletRequest mRequest); // 비추
	public int modifyBook(MultipartHttpServletRequest mRequest, Book book);
	//public int modifyBook(MultipartHttpServletRequest mRequest);
}
