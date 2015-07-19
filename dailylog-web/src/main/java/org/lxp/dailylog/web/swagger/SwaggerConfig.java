package org.lxp.dailylog.web.swagger;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.context.ServletContextAware;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.paths.RelativeSwaggerPathProvider;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

/**
 * @author Super.Li
 * @since Apr 16, 2015
 */
@Configuration
@EnableSwagger
public class SwaggerConfig implements ServletContextAware {
  private SpringSwaggerConfig springSwaggerConfig;
  private ServletContext servletContext;
  private String basePath;

  @Autowired
  public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
    this.springSwaggerConfig = springSwaggerConfig;
  }

  @Bean
  public SwaggerSpringMvcPlugin customImplementation() {
    RelativeSwaggerPathProvider swaggerPathProvider = new RelativeSwaggerPathProvider(this.servletContext);
    if (!StringUtils.isEmpty(basePath)) {
      swaggerPathProvider.setApiResourcePrefix(basePath);
    }
    return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(apiInfo()).includePatterns(".*?")
        .pathProvider(swaggerPathProvider).swaggerGroup(this.basePath);
  }

  private ApiInfo apiInfo() {
    ApiInfo apiInfo = new ApiInfo("Dailylog API Title", "Dailylog API Description", "Dailylog API terms of service",
        "Dailylog API Contact Email", "Dailylog API Licence Type", "Dailylog API License URL");
    return apiInfo;
  }

  @Override
  public void setServletContext(ServletContext servletContext) {
    this.servletContext = servletContext;
  }

  public void setBasePath(String basePath) {
    this.basePath = basePath;
  }
}
