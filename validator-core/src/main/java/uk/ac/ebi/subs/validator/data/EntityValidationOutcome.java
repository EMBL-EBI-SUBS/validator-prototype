package uk.ac.ebi.subs.validator.data;

import lombok.ToString;
import uk.ac.ebi.subs.data.component.Archive;

/**
  * Validation entity outcome document to store an entity validation result for a specific rule set
  */
@ToString(callSuper = true)
public class EntityValidationOutcome extends AbstractValidationOutcome implements Identifiable {

    private String version;
    private String uuid;
    private String outcomeDocumentUUID;

    private Archive archive;

    public EntityValidationOutcome() {
    }

    public EntityValidationOutcome(Archive archive, String entityUuid) {
        this.archive = archive;
        this.setEntityUuid(entityUuid);
        this.setValidationOutcome(ValidationOutcomeEnum.Pending);
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public void setVersion(String version) {
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

    public String getOutcomeDocumentUUID() {
        return outcomeDocumentUUID;
    }

    public void setOutcomeDocumentUUID(String outcomeDocumentUUID) {
        this.outcomeDocumentUUID = outcomeDocumentUUID;
    }
}
