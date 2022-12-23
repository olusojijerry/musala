package com.musala.soft.scheduler.Wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestResponseWrapper<T> {
    @JsonProperty(value = "data")
    T data;
    @JsonProperty(value = "message")
    String message;
    @JsonProperty(value = "success")
    Boolean success;
}
