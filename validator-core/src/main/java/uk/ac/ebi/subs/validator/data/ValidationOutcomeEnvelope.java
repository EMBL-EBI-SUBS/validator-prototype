package uk.ac.ebi.subs.validator.data;

import java.util.List;
import java.util.UUID;

/**
 * ValidationOutcomeEnvelope, object to store all the ValidationOutcomes of a single submission.
 */
public class ValidationOutcomeEnvelope implements Identifiable {

    private String uuid;
    private String version;

    private List<ValidationOutcome> validationOutcomeList;

    private StatusEnum status;

    public ValidationOutcomeEnvelope() {}

    public ValidationOutcomeEnvelope(List<ValidationOutcome> validationOutcomeList) {
        this.validationOutcomeList = validationOutcomeList;
        this.uuid = UUID.randomUUID().toString();
        this.version = "0.0.1";
        this.status = StatusEnum.Pending;
    }

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

    public List<ValidationOutcome> getValidationOutcomeList() {
        return validationOutcomeList;
    }

    public void setValidationOutcomeList(List<ValidationOutcome> validationOutcomeList) {
        this.validationOutcomeList = validationOutcomeList;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatusCompleted() {
        this.status = StatusEnum.Completed;
    }

    enum StatusEnum {
        Pending,
        Completed
    }
}
