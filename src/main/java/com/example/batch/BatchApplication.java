package com.example.batch;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.binding.BindingService;
import org.springframework.cloud.stream.binding.SubscribableChannelBindingTargetFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.messaging.SubscribableChannel;

@SpringBootApplication
public class BatchApplication extends Application {

    @Autowired
    private ConfigurableApplicationContext applicationContext;
//    @Autowired
//    private SubscribableChannelBindingTargetFactory bindingTargetFactory;
//    @Autowired
//    private BindingService bindingService;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
//        SubscribableChannel channel = bindingTargetFactory.createInput("tst1118");
//        bindingService.bindConsumer(channel, "tst1118");
//        channel.subscribe(new ReceiverMessageHandler());
    }

    @Override
    public void init() {
        applicationContext = SpringApplication.run(BatchApplication.class, "");
        applicationContext.getAutowireCapableBeanFactory().autowireBean(this);
    }

}
