package br.com.pos.puc.getCar;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;


@SpringBootApplication
@EnableSpringDataWebSupport
@EnableCaching
public class GetCarApplication {

	private final static Logger logger = Logger.getLogger(GetCarApplication.class.getName());
	
	public static void main(String[] args) {
		SpringApplication.run(GetCarApplication.class, args);
		logger.info("\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n" +
					"<<<<<<<<<<<<<<<<<<<<<<<<<INICIALIZAÇÃO GETCAR APP BACKEND>>>>>>>>>>>>>>>>>>>>>>>>>\n" +
					"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
		

	}
	
}
