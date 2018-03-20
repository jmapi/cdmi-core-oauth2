package pw.cdmi.core.oauth2.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


import javax.sql.DataSource;

/**
 * 配置用户信息，以及受保护路径、允许访问路径
 */
@Configuration
public class AlanOAuthWebConfig extends WebSecurityConfigurerAdapter {
	@Autowired
    public DataSource dataSource;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      
    //	super.configure(http);
   //    http.authorizeRequests().antMatchers("/uaa/pass/v3/users/user").permitAll().and().antMatcher("/*").csrf().disable();
       http.authorizeRequests()
       			.antMatchers("/*/*/users/*").permitAll()
       			.antMatchers("/**").hasAnyRole("USER")
       			.and()
       		.formLogin();
       				
       http.csrf().disable();
      // .formLogin();
       //
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/favor.ico");
        
        
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //        auth.inMemoryAuthentication()
        //                .withUser("reader")
        //                .password("reader")
        //                .authorities("FOO_READ")
        //                .and()
        //                .withUser("writer")
        //                .password("writer")
        //                .authorities("FOO_READ", "FOO_WRITE");

        //        UserDetails userDetails = userDetailsService().loadUserByUsername("reader");
        //        System.out.println(userDetails.getPassword());

        auth.userDetailsService(oAuth2UserDetailsService());
   //     .and().jdbcAuthentication();
   //     auth.authenticationProvider(alanSsoAuthProvider);
   //     UserDetails userDetails = userDetailsService().loadUserByUsername("reader");
   //     System.out.println(userDetails.getPassword());
    }
    @Bean
    public UserDetailsService  oAuth2UserDetailsService(){
    	return new OAuth2UserDetailsService();
    }

}
