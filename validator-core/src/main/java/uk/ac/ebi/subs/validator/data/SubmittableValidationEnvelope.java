package uk.ac.ebi.subs.validator.data;

/**
 * Created by karoly on 30/05/2017.
 */
public class SubmittableValidationEnvelope<BaseSubmittable> {

    private String submissionId;
    private BaseSubmittable entityToValidate;

    public SubmittableValidationEnvelope() {
    }

    public SubmittableValidationEnvelope(String submissionId, BaseSubmittable entityToValidate) {
        this.submissionId = submissionId;
        this.entityToValidate = entityToValidate;
    }

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public BaseSubmittable getEntityToValidate() {
        return entityToValidate;
    }

    public void setEntityToValidate(BaseSubmittable entityToValidate) {
        this.entityToValidate = entityToValidate;
    }
}
