package rsvp.loader

import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaClient
public interface RsvpProducer {
    @Topic("rsvps")
    void sendRsvp(@KafkaKey String id, Rsvp rsvp);
}
