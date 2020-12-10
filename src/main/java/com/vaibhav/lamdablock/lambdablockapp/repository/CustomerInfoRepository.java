package com.vaibhav.lamdablock.lambdablockapp.repository;

import com.vaibhav.lamdablock.lambdablockapp.Entity.CustomerInfo;
import org.springframework.data.repository.CrudRepository;

public interface CustomerInfoRepository extends CrudRepository<CustomerInfo, Long> {
}
