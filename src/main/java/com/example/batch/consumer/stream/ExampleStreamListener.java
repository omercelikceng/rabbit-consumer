package com.example.batch.consumer.stream;

import com.rabbitmq.client.*;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ExampleStreamListener implements SmartLifecycle {
    @Override
    public void start() {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            factory.setPort(5672);
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();


            channel.queueBind("topic42", "topic42","#");


            DefaultConsumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag,
                                           Envelope envelope, AMQP.BasicProperties properties,
                                           byte[] body) throws IOException {

                    System.out.println(" [x] Received '" + body + "'");
                }
            };
            channel.basicConsume("topic42", true, consumer);

        } catch (Exception ex) {
            System.out.println("x");
        }
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public int getPhase() {
        return Integer.MAX_VALUE;
    }


//    private int countRecord = 0;
//
//    private ObjectMapper objectMapper = new ObjectMapper();
//
//    @Bean
//    public Consumer<ExampleData> listenExampleData() {
//        return (response) -> {
//            System.out.println("Received the message in Consumer : " + response.getXx() + " Toplam: " + countRecord);
//
//            System.out.println(new Date());
//
//
////            try {
////                ExampleData exampleData = objectMapper.readValue(response.get(response.size() - 1 ), ExampleData.class);
////                System.out.println(exampleData.getXx());
////                System.out.println("-----------------");
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
//        };
//    }
//
//    @Bean
//    public Consumer<ExampleData> listenExampleData2() {
//        return (response) -> {
//            System.out.println("Not batch : " + response.getXx());
//            try {
//                Thread.sleep(20000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        };
//    }


}
