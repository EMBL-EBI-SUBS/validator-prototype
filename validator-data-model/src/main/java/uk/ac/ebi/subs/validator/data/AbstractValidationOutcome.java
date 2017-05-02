package uk.ac.ebi.subs.validator.data;

import lombok.ToString;

@ToString
public abstract class AbstractValidationOutcome {

    private String message;

    private ValidationOutcomeEnum validationOutcome = ValidationOutcomeEnum.Pending;

    private String entityUuid;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ValidationOutcomeEnum getValidationOutcome() {
        return validationOutcome;
    }

    public void setValidationOutcome(ValidationOutcomeEnum validationOutcome) {
        this.validationOutcome = validationOutcome;
    }

    public String getEntityUuid() {
        return entityUuid;
    }

    public void setEntityUuid(String entityUuid) {
        this.entityUuid = entityUuid;
    }
}
