/**
 * 
 */
package es.unileon.ulebankoffice.configuration;

import com.github.fakemongo.Fongo;
import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Razvan Raducu
 *
 */

@Configuration
@EnableMongoRepositories(basePackages = {"es.unileon.ulebankoffice.repository"})
public class MongoTestConfig extends AbstractMongoConfiguration{

	private final String DB_NAME = "ulebankofficetestdb";
	
	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return DB_NAME;
	}

	@Override
	@Bean(destroyMethod = "close")
	public Mongo mongo() {
		// TODO Auto-generated method stub
		return new Fongo(getDatabaseName()).getMongo();
	}
	
	@Override
	protected Collection<String> getMappingBasePackages() {
		Collection<String> packages = new ArrayList<>();
		packages.add("es.unileon.ulebankoffice.domain");
		return packages;
	}

}
