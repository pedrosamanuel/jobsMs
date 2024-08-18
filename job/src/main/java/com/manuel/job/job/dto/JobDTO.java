package com.manuel.job.job.dto;

import com.manuel.job.job.external.Company;
import com.manuel.job.job.external.Review;
import lombok.Data;

import java.util.List;

@Data
public class JobDTO {
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;
    private Company company;
    private List<Review> reviews;
}
