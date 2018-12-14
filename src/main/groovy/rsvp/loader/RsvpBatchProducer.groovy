package rsvp.loader

import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.Topic
import io.reactivex.Flowable
import org.apache.kafka.clients.producer.RecordMetadata

@KafkaClient(batch=true)
interface RsvpBatchProducer {
    @Topic("rsvps")
    Flowable<RecordMetadata> sendRsvp(@KafkaKey Flowable<String> ids, Flowable<Rsvp> rsvps)
}
