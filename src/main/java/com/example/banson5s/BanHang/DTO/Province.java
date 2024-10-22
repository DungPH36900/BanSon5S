package com.example.banson5s.BanHang.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Province {
    @JsonProperty("ProvinceID") // Đảm bảo tên khớp với JSON
    private int provinceID;

    @JsonProperty("ProvinceName") // Đảm bảo tên khớp với JSON
    private String provinceName;

    @Override
    public String toString() {
        return "Province{" +
                "provinceID=" + provinceID +
                ", provinceName='" + provinceName + '\'' +
                '}';
    }
}
