package payroll;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
@Slf4j
public class LoadDatabase {
	
	Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	@Bean
	CommandLineRunner initDatabase(EmployeeRepository repository) {
		orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
		orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));

		orderRepository.findAll().forEach(order -> {
		  log.info("Preloaded " + order);
		});
		return args->{
			log.info("Preloading "+repository.save(new Employee("Bilbo","Baggins", "burglar")));
			log.info("Preloading "+repository.save(new Employee("Frodo","Baggins", "thief")));
		};
	}
	

}
