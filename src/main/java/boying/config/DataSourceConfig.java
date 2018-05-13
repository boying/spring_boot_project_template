package boying.config;

import boying.common.dal.DataSourceProxy;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by boying on 2018/4/30.
 */
@Configuration
public class DataSourceConfig {
    @Bean(name = "userDataSource")
    public DataSource userDataSource(@Qualifier("userHikariConfig") HikariConfig config) {
        return new DataSourceProxy(new HikariDataSource(config));
    }

    @Bean(name = "bookDataSource")
    public DataSource bookDataSource(@Qualifier("bookHikariConfig") HikariConfig config) {
        return new DataSourceProxy(new HikariDataSource(config));
    }

    @Bean(name = "userHikariConfig")
    @ConfigurationProperties(prefix = "hikari.user")
    public HikariConfig userHikariConfig() {
        return new HikariConfig();
    }

    @Bean(name = "bookHikariConfig")
    @ConfigurationProperties(prefix = "hikari.book")
    public HikariConfig bookHikariConfig() {
        return new HikariConfig();
    }

    @Bean
    public DataSourceTransactionManager userTransactionManager(@Qualifier("userDataSource") DataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public DataSourceTransactionManager bookTransactionManager(@Qualifier("bookDataSource") DataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }
}
