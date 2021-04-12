package org.neustupov.producer;

import java.util.concurrent.ExecutionException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.neustupov.model.Weather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Component
public class MessageProducer {

  private final KafkaProducer<String, Weather> kafkaProducer;
  private final KafkaTemplate<String, Weather> kafkaTemplate;
  @Value(value = "${kafka.topic.name}")
  private String topicName;

  public MessageProducer(KafkaProducer<String, Weather> kafkaProducer, KafkaTemplate<String, Weather> kafkaTemplate) {
    this.kafkaProducer = kafkaProducer;
    this.kafkaTemplate = kafkaTemplate;
  }

  public void simpleSendMessage(Weather weather){
    ProducerRecord<String, Weather> record = new ProducerRecord<>(topicName, weather);
    kafkaProducer.send(record);
  }

  public void synchSendMessage(Weather weather){
    ProducerRecord<String, Weather> record = new ProducerRecord<>(topicName, weather);
    try {
      kafkaProducer.send(record).get();
    } catch (InterruptedException | ExecutionException e) {
      log.error(e.getMessage(), e);
    }
  }

  public void asynchSendMessage(Weather weather){
    ProducerRecord<String, Weather> record = new ProducerRecord<>(topicName, weather);
    kafkaProducer.send(record, new SimpleProducerCallback());
  }

  @SneakyThrows
  public void asynchSendMessageWithSpringInterfaces(Weather weather) {
    ListenableFuture<SendResult<String, Weather>> future = kafkaTemplate.send(topicName, weather);

    future.addCallback(new ListenableFutureCallback<SendResult<String, Weather>>() {
      @Override
      public void onFailure(Throwable throwable) {
        log.error("Unable to send message = {} dut to: {}", weather, throwable.getMessage());
      }

      @Override
      public void onSuccess(SendResult<String, Weather> stringDataSendResult) {
        log.info("Sent Message = {} with offset = {}", weather, stringDataSendResult.getRecordMetadata().offset());
      }
    });
  }

  private static class SimpleProducerCallback implements Callback {

    @Override
    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
      if (e != null){
        log.error(e.getMessage(), e);
      }
    }
  }
}
