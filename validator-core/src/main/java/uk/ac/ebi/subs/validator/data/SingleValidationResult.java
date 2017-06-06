package uk.ac.ebi.subs.validator.data;

import lombok.ToString;
import uk.ac.ebi.subs.data.component.Archive;

/**
  * Validation entity result document to store an entity validation result for a specific rule set
  */
@ToString(callSuper = true)
public class SingleValidationResult extends AbstractValidationResult implements Identifiable {

    private int version;
    private String uuid;
    private String validationResultUUID;

    private Archive archive;

    public SingleValidationResult() {
    }

    public SingleValidationResult(Archive archive, String entityUuid) {
        this.archive = archive;
        this.setEntityUuid(entityUuid);
        this.setValidationStatus(ValidationStatus.Pending);
    }

    @Override
    public int getVersion() {
        return version;
    }

    @Override
    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String getUuid() {
        return uuid;
    }

    @Override
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Archive getArchive() {
        return archive;
    }

    public void setArchive(Archive archive) {
        this.archive = archive;
    }


    public String getValidationResultUUID() {
        return validationResultUUID;
    }

    public void setValidationResultUUID(String validationResultUUID) {
        this.validationResultUUID = validationResultUUID;
    }
}
