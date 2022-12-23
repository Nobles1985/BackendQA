package org.example.lesson4.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "item",
    "aisle",
    "parse"
})
public class AddRequest {
    @JsonProperty("item")
    @Getter
    private String item;
    @JsonProperty("aisle")
    @Getter
    private String aisle;
    @JsonProperty("parse")
    @Getter
    private Boolean parse;

    public AddRequest(String item, String aisle, Boolean parse){
        this.item = item;
        this.aisle = aisle;
        this.parse = parse;
    }
}