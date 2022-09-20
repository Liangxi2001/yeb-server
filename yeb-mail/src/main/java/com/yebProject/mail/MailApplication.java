package com.yebProject.mail;

import com.yebProject.server.pojo.MailConstants;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author 此间凉汐
 * @date 2022/4/5 13:19
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MailApplication {
    public static void main(String[] args) {
        SpringApplication.run(MailApplication.class,args);
    }

    @Bean
    public  Queue queue(){
        return new Queue(MailConstants.MAIL_QUEUE_NAME);
    }
}
