package uk.ac.ebi.subs.validator.biosamples;

import org.springframework.stereotype.Service;
import uk.ac.ebi.subs.data.component.Archive;
import uk.ac.ebi.subs.data.submittable.Sample;
import uk.ac.ebi.subs.validator.data.EntityValidationOutcome;
import uk.ac.ebi.subs.validator.data.ValidationOutcomeEnum;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class SamplesValidator {

    public static final String SUCCESS_MESSAGE = "Passed BioSamples validation with no errors.";

    public EntityValidationOutcome validate(Sample sample) {
        EntityValidationOutcome evo = new EntityValidationOutcome(Archive.BioSamples, sample.getId());
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
