package com.example.banson5s.BanHang.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ProvinceResponse {
    private List<Province> data;

    @Override
    public String toString() {
        return "ProvinceResponse{" +
                "data=" + data +
                '}';
    }
}

