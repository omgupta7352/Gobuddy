package com.buddy.buddy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buddy.buddy.entity.Book;
import com.buddy.buddy.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository bRepo;
	
	public void save(Book b) {
		bRepo.save(b);
	}
	
	public List<Book> getAllOrder(){
		return bRepo.findAll();
	}
	
	public Book getOrderById(int id) {
		return bRepo.findById(id).get();
	}
	public void deleteById(int id) {
		bRepo.deleteById(id);
	}
}