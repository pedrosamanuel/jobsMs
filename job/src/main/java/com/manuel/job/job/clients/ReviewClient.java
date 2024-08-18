package com.manuel.job.job.clients;

import com.manuel.job.job.external.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "review")
public interface ReviewClient {
    @GetMapping("/reviews")
    ResponseEntity<List<Review>> getReviews(@RequestParam("companyId") Long companyId);
}
