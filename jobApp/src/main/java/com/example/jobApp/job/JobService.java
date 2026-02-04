package com.example.jobApp.job;

import java.util.List;

public interface JobService {

    List<Job> findAll();
    void createJob(Job job);
    Job getJobById(Long jobid);

    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Job updatedJob);
}
