package com.wisely.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RESTController {
	private static final Logger log = LoggerFactory.getLogger(RESTController.class);

	@RequestMapping(value = "/getjson", produces = { "application/json;charset=UTF-8" })
	public DemoObj getjson(@RequestBody DemoObj obj) {
		log.info("dfjdjf{},{}", new String("aaa"),new String("aaabb"));
		return new DemoObj(obj.getId() + 1, obj.getName() + "yykk");
	}

	@RequestMapping(value = "/getxml", produces = { "application/xml;charset=UTF-8" })
	public DemoObj getxml(@RequestBody DemoObj obj) {
		log.info("dfjdjf{},{}", new String("uuuuuuuuuuuu"),new String("iiiiiiiiiiiiii"));
		return new DemoObj(obj.getId() + 1, obj.getName() + "yyll");
	}

}