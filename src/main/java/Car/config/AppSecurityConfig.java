package Car.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(dataSource);
////        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
////        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select Login, Password, true as enable  from usser where Login=?")
                .authoritiesByUsernameQuery(
                        "SELECT u.Login, \n" +
                                "\tcase u.User_id\n" +
                                "\t\twhen (SELECT a.USER_ID\n" +
                                "\t\t\t  FROM admin a\n" +
                                "              WHERE u.User_id = a.User_id) then \"ROLE_ADMIN\"\n" +
                                "\t\twhen (SELECT s.User_id\n" +
                                "\t\t\t  FROM student s\n" +
                                "              WHERE u.User_id = s.User_id) then \"ROLE_USER\"\n" +
                                "\tend as role\n" +
                                "FROM usser u\n" +
                                "WHERE u.Login =?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/user/**").access("hasRole('ROLE_ADMIN')")
                .and().formLogin().loginPage("/login")
                .and().formLogin().defaultSuccessUrl("/index")
                .usernameParameter("username")
                .passwordParameter("password")
                .and().logout().logoutUrl("/logout")
                .and().csrf().disable();
    }
}
