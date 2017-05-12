package uk.ac.ebi.subs.validator.data;

/**
 * A container object holding the UUID (MongoDB ID) and the entity to validate.
 *
 * Created by karoly on 08/05/2017.
 */
public class ValidationMessageEnvelope<T> {

    private String outcomeDocumentUUID;
    private T entityToValidate;

    public ValidationMessageEnvelope() {
    }

    public ValidationMessageEnvelope(String outcomeDocumentUUID, T entityToValidate) {
        this.outcomeDocumentUUID = outcomeDocumentUUID;
        this.entityToValidate = entityToValidate;
    }

    public String getOutcomeDocumentUUID() {
        return outcomeDocumentUUID;
    }

    public T getEntityToValidate() {
        return entityToValidate;
    }

}
