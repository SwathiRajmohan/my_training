package com.model;

import com.enums.ApplicationStatus;
import jakarta.persistence.*;

@Entity
public class Applications extends BaseClass{

    @Enumerated(EnumType.STRING)
    private ApplicationStatus appStatus;

    @ManyToOne
    private Jobs jobs;

    public ApplicationStatus getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(ApplicationStatus appStatus) {
        this.appStatus = appStatus;
    }

    public Jobs getJobs() {
        return jobs;
    }

    public void setJobs(Jobs jobs) {
        this.jobs = jobs;
    }
}
