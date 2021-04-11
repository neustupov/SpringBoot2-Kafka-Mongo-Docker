package org.neustupov.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@JsonPropertyOrder({
    "last_updated",
    "temp_c",
    "is_day",
    "condition",
    "wind_kph",
    "humidity",
    "cloud",
    "uv"
})
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
class Current implements Serializable {

  final static long serialVersionUID = -1369229600781257505L;

  @JsonProperty("last_updated")
  String lastUpdated;
  @JsonProperty("temp_c")
  Double tempC;
  @JsonProperty("is_day")
  Long isDay;
  @JsonProperty("condition")
  Condition condition;
  @JsonProperty("wind_kph")
  Double windKph;
  @JsonProperty("humidity")
  Long humidity;
  @JsonProperty("cloud")
  Long cloud;
  @JsonProperty("uv")
  Double uv;
}
