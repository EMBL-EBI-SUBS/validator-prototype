package uk.ac.ebi.subs.validator.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import uk.ac.ebi.subs.validator.data.ValidationResult;

import java.util.List;

/**
 * Mongo repository REST resource for {@code ValidationResult}.
 */
public interface ValidationResultRepository extends MongoRepository<ValidationResult, String> {

    List<ValidationResult> findBySubmissionIdAndEntityUuid(String submissionId, String entityUuid);
}
