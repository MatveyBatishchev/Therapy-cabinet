package application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"ru.mospolytech.*", "common.*"})
@MapperScan(basePackages = {"ru.mospolytech.therapy_cabinet.mybatis.*", "common.mybatis.*"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
