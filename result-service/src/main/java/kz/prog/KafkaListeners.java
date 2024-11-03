package kz.prog;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {


    @KafkaListener(topics = "test-results", groupId = "result-group")
    void listener(String data){
        System.out.println("Listener received: " + data + " !!! ");
    }
}
