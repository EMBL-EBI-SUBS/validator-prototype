package uk.ac.ebi.subs.validator.data;

import lombok.ToString;
import uk.ac.ebi.subs.data.component.Archive;

import java.util.UUID;

@ToString(callSuper = true)
public class EntityValidationOutcome extends AbstractValidationOutcome implements Identifiable {

    private String version;
    private UUID uuid;

    private Archive archive;

    public EntityValidationOutcome(Archive archive, String entityUuid) {
        this.archive = archive;
        this.setEntityUuid(entityUuid);
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

}
