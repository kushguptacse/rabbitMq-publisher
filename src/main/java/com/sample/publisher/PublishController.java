package com.sample.publisher;

import java.util.Optional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sample.publisher.config.ApplicationConfigReader;

@RestController
public class PublishController {

	@Autowired
	private ApplicationConfigReader applicationConfigReader;
	
	@GetMapping(value="/hello")
	public String test() {
		return "hello";
	}
	
	@Autowired
	private RabbitTemplate template;
	
	@GetMapping(value = { "", "/{content}" })
	public String testHello(@PathVariable("content") Optional<String> content) {
		if (content.isPresent()) {
			GenericModel genericModel = new GenericModel();
			genericModel.setContent(content.get());
			template.convertAndSend(applicationConfigReader.getApp1Exchange(),applicationConfigReader.getApp1RoutingKey(),genericModel);
			System.out.println("Data added in queue : "+genericModel.getContent());
			return "send "+ genericModel.getContent();
		}

		return "hello from payment service running ";
	}

//	@GetMapping(value = { "", "/{content}" })
//	public String testHello(@PathVariable("content") Optional<String> content) {
//		if (content.isPresent()) {
//			UserModel userModel = new UserModel();
//			userModel.setUserId(content.get());
//			userModel.addZone(new ZoneDto("1","zoneA"));
//			userModel.addZone(new ZoneDto("2","zoneB"));
//			template.convertAndSend(applicationConfigReader.getApp1Exchange(),applicationConfigReader.getApp1RoutingKey(),userModel);
//			return "send";
//		}
//
//		return "hello from payment service running ";
//	}
	
}
