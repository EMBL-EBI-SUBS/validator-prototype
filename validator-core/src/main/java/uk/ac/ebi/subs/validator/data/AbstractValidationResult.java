package uk.ac.ebi.subs.validator.data;

import lombok.ToString;

/**
  * Basic validation outcome properties that any such object should have
  */
@ToString
public abstract class AbstractValidationResult {

    private String message;

    private ValidationStatus validationStatus = ValidationStatus.Pending;

    private String entityUuid;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ValidationStatus getValidationStatus() {
        return validationStatus;
    }

    public void setValidationStatus(ValidationStatus validationStatus) {
        this.validationStatus = validationStatus;
    }

    public String getEntityUuid() {
        return entityUuid;
    }

    public void setEntityUuid(String entityUuid) {
        this.entityUuid = entityUuid;
    }
}
