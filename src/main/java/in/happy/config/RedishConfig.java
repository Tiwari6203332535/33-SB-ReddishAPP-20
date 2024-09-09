package in.happy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import in.happy.binding.Country;

@Configuration
public class RedishConfig {
	@Bean
	public JedisConnectionFactory jedishConn() {
		
		JedisConnectionFactory jedish = new JedisConnectionFactory();
		//jedis server property
		return jedish;
		
		
	}
	@Bean
	public RedisTemplate<String, Country> redishTemplate(){
		RedisTemplate<String, Country> rt = new RedisTemplate<String, Country> ();
		rt.setConnectionFactory(jedishConn());
		return rt;
		
	}

}
