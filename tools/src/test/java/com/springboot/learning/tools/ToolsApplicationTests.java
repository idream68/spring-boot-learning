package com.springboot.learning.tools;

import com.springboot.learning.tools.optional.OptionalDemo;
import com.springboot.learning.tools.reflection.ReflectionDemo;
import com.springboot.learning.tools.stopwatch.StopWatchDemo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ToolsApplicationTests {

	@Autowired
	ReflectionDemo reflectionDemo;

	@Autowired
	StopWatchDemo stopWatchDemo;

	@Autowired
	OptionalDemo optionalDemo;

	@Test
	void contextLoads() {
	}

	@Test
	void testReflection() throws InstantiationException, IllegalAccessException {
		reflectionDemo.reflection();
	}

	@Test
	void testStopWatch() throws InterruptedException {
		stopWatchDemo.stopWatchDemo();
	}

	@Test
	void testOptional() {
		optionalDemo.optional();
	}

}
