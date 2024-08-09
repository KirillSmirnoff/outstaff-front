package ru.k2.outstaff.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfiguration {

//    override fun configure(web: WebSecurity?) {
//        web!!.ignoring()
//                .antMatchers("/")
//                .antMatchers("/static/**")
//                .antMatchers("/templates/**")
//
//    }

    fun defaultSecurityFilterChain(http: HttpSecurity): SecurityFilterChain {
        return http
                .authorizeHttpRequests{authorized -> authorized.anyRequest().authenticated()}
                .oauth2Login(Customizer.withDefaults())
//                .oauth2Login{ authorization -> authorization.loginPage("/auth")
//                authorization.authorizationEndpoint{ customizer -> customizer.baseUri("/auth") }
//                }
                .build()
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/home").authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/auth").loginProcessingUrl("/auth/process").successForwardUrl("/home")
//                .and()
//                .logout()
//                .
    }

//    override fun configure(auth: AuthenticationManagerBuilder?) {
//        auth!!.inMemoryAuthentication()
//                .withUser("man_anton").password("0").roles("MANAGER")
//    }

    @Bean
    fun passwordEncoder(): PasswordEncoder{
        return BCryptPasswordEncoder()
    }

//    @Bean
//    fun daoAuthenticationProvider(): DaoAuthenticationProvider{
//        val daoAuthenticationProvider = DaoAuthenticationProvider()
//        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder())
//        daoAuthenticationProvider.setUserDetailsService(SecUserService(userRepository))
//
//        return daoAuthenticationProvider
//    }
}