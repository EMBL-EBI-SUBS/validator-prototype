package uk.ac.ebi.subs.validator.repository.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import uk.ac.ebi.subs.validator.data.ValidationOutcome;

/**
 * Mongo repository REST resource for {@code ValidationOutcome}.
 *
 * Created by karoly on 03/05/2017.
 */
public interface ValidationOutcomeRepository extends MongoRepository<ValidationOutcome, String> {
}
