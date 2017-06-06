package uk.ac.ebi.subs.validator.ae;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uk.ac.ebi.subs.data.component.Archive;
import uk.ac.ebi.subs.data.submittable.Sample;
import uk.ac.ebi.subs.validator.data.SingleValidationResult;
import uk.ac.ebi.subs.validator.data.ValidationStatus;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AeSamplesValidator {

    private static Logger logger = LoggerFactory.getLogger(AeSamplesValidator.class);

    public static final String SUCCESS_MESSAGE = "Passed ArrayExpress validation with no errors.";

    public SingleValidationResult validate(Sample sample) {
        logger.debug("Validating sample with ID: {}", sample.getId());
        SingleValidationResult singleValidationResult = new SingleValidationResult(Archive.ArrayExpress, sample.getId());
        singleValidationResult.setUuid(UUID.randomUUID().toString());
        singleValidationResult.setValidationStatus(ValidationStatus.Pass);
        singleValidationResult.setMessage(SUCCESS_MESSAGE);

        try {
            Thread.sleep(ThreadLocalRandom.current().nextLong(0, 60000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return singleValidationResult;
    }
}