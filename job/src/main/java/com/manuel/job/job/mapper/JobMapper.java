package com.manuel.job.job.mapper;

import com.manuel.job.job.Job;
import com.manuel.job.job.dto.JobDTO;
import com.manuel.job.job.external.Company;
import com.manuel.job.job.external.Review;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class JobMapper {
    public static JobDTO mapJobDto(
            Job job, Company company, List<Review> reviews){
        JobDTO jobDTO = new JobDTO();
        jobDTO.setId(job.getId());
        jobDTO.setTitle(job.getTitle());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setMinSalary(job.getMinSalary());
        jobDTO.setMaxSalary(job.getMaxSalary());
        jobDTO.setLocation(job.getLocation());
        jobDTO.setCompany(company);
        jobDTO.setReviews(reviews);
        return jobDTO;
    }
}
