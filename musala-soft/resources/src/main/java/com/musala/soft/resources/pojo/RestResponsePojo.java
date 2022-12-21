package com.musala.soft.resources.pojo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class RestResponsePojo<T> {
    String message;
    Boolean success = true;
    T data;
    Integer status = 200;
}
