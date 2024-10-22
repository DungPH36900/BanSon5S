package com.example.banson5s.BanHang.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class District {
    @JsonProperty("DistrictID") // Đảm bảo rằng tên khớp với JSON
    private int districtID;

    @JsonProperty("DistrictName") // Đảm bảo rằng tên khớp với JSON
    private String districtName;

    @Override
    public String toString() {
        return "District{" +
                "districtID=" + districtID +
                ", districtName='" + districtName + '\'' +
                '}';
    }
}
