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
     * Create a {@code Binding} between the validation exchange and BioSamples sample validation queue
     * using the routing key of deleted samples related to BioSamples.
     *
     * @param biosamplesSampleQueue {@code Queue} for validating BioSamples related samples
     * @param validationExchange {@code TopicExchange} for validation
     * @return a {@code Binding} between the validation exchange and BioSamples sample validation queue
     * using the routing key of deleted samples related to BioSamples.
     */
    @Bean
    Binding validationForDeletedBiosamplesSampleBinding(Queue biosamplesSampleQueue, TopicExchange validationExchange) {
        return BindingBuilder.bind(biosamplesSampleQueue).to(validationExchange)
                .with(RoutingKeys.EVENT_BIOSAMPLES_SAMPLE_DELETED);
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
     * Create a {@code Binding} between the validation exchange and ENA sample validation queue
     * using the routing key of deleted samples related to ENA.
     *
     * @param enaSampleQueue {@code Queue} for validating ENA related samples
     * @param validationExchange {@code TopicExchange} for validation
     * @return a {@code Binding} between the validation exchange and ENA sample validation queue
     * using the routing key of deleted samples related to ENA.
     */
    @Bean
    Binding validationForDeletedENASampleBinding(Queue enaSampleQueue, TopicExchange validationExchange) {
        return BindingBuilder.bind(enaSampleQueue).to(validationExchange)
                .with(RoutingKeys.EVENT_ENA_SAMPLE_DELETED);
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
     * Create a {@code Binding} between the validation exchange and Array Express sample validation queue
     * using the routing key of deleted samples related to Array Express.
     *
     * @param aeSampleQueue {@code Queue} for validating Array Express related samples
     * @param validationExchange {@code TopicExchange} for validation
     * @return a {@code Binding} between the validation exchange and Array Express sample validation queue
     * using the routing key of deleted samples related to Array Express.
     */
    @Bean
    Binding validationForDeletedAESampleBinding(Queue aeSampleQueue, TopicExchange validationExchange) {
        return BindingBuilder.bind(aeSampleQueue).to(validationExchange)
                .with(RoutingKeys.EVENT_AE_SAMPLE_DELETED);
    }
}
