package com.example.kafkaDemo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "example", groupId = "groupId-1")
    void listener(String data) {
        System.out.println("Listener received " + data);
    }

    @KafkaListener(topics = "example2", groupId = "groupId-2")
    void listener2(String data) {

        File file = new File("path\\kafkaLogs.txt");

        try {
            if(!file.exists()) {
                file.createNewFile();
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(data);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Listener received " + data + " from topic 2");
    }
}
