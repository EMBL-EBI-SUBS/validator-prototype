package uk.ac.ebi.subs.validator.ae;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uk.ac.ebi.subs.data.component.Archive;
import uk.ac.ebi.subs.data.submittable.Sample;
import uk.ac.ebi.subs.validator.data.EntityValidationOutcome;
import uk.ac.ebi.subs.validator.data.ValidationOutcomeEnum;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AeSamplesValidator {

    private static Logger logger = LoggerFactory.getLogger(AeSamplesValidator.class);

    public static final String SUCCESS_MESSAGE = "Passed ArrayExpress validation with no errors.";

    public EntityValidationOutcome validate(Sample sample) {
        logger.debug("Validating sample with ID: {}", sample.getId());
        EntityValidationOutcome evo = new EntityValidationOutcome(Archive.ArrayExpress, sample.getId());
        evo.setUuid(UUID.randomUUID().toString());
        evo.setValidationOutcome(ValidationOutcomeEnum.Pass);
        evo.setMessage(SUCCESS_MESSAGE);

        try {
            Thread.sleep(ThreadLocalRandom.current().nextLong(0, 60000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return evo;
    }
}