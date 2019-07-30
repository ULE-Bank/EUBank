package es.unileon.ulebankoffice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import es.unileon.ulebankoffice.domain.Solicitud;
import es.unileon.ulebankoffice.domain.Test;

@Repository
public interface TestRepository extends MongoRepository<Test, String> {
	public Test findById(String id);
}
