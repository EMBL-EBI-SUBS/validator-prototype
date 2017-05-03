package uk.ac.ebi.subs.validator.data;

/**
  * Controlled vocabulary for validation outcomes
  */
public enum ValidationOutcomeEnum {
    Pending,    // Waiting for validation result
    Pass,       // We will accept this
    Error,      // We will not accept this
    Warning     // We will accept this, but you may wish to reconsider
}
