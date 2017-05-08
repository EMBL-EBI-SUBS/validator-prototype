package uk.ac.ebi.subs.validator.biosamples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.stereotype.Service;
import uk.ac.ebi.subs.data.component.Archive;
import uk.ac.ebi.subs.data.submittable.Sample;
import uk.ac.ebi.subs.validator.data.EntityValidationOutcome;
import uk.ac.ebi.subs.validator.data.ValidationOutcomeEnum;
import uk.ac.ebi.subs.validator.messaging.Exchanges;
import uk.ac.ebi.subs.validator.messaging.Queues;
import uk.ac.ebi.subs.validator.messaging.RoutingKeys;

@Service
public class SamplesListener {
    private static Logger logger = LoggerFactory.getLogger(SamplesListener.class);

    private RabbitMessagingTemplate rabbitMessagingTemplate;

    @Autowired
    SamplesValidator samplesValidator;

    @Autowired
    public SamplesListener(RabbitMessagingTemplate rabbitMessagingTemplate, MessageConverter messageConverter) {
        this.rabbitMessagingTemplate = rabbitMessagingTemplate;
        this.rabbitMessagingTemplate.setMessageConverter(messageConverter);
    }

    @RabbitListener(queues = Queues.BIOSAMPLES_SAMPLE_VALIDATION)
    public void handleSamples(Sample sample) {
        logger.debug("Received sample.");

        EntityValidationOutcome validationOutcome = samplesValidator.validate(sample);
        validationOutcome.setArchive(Archive.BioSamples);

        sendResults(validationOutcome);
    }

    private void sendResults(EntityValidationOutcome validationOutcome) {
        //Fpr testing purposes we'll use sleep to test asynchronously
        if (validationOutcome.getValidationOutcome().equals(ValidationOutcomeEnum.Error)) {
            rabbitMessagingTemplate.convertAndSend(Exchanges.VALIDATION, RoutingKeys.EVENT_VALIDATION_ERROR, Queues.VALIDATION_RESULT);
        } else {
            rabbitMessagingTemplate.convertAndSend(Exchanges.VALIDATION, RoutingKeys.EVENT_VALIDATION_SUCCESS, Queues.VALIDATION_RESULT);
        }
    }
}
