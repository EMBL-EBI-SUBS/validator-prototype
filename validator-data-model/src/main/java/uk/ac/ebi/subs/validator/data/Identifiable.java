package uk.ac.ebi.subs.validator.data;

import java.util.UUID;

public interface Identifiable {

    public String getVersion();

    public void setVersion(String version);

    public UUID getUuid();

    public void setUuid(UUID uuid);
}
