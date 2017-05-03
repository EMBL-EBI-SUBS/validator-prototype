package uk.ac.ebi.subs.validator.data;

import lombok.ToString;
import uk.ac.ebi.subs.data.component.Archive;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
  * Validation outcome document to store all the validation results
  */
@ToString(callSuper = true)
public class ValidationOutcome extends AbstractValidationOutcome implements Identifiable {

    private String version;
    private UUID uuid;

    private List<EntityValidationOutcome> validationResults;
    private Map<Archive, Boolean> expectedOutcomes;

    public ValidationOutcome(List<Archive> expectedOutcomes, String entityUUid) {
        this.expectedOutcomes = new HashMap<>();
        for (Archive archive : expectedOutcomes) {
            this.expectedOutcomes.put(archive, false);
        }
        this.setEntityUuid(entityUUid);
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
    public UUID getUuid() {
        return uuid;
    }

    @Override
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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
