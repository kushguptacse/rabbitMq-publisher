package com.sample.publisher;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sample.publisher.config.ApplicationConfigReader;

@SpringBootApplication
public class PublisherApplication  {

	@Autowired
	private ApplicationConfigReader appConfig;

	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public Queue queue() {
		return new Queue(appConfig.getApp1Queue(), true);
	}

	@Bean
	public DirectExchange exchange() {
		return new DirectExchange(appConfig.getApp1Exchange());
	}

	@Bean
	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
	    final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
	    rabbitTemplate.setMessageConverter(jsonMessageConverter());
	    return rabbitTemplate;
	}
	
	@Bean
	public Binding binding(Queue queue, DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(appConfig.getApp1RoutingKey());
	}

	public static void main(String[] args) {
		SpringApplication.run(PublisherApplication.class, args);
	}

}
