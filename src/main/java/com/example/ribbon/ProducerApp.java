package com.example.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableDiscoveryClient
public class ProducerApp
{
	public static void main(String[] args)
	{
		SpringApplication.run(ProducerApp.class, args);
	}
}

@RestController
class MyRestController
{
	@Autowired
	Environment environment;

	@GetMapping("/")
	public String health() {return "I am Ok";}

	@GetMapping("/backend")
	public String backend()
	{
		System.out.println("Inside MyRestController::backend...");
		String serverPort = environment.getProperty("local.server.port");
		System.out.println("Port : " + serverPort);
		return "Hello form Backend!!! " + " Host : localhost " + " :: Port : " + serverPort;
	}
}