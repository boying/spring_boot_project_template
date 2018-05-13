package boying;

import boying.common.redis.RedisUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication(
		exclude = {
				DataSourceAutoConfiguration.class
		}
)
public class SpringBootProjectTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectTemplateApplication.class, args);
	}
}
