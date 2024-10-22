package com.example.banson5s.BanHang.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ward {
    @JsonProperty("WardCode")
    private int wardCode;
    @JsonProperty("WardName")
    private String wardName;

    @Override
    public String toString() {
        return "Ward{" +
                "wardCode=" + wardCode +
                ", wardName='" + wardName + '\'' +
                '}';
    }
// Getters và setters
}
