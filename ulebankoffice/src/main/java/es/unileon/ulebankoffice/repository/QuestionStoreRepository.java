package es.unileon.ulebankoffice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import es.unileon.ulebankoffice.domain.QuestionStore;


@Repository
public interface QuestionStoreRepository extends MongoRepository<QuestionStore, String> {
	public QuestionStore findById(String id);
}
