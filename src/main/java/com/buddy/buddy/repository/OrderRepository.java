package com.buddy.buddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.buddy.buddy.entity.Book;

@Repository
public interface OrderRepository extends JpaRepository<Book,Integer>  {

}