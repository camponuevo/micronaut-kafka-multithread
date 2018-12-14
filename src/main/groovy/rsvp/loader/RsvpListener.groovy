package rsvp.loader

import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.OffsetReset
import io.micronaut.configuration.kafka.annotation.Topic
import io.micronaut.context.annotation.Prototype

@Prototype
@KafkaListener(offsetReset = OffsetReset.EARLIEST, groupId="rsvps",threads=3)
public class RsvpListener {

    @Topic("rsvps")
    void receiveRsvp(@KafkaKey String id, Rsvp rsvp) {
        println  "process start key ${id} on thread " + Thread.currentThread().getName() + " " + new Date()
        Thread.sleep(10000)
        println  "process.end   key ${id} on thread " + Thread.currentThread().getName() + " " + new Date()
    }
}