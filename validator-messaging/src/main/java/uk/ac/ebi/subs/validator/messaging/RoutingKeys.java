package uk.ac.ebi.subs.validator.messaging;

/**
 * Holds the routing keys of the messages to validate.
 *
 * Created by karoly on 28/04/2017.
 */
public class RoutingKeys {

    public static final String SUBMISSION_VALIDATOR_SUBMISSION_CREATED = "usi.submission.created";
    public static final String SUBMISSION_VALIDATOR_SUBMISSION_UPDATED = "usi.submission.updated";

    public static final String EVENT_BIOSAMPLES_SAMPLE_CREATED = "biosamples.sample.created";
    public static final String EVENT_BIOSAMPLES_SAMPLE_UPDATED = "biosamples.sample.updated";

    public static final String EVENT_ENA_SAMPLE_CREATED = "ena.sample.created";
    public static final String EVENT_ENA_SAMPLE_UPDATED = "ena.sample.updated";

    public static final String EVENT_AE_SAMPLE_CREATED = "ae.sample.created";
    public static final String EVENT_AE_SAMPLE_UPDATED = "ae.sample.updated";

    public static final String EVENT_VALIDATION_SUCCESS = "validation.success";
    public static final String EVENT_VALIDATION_ERROR = "validation.error";

    public static final String EVENT_OUTCOME_DOCUMENT_UPDATED = "outcome.updated";
}
