package com.app.check;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



/**
 * Класс Main основной класс.
 *
 * Аннотация @SpringBootApplication объединяет в себе три аннотации: *
 * Configuration - класс содержит конфигурацию Spring.
 * EnableAutoConfiguration - Spring Boot автоматически настраивает приложение на основе зависимостей.
 * ComponentScan - Spring ищет компоненты, которые нужно зарегистрировать в контексте приложения. *
 *
 * Метод main запускает приложение, используя SpringApplication.run.
 */
@SpringBootApplication
public class Main {
    /**
     * Точка входа в приложение.
     *
     * @param args Аргументы командной строки.
     */
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
