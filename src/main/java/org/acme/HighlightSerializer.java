package org.acme;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import javax.inject.Singleton;

@Singleton
public class HighlightSerializer extends StdSerializer<Highlight> {

  public HighlightSerializer() {
    this(null);
    System.out.println("constuctor");
  }

  public HighlightSerializer(Class<Highlight> t) {
    super(t);
    System.out.println("constuctor");
  }

  // not invoked
  // https://stackoverflow.com/questions/76228719/jackson-serializer-not-invoked-in-quarkus
  @Override
  public void serialize(Highlight value, JsonGenerator jsonGenerator, SerializerProvider provider)
      throws IOException {
    System.out.println("serialize");
    jsonGenerator.writeStartObject();
    jsonGenerator.writeStringField("foo_bar", "fooobar");
    jsonGenerator.writeStringField("niklas", "niklas");
  }
}