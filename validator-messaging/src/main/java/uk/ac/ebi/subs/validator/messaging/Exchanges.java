package uk.ac.ebi.subs.validator.messaging;

/**
 * Holds the names for the exchanges for validation.
 *
 * Created by karoly on 28/04/2017.
 */
public class Exchanges {

    public static final String USI_CONTRACT_VERSION = "usi-1";

    public static final String CONTRACT_VERSION = "1";

    public static final String VALIDATION = ":validation-exchange-" + CONTRACT_VERSION;
    public static final String SUBMISSIONS = USI_CONTRACT_VERSION+":submission-exchange";
}
