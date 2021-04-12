package org.neustupov.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "text",
        "icon",
        "code"
})
@FieldDefaults(level = AccessLevel.PRIVATE)
class Condition implements Serializable {

  final static long serialVersionUID = -4311977195409334735L;

  @JsonProperty("text")
  private String text;
  @JsonProperty("icon")
  private String icon;
  @JsonProperty("code")
  private Long code;
}
