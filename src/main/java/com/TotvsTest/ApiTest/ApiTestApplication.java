package com.TotvsTest.ApiTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ApiTestApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext=
				SpringApplication.run(ApiTestApplication.class, args);

//		ClientRepository clientRepository = configurableApplicationContext.getBean(ClientRepository.class);
//		AdressRepository adressRepository = configurableApplicationContext.getBean(AdressRepository.class);
//
//		LocalDate date = LocalDate.now();
//		Client user = new Client(
//				"elv safadão",
//				"thermo",
//				"0205180",
//				"programadorus",
//				"50",
//				date);
//
//		Address address1 = new Address(
//				user,
//				"residencial",
//				"avenida",
//		  		"rua da b",
//		  		"100",
//				"proximo ao abacatão",
//				"67140490",
//				"coqueiro",
//				"ananindeua",
//				"pa",
//				"brasil"
//		);
//
//		Address address2 = new Address(
//				user,
//				"comercial",
//				"avenida",
//				"rodovia dos travalhadores",
//				"92",
//				"proximo ao abacatão",
//				"6710400",
//				"coqueiro",
//				"ananindeua",
//				"pa",
//				"brasil"
//		);
//
//		List<Address> items = Arrays.asList(address1,address2);
//
//		user.setAddress(items);
//		clientRepository.save(user);

//		CartRepository cartRepository = configurableApplicationContext.getBean(CartRepository.class);
//
//		Category cart = new Category("cgg44");
//		Category cart2 = new Category("cgg4444");
//
//		Pessoa choc = new Pessoa(
//				"elv safadão",
//				"thermo",
//				"0205180",
//				"programadorus",
//				"500",
//				cart
//		);
//
//		Pessoa shop = new Pessoa(
//				"mesmero",
//				"magneto",
//				"020518044",
//				"programadorus",
//				"5004",
//				cart
//		);
//
//		List<Pessoa> items = Arrays.asList(choc,shop);
//
//
//		cart.setItem(items);
//		cart2.setItem(items);
//
//		cartRepository.save(cart2);
//		cartRepository.save(cart);
//
	}

}
