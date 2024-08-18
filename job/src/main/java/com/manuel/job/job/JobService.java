package com.manuel.job.job;

import com.manuel.job.job.clients.CompanyClient;
import com.manuel.job.job.clients.ReviewClient;
import com.manuel.job.job.dto.JobDTO;
import com.manuel.job.job.external.Company;
import com.manuel.job.job.external.Review;
import com.manuel.job.job.mapper.JobMapper;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobService {
    JobRepository jobRepository;
    @Autowired
    CompanyClient companyClient;
    @Autowired
    ReviewClient reviewClient;

    public JobService(JobRepository jobRepository){
        this.jobRepository=jobRepository;
    }

    @CircuitBreaker(name = "companyBreaker")
    public List<JobDTO> getAllJobs() {
        List<Job> jobs = jobRepository.findAll();
        return jobs.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public JobDTO getJobById(Long id){
        Job job = jobRepository.findById(id).orElse(null);
        JobDTO jobDTO;
        try{
            jobDTO = convertToDto(job);
        } catch (Exception e){
            return null;
        }
        return jobDTO;
    }

    public void addJob(Job job) {
        jobRepository.save(job);
    }

    public Boolean deleteJob(Long id) {
        boolean exist = jobRepository.existsById(id);
        if (exist){
            jobRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Boolean updateJob(Long id,Job jobUpdated) {
        Optional<Job> optionalJob = jobRepository.findById(id);
        if(optionalJob.isPresent()){
            Job job = optionalJob.get();
            job.setTitle(jobUpdated.getTitle());
            job.setDescription(jobUpdated.getDescription());
            job.setMinSalary(jobUpdated.getMinSalary());
            job.setMaxSalary(jobUpdated.getMaxSalary());
            job.setLocation(jobUpdated.getLocation());
            job.setCompanyId(jobUpdated.getCompanyId());
            jobRepository.save(job);
            return true;
        }
        return false;
    }
    public JobDTO convertToDto(Job job){
        if(job != null){
            Company company = companyClient.getCompany(job.getCompanyId());

            ResponseEntity<List<Review>> reviewResponse =
                    reviewClient.getReviews(job.getCompanyId());
            List<Review> reviews = reviewResponse.getBody();

            return JobMapper.mapJobDto(job,company,reviews);
        }
        return null;
    }
}
