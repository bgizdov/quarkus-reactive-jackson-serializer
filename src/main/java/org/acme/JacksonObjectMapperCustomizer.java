package org.acme;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import io.quarkus.jackson.ObjectMapperCustomizer;
import javax.inject.Singleton;

@Singleton
public class JacksonObjectMapperCustomizer implements ObjectMapperCustomizer {

  public void customize(ObjectMapper objectMapper) {
    objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
    objectMapper.disable(SerializationFeature.WRITE_ENUMS_USING_INDEX);

    System.out.println("customize");
    SimpleModule module = new SimpleModule();
    module.addSerializer(Highlight.class, new HighlightSerializer());
    objectMapper.registerModule(module);
  }
}
