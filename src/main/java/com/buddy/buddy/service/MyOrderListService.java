package com.buddy.buddy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buddy.buddy.entity.MyBookList;
import com.buddy.buddy.repository.MyOrderRepository;

@Service
public class MyOrderListService {
	
	@Autowired
	private MyOrderRepository mybook;
	
	public void saveMyOrders(MyBookList book) {
		mybook.save(book);
	}
	
	public List<MyBookList> getAllMyOrders(){
		return mybook.findAll();
	}
	
	public void deleteById(int id) {
		mybook.deleteById(id);
	}
}