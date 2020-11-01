package vk.api;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VkAppSpringApplication {


    public static void main(String[] args) throws ClientException, ApiException, InterruptedException {
        SpringApplication.run(VkAppSpringApplication.class);
    }
}
