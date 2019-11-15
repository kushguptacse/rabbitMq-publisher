package com.sample.publisher.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfigReader {

	@Value("${app1.exchange.name}")
	private String app1Exchange;
	@Value("${app1.queue.name}")
	private String app1Queue;
	@Value("${app1.routing.key}")
	private String app1RoutingKey;

	/**
	 * @return the app1Exchange
	 */
	public String getApp1Exchange() {
		return app1Exchange;
	}

	/**
	 * @param app1Exchange the app1Exchange to set
	 */
	public void setApp1Exchange(String app1Exchange) {
		this.app1Exchange = app1Exchange;
	}

	/**
	 * @return the app1Queue
	 */
	public String getApp1Queue() {
		return app1Queue;
	}

	/**
	 * @param app1Queue the app1Queue to set
	 */
	public void setApp1Queue(String app1Queue) {
		this.app1Queue = app1Queue;
	}

	/**
	 * @return the app1RoutingKey
	 */
	public String getApp1RoutingKey() {
		return app1RoutingKey;
	}

	/**
	 * @param app1RoutingKey the app1RoutingKey to set
	 */
	public void setApp1RoutingKey(String app1RoutingKey) {
		this.app1RoutingKey = app1RoutingKey;
	}
}