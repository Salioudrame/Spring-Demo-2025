package sn.esmt.demo2025;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sn.esmt.demo2025.domain.Voiture;

@SpringBootApplication
public class Demo2025Application implements CommandLineRunner {

    @Autowired(required = false)
	Voiture laVoiture;
	public static void main(String[] args) {
		SpringApplication.run(Demo2025Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (null == laVoiture) {
			System.out.println("Pas de voiture");
		}else {
			System.out.println(laVoiture.toString());
		}
	}
}
