package uk.ac.ebi.subs.validator.data;

/**
 * An identifiable object must have both an UUID and version
 */
public interface Identifiable {

    public String getVersion();

    public void setVersion(String version);

    public String getUuid();

    public void setUuid(String uuid);
}