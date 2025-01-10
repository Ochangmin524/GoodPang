package GoodPang.goodPang.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class QueryDSLConfig {
    private final EntityManager em;
    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        // JPAQueryFactory란 JPA의 엔터티를 이용하여 JPQLQuery를
        // 보다 쉽고 편리하게 작성할 수 있는 QueryDsl의 도구
        // 안에는 insert, delete 등의 메소드가 있다.
        return new JPAQueryFactory(em); //DI 외부 주입
    }
}