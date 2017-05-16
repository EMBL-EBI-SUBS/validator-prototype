package uk.ac.ebi.subs.validator.data;

import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import uk.ac.ebi.subs.data.component.Archive;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
  * Validation outcome document to store all the validation results
  */
@ToString(callSuper = true)
@Document
@CompoundIndex(name = "submission_entity_id", def = "{'submissionId': 1, 'entityUuid': 1}")
public class ValidationOutcome extends AbstractValidationOutcome implements Identifiable {

    @Id
    private String uuid;
    private String version;

    @Indexed
    private String submissionId;

    @Transient
    private List<Archive> expectedArchives;

    private List<EntityValidationOutcome> validationResults = new ArrayList<>();
    private Map<Archive, Boolean> expectedOutcomes;

    @Override
    public String getUuid() {
        return uuid;
    }

    @Override
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public void setVersion(String version) {
        this.version = version;
    }

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public List<Archive> getExpectedArchives() {
        return expectedArchives;
    }

    public void setExpectedArchives(List<Archive> expectedArchives) {
        this.expectedArchives = expectedArchives;
    }

    public List<EntityValidationOutcome> getValidationResults() {
        return validationResults;
    }

    public void setValidationResults(List<EntityValidationOutcome> validationResults) {
        this.validationResults = validationResults;
    }

    public Map<Archive, Boolean> getExpectedOutcomes() {
        return expectedOutcomes;
    }

    public void setExpectedOutcomes(Map<Archive, Boolean> expectedOutcomes) {
        this.expectedOutcomes = expectedOutcomes;
    }
}
