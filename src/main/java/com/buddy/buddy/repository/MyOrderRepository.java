package com.buddy.buddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.buddy.buddy.entity.MyBookList;

@Repository
public interface MyOrderRepository extends JpaRepository<MyBookList,Integer>{

}