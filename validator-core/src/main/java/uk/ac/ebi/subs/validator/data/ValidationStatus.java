package uk.ac.ebi.subs.validator.data;

/**
 * Controlled vocabulary for validation outcomes
 *
 * <li>{@link #Pending}</li>
 * <li>{@link #Pass}</li>
 * <li>{@link #Error}</li>
 * <li>{@link #Warning}</li>
 * <li>{@link #Complete}</li>
 */
public enum ValidationStatus {
    /**
     * Waiting for validation result
     */
    Pending,
    /**
     * All validation results are accounted for,
     * to be used only on {@link ValidationResult}
     */
    Complete,
    /**
     * We will accept this
     */
    Pass,
    /**
     * We will not accept this
     */
    Error,
    /**
     * We will accept this, but you may wish to reconsider
     */
    Warning
}
