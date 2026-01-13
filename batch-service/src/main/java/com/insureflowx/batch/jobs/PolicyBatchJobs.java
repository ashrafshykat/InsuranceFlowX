package com.insureflowx.batch.jobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PolicyBatchJobs {

    private static final Logger log = LoggerFactory.getLogger(PolicyBatchJobs.class);

    @Scheduled(cron = "0 0 1 * * ?") // 1 AM every day
    public void checkPolicyExpiry() {
        log.info("Starting Policy Expiry Check Job...");
        // Logic to call Policy Service and check for expiring policies
        log.info("Policy Expiry Check Job Completed.");
    }

    @Scheduled(cron = "0 0 2 * * ?") // 2 AM every day
    public void premiumReconciliation() {
        log.info("Starting Premium Reconciliation Job...");
        // Logic to reconcile payments vs policies
        log.info("Premium Reconciliation Job Completed.");
    }
}
