package com.manuel.job.job;

import com.manuel.job.job.dto.JobDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController  {
    @Autowired
    private JobService jobService;

    @GetMapping
    public ResponseEntity<List<JobDTO>> findAllJobs(){
        List<JobDTO> jobs = jobService.getAllJobs();
        return new ResponseEntity<>(jobs,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> findJobById(@PathVariable Long id){
        JobDTO jobDTO = jobService.getJobById(id);
        if (jobDTO != null) {
            return new ResponseEntity<>(jobDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.addJob(job);
        return new ResponseEntity<>("Job added successfully",HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        Boolean isJobDeleted = jobService.deleteJob(id);
        if(isJobDeleted) {
            return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id,@RequestBody Job job){
        Boolean isJobUpdated = jobService.updateJob(id,job);
        if(isJobUpdated) {
            return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
