package uk.ac.ebi.subs.validator.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import uk.ac.ebi.subs.validator.data.ValidationOutcome;

import java.util.List;

/**
 * Mongo repository REST resource for {@code ValidationOutcome}.
 */
public interface ValidationOutcomeRepository extends MongoRepository<ValidationOutcome, String> {

    List<ValidationOutcome> findBySubmissionIdAndEntityUuid(String submissionId, String entityUuid);
}
