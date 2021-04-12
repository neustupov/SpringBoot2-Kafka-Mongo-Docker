package org.neustupov.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@JsonPropertyOrder({
    "location",
    "current"
})
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Weather implements Serializable {

  final static long serialVersionUID = 155396808067640800L;

  @JsonProperty("location")
  Location location;
  @JsonProperty("current")
  Current current;
}
