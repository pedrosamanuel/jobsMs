package com.manuel.company.company.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "review")
public interface ReviewClient {
    @GetMapping("/reviews/averageRating")
    Double getAverageRating(@RequestParam("companyId") Long companyId);
}
