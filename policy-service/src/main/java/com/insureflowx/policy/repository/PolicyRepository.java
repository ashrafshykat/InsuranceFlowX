package com.insureflowx.policy.repository;

import com.insureflowx.policy.domain.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, UUID> {
    boolean existsByPolicyNumber(String policyNumber);
}
