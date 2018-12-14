package rsvp.loader

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

import javax.inject.Inject


@Controller('/rsvpProducer')
class RsvpProducerController {


    @Inject RsvpProducer producer

    @Get('produce/{count}')
    HttpResponse<?> produce(Integer count){
        Integer current = 0
        (current..count).each{
            String key = UUID.randomUUID().toString()
            producer.sendRsvp(key, new Rsvp())
        }
    }
}
