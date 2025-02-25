package GoodPang.goodPang.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //설정 정보 명시 에노테이션

public class SwaggerConfig {

    @Bean
    public OpenAPI GOODPANGAPI() {

        Info info = new Info()
                .title("GOODPANG API")
                .description("GOODPANG Server API 명세서")
                .version("1.0.0");

        String jwtSchemeName = "JWT TOKEN";
        String csrfSchemeName = "CSRF TOKEN";
        //API 요청 헤더에 인증정보 포함
        SecurityRequirement securityRequirement = new SecurityRequirement()
                .addList(jwtSchemeName)
                .addList(csrfSchemeName);;
        //SecuritySchemes 등록
        Components components = new Components()
                .addSecuritySchemes(jwtSchemeName, new SecurityScheme()
                        .name(jwtSchemeName)
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT"))
                .addSecuritySchemes(csrfSchemeName, new SecurityScheme()
                        .name(csrfSchemeName)
                        .type(SecurityScheme.Type.APIKEY)
                        .in(SecurityScheme.In.HEADER)
                        .name("X-CSRF-Token"));

        return new OpenAPI()
                .addServersItem(new Server().url("/"))
                .info(info)
                .addSecurityItem(securityRequirement)
                .components(components);
    }
}
