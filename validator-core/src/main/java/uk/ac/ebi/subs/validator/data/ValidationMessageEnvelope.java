package uk.ac.ebi.subs.validator.data;

/**
 * A container object holding the UUID (MongoDB ID) and the entity to validate.
 *
 * Created by karoly on 08/05/2017.
 */
public class ValidationMessageEnvelope<T> {

    private String validationResultUUID;
    private T entityToValidate;

    public ValidationMessageEnvelope() {
    }

    public ValidationMessageEnvelope(String validationResultUUID, T entityToValidate) {
        this.validationResultUUID = validationResultUUID;
        this.entityToValidate = entityToValidate;
    }

    public String getValidationResultUUID() {
        return validationResultUUID;
    }

    public void setValidationResultUUID(String validationResultUUID) {
        this.validationResultUUID = validationResultUUID;
    }

    public T getEntityToValidate() {
        return entityToValidate;
    }

    public void setEntityToValidate(T entityToValidate) {
        this.entityToValidate = entityToValidate;
    }
}
