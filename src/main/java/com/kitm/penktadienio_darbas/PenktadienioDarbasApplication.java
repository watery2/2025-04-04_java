package com.kitm.penktadienio_darbas;

import com.kitm.penktadienio_darbas.cli.CLI;
import com.kitm.penktadienio_darbas.entity.NTObject;
import com.kitm.penktadienio_darbas.utility.Reader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class PenktadienioDarbasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PenktadienioDarbasApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(CLI cli)
	{
		return runner-> {
			//"src/main/resources/nt.csv"
//			List<NTObject> ntObjectList = Reader.read("src/main/resources/nt.csv");
//
//			for (NTObject i : ntObjectList)
//			{
//				System.out.println(i);
//			}

			cli.menu();
		};
	}
}
