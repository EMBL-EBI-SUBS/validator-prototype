package uk.ac.ebi.subs.validator.messaging;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This class is responsible for the configuration of the validation queues.
 *
 * Created by karoly on 28/04/2017.
 */
@Configuration
public class ValidatorQueueConfig {

    /**
     * Instantiate a {@code Queue} for validate published submissions.
     *
     * @return an instance of a {@code Queue} for validate published submissions.
     */
    @Bean
    Queue validatorQueue() {
        return new Queue(Queues.SUBMISSION_SAMPLE_VALIDATOR, true);
    }

    /**
     * Create a {@code Binding} between the submission exchange and validation queue using the routing key of created submissions.
     *
     * @param validatorQueue {@code Queue} for validating submissions before submitting them
     * @param submissionExchange {@code TopicExchange} for submissions
     * @return a {@code Binding} between the submission exchange and validation queue using the routing key of created submissions.
     */
    @Bean
    Binding validationForCreatedSubmissionBinding(Queue validatorQueue, TopicExchange submissionExchange) {
        return BindingBuilder.bind(validatorQueue).to(submissionExchange)
                .with(RoutingKeys.SUBMISSION_VALIDATOR_SUBMISSION_CREATED);
    }

    /**
     * Create a {@code Binding} between the submission exchange and validation queue using the routing key of updated submissions.
     *
     * @param validatorQueue {@code Queue} for validating submissions before submitting them
     * @param submissionExchange {@code TopicExchange} for submissions
     * @return a {@code Binding} between the submission exchange and validation queue using the routing key of updated submissions.
     */
    @Bean
    Binding validationForUpdatedSubmissionBinding(Queue validatorQueue, TopicExchange submissionExchange) {
        return BindingBuilder.bind(validatorQueue).to(submissionExchange)
                .with(RoutingKeys.SUBMISSION_VALIDATOR_SUBMISSION_UPDATED);
    }

    /**
     * Instantiate a {@code Queue} for validate samples related to BioSamples.
     *
     * @return an instance of a {@code Queue} for validate samples related to BioSamples.
     */
    @Bean
    Queue biosamplesSampleQueue() {
        return new Queue(Queues.BIOSAMPLES_SAMPLE_VALIDATION, true);
    }

    /**
     * Create a {@code Binding} between the validation exchange and BioSamples sample validation queue
     * using the routing key of created samples related to BioSamples.
     *
     * @param biosamplesSampleQueue {@code Queue} for validating BioSamples related samples
     * @param validationExchange {@code TopicExchange} for validation
     * @return a {@code Binding} between the validation exchange and BioSamples sample validation queue
     * using the routing key of created samples related to BioSamples.
     */
    @Bean
    Binding validationForCreatedBiosamplesSampleBinding(Queue biosamplesSampleQueue, TopicExchange validationExchange) {
        return BindingBuilder.bind(biosamplesSampleQueue).to(validationExchange)
                .with(RoutingKeys.EVENT_BIOSAMPLES_SAMPLE_CREATED);
    }

    /**
     * Create a {@code Binding} between the validation exchange and BioSamples sample validation queue
     * using the routing key of updated samples related to BioSamples.
     *
     * @param biosamplesSampleQueue {@code Queue} for validating BioSamples related samples
     * @param validationExchange {@code TopicExchange} for validation
     * @return a {@code Binding} between the validation exchange and BioSamples sample validation queue
     * using the routing key of updated samples related to BioSamples.
     */
    @Bean
    Binding validationForUpdatedBiosamplesSampleBinding(Queue biosamplesSampleQueue, TopicExchange validationExchange) {
        return BindingBuilder.bind(biosamplesSampleQueue).to(validationExchange)
                .with(RoutingKeys.EVENT_BIOSAMPLES_SAMPLE_UPDATED);
    }

    /**
     * Instantiate a {@code Queue} for validate samples related to ENA.
     *
     * @return an instance of a {@code Queue} for validate samples related to ENA.
     */
    @Bean
    Queue enaSampleQueue() {
        return new Queue(Queues.ENA_SAMPLE_VALIDATION, true);
    }

    /**
     * Create a {@code Binding} between the validation exchange and ENA sample validation queue
     * using the routing key of created samples related to ENA.
     *
     * @param enaSampleQueue {@code Queue} for validating ENA related samples
     * @param validationExchange {@code TopicExchange} for validation
     * @return a {@code Binding} between the validation exchange and ENA sample validation queue
     * using the routing key of created samples related to ENA.
     */
    @Bean
    Binding validationForCreatedENASampleBinding(Queue enaSampleQueue, TopicExchange validationExchange) {
        return BindingBuilder.bind(enaSampleQueue).to(validationExchange)
                .with(RoutingKeys.EVENT_ENA_SAMPLE_CREATED);
    }

