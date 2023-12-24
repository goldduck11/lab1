package org.example;

import Server.JavaServerApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;

@SpringBootApplication
@EnableScheduling
public class Main {
    public static void main(String[] args) {
//        startServer();
        System.out.println(UUID.randomUUID());
        SpringApplication.run(JavaServerApplication.class, args);
//        dbHelper.addExampleUsers();
    }

    private static void startServer() {
        try {
            // Задайте путь к исполняемому файлу Node.js и путь к вашему server.js
            String nodeCommand = "node";
            String serverScript = "src/main/Server/server.js";

            // Создайте процесс-строитель
            ProcessBuilder processBuilder = new ProcessBuilder(nodeCommand, serverScript);

            // Запустите процесс
            Process process = processBuilder.start();

            // Прочитайте вывод процесса (например, для отладки)
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Дождитесь завершения процесса
            int exitCode = process.waitFor();
            System.out.println("Server process exited with code " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}