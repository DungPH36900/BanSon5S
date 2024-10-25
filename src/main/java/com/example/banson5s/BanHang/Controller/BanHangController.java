package com.example.banson5s.BanHang.Controller;

import com.example.banson5s.BanHang.DTO.District;
import com.example.banson5s.BanHang.DTO.DistrictResponse;
import com.example.banson5s.BanHang.DTO.Province;
import com.example.banson5s.BanHang.DTO.ProvinceResponse;
import com.example.banson5s.BanHang.DTO.Ward;
import com.example.banson5s.BanHang.DTO.WardResponse;
import com.example.banson5s.SanPham.Repositorty.SanPhamRepositorty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
public class BanHangController {
    private static final String GHN_API_URL = "https://online-gateway.ghn.vn/shiip/public-api/master-data";

    @Value("${ghn.api.token}")
    private String apiToken;

    private final RestTemplate restTemplate;
    public BanHangController() {
        this.restTemplate = new RestTemplate();;
    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Token", apiToken);
        return headers;
    }
    @Autowired
    private SanPhamRepositorty spRepo;
    @GetMapping("/ban-hang")
    private String banHangView(Model model ){
        HttpEntity<String> entity = new HttpEntity<>(createHeaders());

        try {
            ResponseEntity<ProvinceResponse> provincesResponse = restTemplate.exchange(
                    GHN_API_URL + "/province", HttpMethod.POST, entity, ProvinceResponse.class);

            if (provincesResponse.getStatusCode() == HttpStatus.OK) {
                List<Province> provinces = provincesResponse.getBody().getData();
                model.addAttribute("provinces", provinces);
                System.out.println("Provinces size: " + provinces.size());
                System.out.println("Provinces: " + provinces);
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Không thể lấy danh sách tỉnh/thành phố.");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Lỗi khi lấy danh sách tỉnh/thành phố.", e);
        }

        model.addAttribute("sp",spRepo.findAll());
        return "BanHang/banHang";
    }
    @GetMapping("/pt-thanh-toan")
    public String showPaymentPage(Model model) {
        // Thêm dữ liệu cần thiết vào model nếu cần thiết
        return "payment";  // Trả về trang payment.jsp
    }













    @PostMapping("/districts")
    public ResponseEntity<DistrictResponse> getDistricts(@RequestParam("provinceId") int provinceId) {
        if (provinceId <= 0) {
            return ResponseEntity.badRequest().body(null);
        }
//
        HttpHeaders headers = createHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON); // Thiết lập Content-Type
//
//        // Tạo JSON payload
        String jsonPayload = String.format("{\"province_id\":%d}", provinceId);
        HttpEntity<String> entity = new HttpEntity<>(jsonPayload, headers);

        try {
            ResponseEntity<DistrictResponse> districtsResponse = restTemplate.exchange(
                    GHN_API_URL + "/district", HttpMethod.POST, entity, DistrictResponse.class);

            if (districtsResponse.getStatusCode() == HttpStatus.OK) {
                List<District> huyen = districtsResponse.getBody().getData();
                System.out.println("huyen size: " + huyen.size());
                System.out.println("huyen: " + huyen);
                return ResponseEntity.ok(districtsResponse.getBody());
            } else {
                return ResponseEntity.status(districtsResponse.getStatusCode()).body(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }



    @PostMapping("/wards")
    public ResponseEntity<WardResponse> getWards(@RequestParam("districtId") int districtId) {
        if (districtId <= 0) {
            return ResponseEntity.badRequest().body(null);
        }

        HttpEntity<String> entity = new HttpEntity<>(createHeaders());

        try {
            ResponseEntity<WardResponse> wardsResponse = restTemplate.exchange(
                    GHN_API_URL + "/ward?district_id=" + districtId, HttpMethod.GET, entity, WardResponse.class);

            if (wardsResponse.getStatusCode() == HttpStatus.OK) {
                List<Ward> xa = wardsResponse.getBody().getData();
                System.out.println("xa size: " + xa.size());
                System.out.println("xa: " + xa);
                return ResponseEntity.ok(wardsResponse.getBody());
            } else {
                // Trả về mã trạng thái tương ứng nếu không thành công
                return ResponseEntity.status(wardsResponse.getStatusCode()).body(null);
            }
        } catch (Exception e) {
            // Log lỗi nếu cần
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
