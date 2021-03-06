package com.test.acceptheader;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.domain.Greeting;
import com.test.util.Versions;

@RestController
@RequestMapping(produces = Versions.V1_0, consumes = Versions.V1_0)
public class V1GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World Accept Header V1") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
