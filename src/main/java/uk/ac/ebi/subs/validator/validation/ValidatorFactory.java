package uk.ac.ebi.subs.validator.validation;

import org.springframework.validation.Validator;
import uk.ac.ebi.subs.data.component.SampleRelationship;
import uk.ac.ebi.subs.data.submittable.Sample;

public class ValidatorFactory {

    public Validator getValidator(Class<?> clazz) {

        if(clazz.isInstance(Sample.class)) {
            return new SampleValidator();

        } else if(clazz.isInstance(SampleRelationship.class)) {
            return new SampleRelationshipValidator();

        } else {
            return null;
        }
    }

}
