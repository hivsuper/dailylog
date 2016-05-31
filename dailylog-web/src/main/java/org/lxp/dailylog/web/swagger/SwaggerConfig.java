package org.lxp.dailylog.web.swagger;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Super.Li
 * @since May 31, 2016
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket swaggerSpringfoxDocket() {
    StopWatch watch = new StopWatch();
    watch.start();
    Docket swaggerSpringMvcPlugin = new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
        .genericModelSubstitutes(ResponseEntity.class).select().paths(regex(".*?")).build();
    watch.stop();
    return swaggerSpringMvcPlugin;
  }

  private ApiInfo apiInfo() {
    ApiInfo apiInfo = new ApiInfo("dailylog API Title", "dailylog API Description",
        "dailylog API terms of service", "dailylog API Contact Email", "dailylog API Licence Type",
        "dailylog API License", "dailylog API License URL");
    return apiInfo;
  }
}