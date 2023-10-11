package com.example.demo.repo;

import com.example.demo.entity.AbstractBox;
import com.example.demo.entity.BigBoxRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoxRepository extends JpaRepository<AbstractBox, Integer> {

}
