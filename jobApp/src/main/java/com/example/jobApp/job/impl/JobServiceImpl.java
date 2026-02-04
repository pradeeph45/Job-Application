package com.example.jobApp.job.impl;

import com.example.jobApp.job.Job;
import com.example.jobApp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private List<Job> jobs = new ArrayList<>();
    private long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
       jobs.add(job);
    }

    @Override
    public Job getJobById(Long jobid) {
        for(Job job:jobs){
            if(job.getId() == jobid){
                return job;
            }
        }
       return null;
    }

    @Override
    public boolean deleteJobById(Long id) {
        for(Job job:jobs){
            if(job.getId() == id){
                jobs.remove(job);
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        for(Job job:jobs){
            if(job.getId() == id){
                job.setDescription(updatedJob.getDescription());
                job.setTitle(updatedJob.getTitle());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                return true;

            }
        }
        return false;
    }
}
