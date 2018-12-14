package rsvp.loader

import io.micronaut.context.event.ApplicationEventListener
import io.micronaut.context.event.StartupEvent

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Bootstrap implements ApplicationEventListener<StartupEvent> {

    @Inject RsvpProducer producer

    @Override
    void onApplicationEvent(StartupEvent event) {
        (1..20).each{
            String key = UUID.randomUUID().toString()
            producer.sendRsvp(key, new Rsvp())
        }
    }

}
