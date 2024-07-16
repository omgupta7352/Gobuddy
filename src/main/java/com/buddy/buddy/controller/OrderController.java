package com.buddy.buddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.buddy.buddy.entity.Book;
import com.buddy.buddy.entity.MyBookList;
import com.buddy.buddy.service.OrderService;
import com.buddy.buddy.service.MyOrderListService;

import java.util.*;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@Autowired
	private MyOrderListService myBookService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/order_register")
	public String orderRegister() {
		return "orderRegister";
	}
	
	@GetMapping("/available_orders")
	public ModelAndView getAllOrder() {
		List<Book>list=service.getAllOrder();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book",list);
		return new ModelAndView("orderList","book",list);
	}
	
	@PostMapping("/save")
	public String addOrder(@ModelAttribute Book b) {
		service.save(b);
		return "redirect:/available_orders";
	}
	@GetMapping("/my_orders")
	public String getMyOrders(Model model)
	{
		List<MyBookList>list=myBookService.getAllMyOrders();
		model.addAttribute("book",list);
		return "myOrders";
	}
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b=service.getOrderById(id);
		MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getService(),b.getPrice());
		myBookService.saveMyOrders(mb);
		return "redirect:/my_orders";
	}
	
	@RequestMapping("/editOrder/{id}")
	public String editOrder(@PathVariable("id") int id,Model model) {
		Book b=service.getOrderById(id);
		model.addAttribute("book",b);
		return "orderEdit";
	}
	@RequestMapping("/deleteOrder/{id}")
	public String deleteOrder(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/available_orders";
	}
	
}