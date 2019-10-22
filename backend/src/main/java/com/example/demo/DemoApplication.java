package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;



import java.util.stream.Stream;

@SpringBootApplication

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	ApplicationRunner init(PartNameRepository partNameRepository,
						   ProductRepository productRepository,
						   ModelRepository modelRepository,
						   MoldRepository moldRepository,
						   StaffRepository staffRepository,
						   AddpointRepository addpointRepository) {return args -> {
//===========================================Mold===============================================
			Stream.of("VHP","EV14","KS","-").forEach(typename ->{
				Product Product = new Product();
				Product.setProName(typename);
				productRepository.save(Product);
			});
			Stream.of("38P","46P","56P","58P","94P","96P","154P").forEach(sex ->{
				Model model = new Model();
				model.setModel(sex);
				modelRepository.save(model);
			});
			Stream.of(	"6P-Nox connector","Contact housing upper","Contact housing bottom"
						,"Contact housing lower","Contact housing lower part","Contact housing Upper part"
						,"Cover	","Cover exit left","Cover exit left and corrugated tube"
						,"Cover exit right","Cover exit right and corrugated tube","Cover flat"
						,"Cover high","Lever","Locking Lever",	"Locking slide","Pressure plate"
						,"Retaining plate","Secondary locking","Trapez SL Mini").forEach(p -> {
				PartName partName = new PartName();
				partName.setNamePa(p);
				partNameRepository.save(partName);
			});

			Mold mold= new Mold();
			mold.setNameM("SZ6049380J03");
			mold.setProName(productRepository.getOne(3L));
			mold.setModel(modelRepository.getOne(2L));
			mold.setPartName(partNameRepository.getOne(2L));
			mold.setPartNo("123 123 123");
			moldRepository.save(mold);
			
			productRepository.findAll().forEach(System.out::println);
//===========================================Responsible===============================================
			Staff staff1 = new Staff("ADMIN");
			staff1.setUsername("ADMIN");
			staff1.setPassword("1234");
			staffRepository.save(staff1);
//===========================================Table===============================================
			Addpoint addpoint1 = new Addpoint("1");
			Addpoint addpoint2 = new Addpoint("2");
			Addpoint addpoint3 = new Addpoint("3");
			Addpoint addpoint4 = new Addpoint("4");
			Addpoint addpoint5 = new Addpoint("5");
			Addpoint addpoint6 = new Addpoint("6");
			Addpoint addpoint7 = new Addpoint("7");
			Addpoint addpoint8 = new Addpoint("8");
			Addpoint addpoint9 = new Addpoint("9");
			Addpoint addpoint10 = new Addpoint("10");
			Addpoint addpoint11 = new Addpoint("11");
			addpointRepository.save(addpoint1);
			addpointRepository.save(addpoint2);
			addpointRepository.save(addpoint3);
			addpointRepository.save(addpoint4);
			addpointRepository.save(addpoint5);
			addpointRepository.save(addpoint6);
			addpointRepository.save(addpoint7);
			addpointRepository.save(addpoint8);
			addpointRepository.save(addpoint9);
			addpointRepository.save(addpoint10);
			addpointRepository.save(addpoint11);
		};
	}
}
