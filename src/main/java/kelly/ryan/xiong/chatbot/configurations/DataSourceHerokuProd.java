package kelly.ryan.xiong.chatbot.configurations;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile({"heroku-prod"})
public class DataSourceHerokuProd {

    /* set VM options in config: -Dspring.profiles.active=heroku-prod
     * set environment variables in config for username/pwd/url
     * @Value("${bean.name}") String beanName;
     */

    private static final String USER_NAME = System.getenv("springuser");
    private static final String USER_PWD = System.getenv("spring");
    private static final String URL = System.getenv("jdbc:postgresql://localhost:5432/ripl");

    @Bean
    public DataSource dataSource(){
        HikariConfig hikariConfig = new HikariConfig();

        hikariConfig.setUsername(USER_NAME);
        hikariConfig.setPassword(USER_PWD);
        hikariConfig.setJdbcUrl(URL);
        hikariConfig.setDriverClassName("org.postgresql.Driver");

        return new HikariDataSource(hikariConfig);
    }
}
