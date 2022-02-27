package emlakburada;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import emlakburada.service.Singleton;

@SpringBootApplication
@ComponentScan(basePackages = {})
public class EmlakBuradaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmlakBuradaApplication.class, args);

		Singleton singleton = Singleton.getSingletonInstance();
		
		System.out.println(singleton.toString());
		
		
		Singleton singleton1 = Singleton.getSingletonInstance();
		
		System.out.println(singleton1.toString());
	}

//	@Bean
//	public IlanService ilanService() {
//		return new IlanService();
//	}
//
//	@Bean
//	public IlanRepository ilanRespository() {
//		return new IlanRepository();
//	}

}