    /**
     * Create a {@code Binding} between the validation exchange and ENA sample validation queue
     * using the routing key of updated samples related to ENA.
     *
     * @param enaSampleQueue {@code Queue} for validating ENA related samples
     * @param validationExchange {@code TopicExchange} for validation
     * @return a {@code Binding} between the validation exchange and ENA sample validation queue
     * using the routing key of updated samples related to ENA.
     */
    @Bean
    Binding validationForUpdatedENASampleBinding(Queue enaSampleQueue, TopicExchange validationExchange) {
        return BindingBuilder.bind(enaSampleQueue).to(validationExchange)
                .with(RoutingKeys.EVENT_ENA_SAMPLE_UPDATED);
    }

    /**
     * Instantiate a {@code Queue} for validate samples related to Array Express.
     *
     * @return an instance of a {@code Queue} for validate samples related to Array Express.
     */
    @Bean
    Queue aeSampleQueue() {
        return new Queue(Queues.AE_SAMPLE_VALIDATION, true);
    }

    /**
     * Create a {@code Binding} between the validation exchange and Array Express sample validation queue
     * using the routing key of created samples related to Array Express.
     *
     * @param aeSampleQueue {@code Queue} for validating Array Express related samples
     * @param validationExchange {@code TopicExchange} for validation
     * @return a {@code Binding} between the validation exchange and Array Express sample validation queue
     * using the routing key of created samples related to Array Express.
     */
    @Bean
    Binding validationForCreatedAESampleBinding(Queue aeSampleQueue, TopicExchange validationExchange) {
        return BindingBuilder.bind(aeSampleQueue).to(validationExchange)
                .with(RoutingKeys.EVENT_AE_SAMPLE_CREATED);
    }

    /**
     * Create a {@code Binding} between the validation exchange and Array Express sample validation queue
     * using the routing key of updated samples related to Array Express.
     *
     * @param aeSampleQueue {@code Queue} for validating Array Express related samples
     * @param validationExchange {@code TopicExchange} for validation
     * @return a {@code Binding} between the validation exchange and Array Express sample validation queue
     * using the routing key of updated samples related to Array Express.
     */
    @Bean
    Binding validationForUpdatedAESampleBinding(Queue aeSampleQueue, TopicExchange validationExchange) {
        return BindingBuilder.bind(aeSampleQueue).to(validationExchange)
                .with(RoutingKeys.EVENT_AE_SAMPLE_UPDATED);
    }

    /**
     * Instantiate a {@code Queue} for publish validation results.
     *
     * @return an instance of a {@code Queue} for publish validation results.
     */
    @Bean
    Queue validationResultQueue() {
        return new Queue(Queues.VALIDATION_RESULT, true);
    }

    /**
     * Create a {@code Binding} between the validation exchange and validation result queue
     * using the routing key of successful validation.
     *
     * @param validationResultQueue {@code Queue} for validation results
     * @param validationExchange {@code TopicExchange} for validation
     * @return a {@code Binding} between the validation exchange and validation result queue
     * using the routing key of successful validation.
     */
    @Bean
    Binding validationResultSuccessBinding(Queue validationResultQueue, TopicExchange validationExchange) {
        return BindingBuilder.bind(validationResultQueue).to(validationExchange)
                .with(RoutingKeys.EVENT_VALIDATION_SUCCESS);
    }

    /**
     * Create a {@code Binding} between the validation exchange and validation result queue
     * using the routing key of erred validation.
     *
     * @param validationResultQueue {@code Queue} for validation results
     * @param validationExchange {@code TopicExchange} for validation
     * @return a {@code Binding} between the validation exchange and validation result queue
     * using the routing key of erred validation.
     */
    @Bean
    Binding validationResultErrorBinding(Queue validationResultQueue, TopicExchange validationExchange) {
        return BindingBuilder.bind(validationResultQueue).to(validationExchange)
                .with(RoutingKeys.EVENT_VALIDATION_ERROR);
    }

    /**
     * Instantiate a {@code Queue} for publish events related to the outcome document.
     *
     * @return an instance of a {@code Queue} for publish events related to the outcome document.
     */
    @Bean
    Queue outcomeDocumentQueue() {
        return new Queue(Queues.OUTCOME_DOCUMENT_UPDATE, true);
    }

    /**
     * Create a {@code Binding} between the validation exchange and the outcome document queue
     * using the routing key of outcome document updated.
     *
     * @param outcomeDocumentQueue {@code Queue} for outcome document events
     * @param validationExchange {@code TopicExchange} for validation
     * @return a {@code Binding} between the validation exchange and the outcome document queue
     * using the routing key of outcome document updated.
     */
    @Bean
    Binding outcomeDocumentUpdatedBinding(Queue outcomeDocumentQueue, TopicExchange validationExchange) {
        return BindingBuilder.bind(outcomeDocumentQueue).to(validationExchange)
                .with(RoutingKeys.EVENT_OUTCOME_DOCUMENT_UPDATED);
    }
}
