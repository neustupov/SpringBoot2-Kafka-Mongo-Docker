package org.neustupov;

import org.neustupov.producer.MessageProducer;
import org.neustupov.service.ApiService;
import org.neustupov.service.ApiServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ProducerApplication {

  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(ProducerApplication.class, args);

    MessageProducer producer = context.getBean(MessageProducer.class);
    ApiService service = context.getBean(ApiServiceImpl.class);

    //Простая отправка
    producer.simpleSendMessage(service.getWeather());

    //Синхронная отправка
    producer.synchSendMessage(service.getWeather());

    //Асинхронная отправка
    producer.asynchSendMessage(service.getWeather());

    //Асинхронная отправка с санкаренси интерфейсами спринга
    producer.asynchSendMessageWithSpringInterfaces(service.getWeather());
    SpringApplication.run(ProducerApplication.class, args);
  }

}
