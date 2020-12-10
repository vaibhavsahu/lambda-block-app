package com.vaibhav.lamdablock.lambdablockapp.repository;

import com.vaibhav.lamdablock.lambdablockapp.model.CustomerInfo;
import org.springframework.data.repository.CrudRepository;

public interface CustomerInfoRepository extends CrudRepository<CustomerInfo, Long> {
}
