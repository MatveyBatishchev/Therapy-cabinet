package application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import java.time.ZoneId;
import java.util.TimeZone;

@SpringBootApplication(scanBasePackages = {"ru.mospolytech.*", "common.*"})
@MapperScan(basePackages = {"ru.mospolytech.therapy_cabinet.mybatis.*", "common.mybatis.*"})
@EnableRedisRepositories(basePackages = "ru.mospolytech.*")
public class Application {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.systemDefault()));
        SpringApplication.run(Application.class, args);
    }

}
