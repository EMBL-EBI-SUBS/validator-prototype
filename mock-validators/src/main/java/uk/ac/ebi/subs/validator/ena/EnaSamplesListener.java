package uk.ac.ebi.subs.validator.ena;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.ebi.subs.data.submittable.Sample;
import uk.ac.ebi.subs.validator.data.SingleValidationResult;
import uk.ac.ebi.subs.validator.data.ValidationMessageEnvelope;
import uk.ac.ebi.subs.validator.data.ValidationStatus;
import uk.ac.ebi.subs.validator.messaging.Exchanges;
import uk.ac.ebi.subs.validator.messaging.Queues;
import uk.ac.ebi.subs.validator.messaging.RoutingKeys;

@Service
public class EnaSamplesListener {
    private static Logger logger = LoggerFactory.getLogger(EnaSamplesListener.class);

    private RabbitMessagingTemplate rabbitMessagingTemplate;

    @Autowired
    EnaSamplesValidator samplesValidator;

    @Autowired
    public EnaSamplesListener(RabbitMessagingTemplate rabbitMessagingTemplate) {
        this.rabbitMessagingTemplate = rabbitMessagingTemplate;
    }

    @RabbitListener(queues = Queues.ENA_SAMPLE_VALIDATION)
    public void handleSamples(ValidationMessageEnvelope<Sample> messageEnvelope) {
        logger.debug("Received sample message.");

        SingleValidationResult singleValidationResult = samplesValidator.validate(messageEnvelope.getEntityToValidate());

        logger.debug("ENA Sample validation finished.");

        singleValidationResult.setValidationResultUUID(messageEnvelope.getValidationResultUUID());

        sendResults(singleValidationResult);
    }

    private void sendResults(SingleValidationResult singleValidationResult) {
        if (singleValidationResult.getValidationStatus().equals(ValidationStatus.Error)) {
            logger.debug("Sending message: ENA Sample validation failed.");
            rabbitMessagingTemplate.convertAndSend(Exchanges.VALIDATION, RoutingKeys.EVENT_VALIDATION_ERROR, singleValidationResult);
        } else {
            logger.debug("Sending message: ENA Sample validation succeed.");
            rabbitMessagingTemplate.convertAndSend(Exchanges.VALIDATION, RoutingKeys.EVENT_VALIDATION_SUCCESS, singleValidationResult);
        }
    }
}
