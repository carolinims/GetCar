package br.com.pos.puc.getCar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import br.com.pos.puc.getCar.controller.UserController;
import br.com.pos.puc.getCar.domain.Cliente;
import br.com.pos.puc.getCar.repository.ClienteRepository;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableCaching
public class GetCarApplication {

	
	@Autowired
	private static ClienteRepository clienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(GetCarApplication.class, args);
		System.out.println("Hello World");
		
//		try {
//			clienteRepository.save(new Cliente("carolini.silva", 
//					"1234", null, null, null, null, null, null, null, null, null));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
