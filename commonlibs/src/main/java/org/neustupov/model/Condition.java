package org.neustupov.model;

import java.io.Serializable;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
class Condition implements Serializable {

  final static long serialVersionUID = -4311977195409334735L;
}
