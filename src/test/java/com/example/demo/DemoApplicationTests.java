package com.example.demo;

import com.example.demo.entity.AbstractBox;
import com.example.demo.entity.BigBox;
import com.example.demo.entity.BigBoxRecord;
import com.example.demo.entity.Box;
import com.example.demo.entity.BoxMapper;
import com.example.demo.entity.SmallBox;
import com.example.demo.repo.BoxRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private BoxRepository boxRepository;

	@Autowired
	private BoxMapper boxMapper;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepo() {
		List<AbstractBox> abstractBoxes = List.of(new BigBox(123), new SmallBox(true));
		boxRepository.saveAll(abstractBoxes);

		List<AbstractBox> boxEntities = boxRepository.findAll();
		Assertions.assertEquals(boxEntities.size(), 2);

		List<Box> boxes = boxEntities.stream()
				.map(boxMapper::mapAbstractEntity)
				.toList();

		boxes.forEach(System.out::println);
	}
}
