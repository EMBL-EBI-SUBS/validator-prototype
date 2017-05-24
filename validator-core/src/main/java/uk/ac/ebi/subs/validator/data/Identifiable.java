package uk.ac.ebi.subs.validator.data;

/**
 * An identifiable object must have both an UUID and version
 */
public interface Identifiable {

    int getVersion();

    void setVersion(int version);

    String getUuid();

    void setUuid(String uuid);
}
