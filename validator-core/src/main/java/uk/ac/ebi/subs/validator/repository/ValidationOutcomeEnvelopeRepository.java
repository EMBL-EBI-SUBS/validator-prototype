package uk.ac.ebi.subs.validator.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import uk.ac.ebi.subs.validator.data.ValidationOutcomeEnvelope;

/**
 * Mongo repository REST resource for {@code ValidationOutcomeEnvelope}.
 */
public interface ValidationOutcomeEnvelopeRepository extends MongoRepository<ValidationOutcomeEnvelope, String> {
}
