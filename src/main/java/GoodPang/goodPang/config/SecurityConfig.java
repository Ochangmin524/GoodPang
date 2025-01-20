package GoodPang.goodPang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity//시큐리티 설정을 활성화한다. 우리가 작성한 설정이 기본 설정보다 우선 적용되게 한다.
@Configuration //설정 정보 명시 에노테이션
public class SecurityConfig {

//필터 체인을 정의하는 메소드
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //authorizeHttpRequest는 HTTP 요청에 대한 접근 제어를 설정
        http.authorizeHttpRequests(requests -> requests
                //permitAll에 있는 곳은 항상 접근을 허용
                .requestMatchers("/","/home/", "/login","/signup/**","/members/signup", "/css/**","/js/**","/fragments/**","https://getbootstrap.com/docs/**").permitAll()
                //hasRole은 해당 역할을 가진 사용자만 접근이 가능
                .requestMatchers("/admin/**").hasRole("ADMIN")
                //authenticated은 인증된 사용자만 접근 가능
                .anyRequest().authenticated()
        )
        // 폼 기반 로그인 설정
        .formLogin((form) -> form
                .loginPage("/login") //커스텀 로그인 페이지를 /login 경로로 설정
                .defaultSuccessUrl("/loginHome", true) //성공하면 home으로 리다이렉트
                .permitAll() //모든 요청에 대해서 접근 허용
        )
        //로그아웃 처리
        .logout(logout -> logout
                .logoutUrl("/logout") //로그아웃 페이지를 /logout 경로로 설정
                .logoutSuccessUrl("/login?logout") //로그아웃 성공시 /login?logout으로 리다이렉트
                .permitAll()
        );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        //Bcrypt..는 스프링 시큐리티가 제공하는 클래스로, 비밀번호를 암호화하는데 사용한다.
        //입력을 해시화 하고 솔트를 부여한다.
        return new BCryptPasswordEncoder();
    }


}
