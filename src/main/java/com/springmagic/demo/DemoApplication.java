package com.springmagic.demo;

import com.springmagic.demo.springcache.IPrimeChecker;
import com.springmagic.demo.springcache.PrimeChecker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@Slf4j
@SpringBootApplication
@EnableCaching
public class DemoApplication implements CommandLineRunner {

	@Autowired
    private IPrimeChecker jdkProxyObj;
	@Autowired
	private PrimeChecker cglibProxyObj;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		log.info("********** JDK Dynamic Proxy **********");
		log.info("Object class : "+ jdkProxyObj.getClass());
		log.info("Is 1299541 a prime number ? "+ jdkProxyObj.isPrime(1299541));
		log.info("Is 1299541 a prime number ? "+ jdkProxyObj.isPrime(1299541));
		log.info("********** CGLIB Proxy **********");
		log.info("Object class : "+ cglibProxyObj.getClass());
		log.info("Is 1299541 a prime number ? "+ cglibProxyObj.isPrime(1299541));
		log.info("Is 1299541 a prime number ? "+ cglibProxyObj.isPrime(1299541));
	}
}
