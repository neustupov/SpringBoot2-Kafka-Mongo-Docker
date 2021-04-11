package org.neustupov.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@JsonPropertyOrder({
    "name",
    "region",
    "country",
    "lat",
    "lon",
    "tz_id",
    "localtime_epoch",
    "localtime"
})
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
class Location implements Serializable {

  final static long serialVersionUID = 7496234439900039534L;

  @JsonProperty("name")
  String name;
  @JsonProperty("region")
  String region;
  @JsonProperty("country")
  String country;
  @JsonProperty("lat")
  Double lat;
  @JsonProperty("lon")
  Double lon;
  @JsonProperty("tz_id")
  String tzId;
  @JsonProperty("localtime_epoch")
  Long localtimeEpoch;
  @JsonProperty("localtime")
  String localtime;
}
