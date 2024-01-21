package org.rygn.firstsoapws;

import java.util.HashMap;
import java.util.Map;

import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import io.spring.guides.gs_producing_web_service.countries.Country;
import io.spring.guides.gs_producing_web_service.countries.Currency;

@Component
public class CountryRepository {

	private static final Map<String, Country> countries = new HashMap<>();
	
	@PostConstruct
	public void initData() {
		Country spain = new Country();
		spain.setName("Spain");
		spain.setCapital("Madrid");
		spain.setCurrency(Currency.EUR);
		spain.setPopulation(46704314);
		spain.setLanguage("Spanish");
		spain.setFlagColors("Red, yellow");

		countries.put(spain.getName(), spain);

		Country poland = new Country();
		poland.setName("Poland");
		poland.setCapital("Warsaw");
		poland.setCurrency(Currency.PLN);
		poland.setPopulation(38186860);
		poland.setLanguage("Polish");
		poland.setFlagColors("Red, white");

		countries.put(poland.getName(), poland);

		Country uk = new Country();
		uk.setName("UK");
		uk.setCapital("London");
		uk.setCurrency(Currency.GBP);
		uk.setPopulation(63705000);
		uk.setLanguage("English");
		uk.setFlagColors("Red, blue, white");

		countries.put(uk.getName(), uk);
		
		Country usa = new Country();
		usa.setName("USA");
		usa.setCapital("Washington");
		usa.setCurrency(Currency.USD);
		usa.setPopulation(637050000);
		usa.setLanguage("English");
		usa.setFlagColors("Red, blue, white");

		countries.put(usa.getName(), usa);
		
		Country japan = new Country();
		japan.setName("Japan");
		japan.setCapital("Tokyo");
		japan.setCurrency(Currency.YEN);
		japan.setPopulation(125000000);
		japan.setLanguage("Japanese");
		japan.setFlagColors("Red, white");

		countries.put(japan.getName(), japan);
	}

	public Country findCountry(String name) {

		return countries.get(name);
	}
}
