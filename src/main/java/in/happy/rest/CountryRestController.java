package in.happy.rest;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.happy.binding.Country;



@RestController
public class CountryRestController {

	private HashOperations<String , Integer,Country> opsforHash =null;
	
	
	public CountryRestController(RedisTemplate<String, Country>rt){
		this.opsforHash = rt.opsForHash();
			
	}
	@PostMapping("/country")
	public String addCountry(@RequestBody Country country) {
	
		opsforHash.put("COUNTRIES", country.getSno(), country);
		return "Country Added";
	}
	 @GetMapping("/countries")
	    public Collection<Country> getCountries() {  // Corrected return type
	        Map<Integer, Country> entries = opsforHash.entries("COUNTRIES");
	        Collection<Country> values = entries.values();
	        return values;
	    }
	
		
	}
	
	
	
	

