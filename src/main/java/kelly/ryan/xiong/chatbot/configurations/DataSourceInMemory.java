package kelly.ryan.xiong.chatbot.configurations;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;


@Configuration
@Profile({"inmemory"})
public class DataSourceInMemory {

    private static final String USER_NAME = "sa";
    private static final String USER_PWD = "";
    private static final String URL = "jdbc:h2:mem:testdb";

    @Bean
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();

        hikariConfig.setUsername(USER_NAME);
        hikariConfig.setPassword(USER_PWD);
        hikariConfig.setJdbcUrl(URL);
        hikariConfig.setDriverClassName("org.h2.Driver");

        return new HikariDataSource(hikariConfig);
    }
}
