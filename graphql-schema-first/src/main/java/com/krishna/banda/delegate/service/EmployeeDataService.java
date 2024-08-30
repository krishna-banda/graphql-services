package com.krishna.banda.delegate.service;

import com.krishna.banda.EmployeeAddress;
import com.krishna.banda.EmployeeData;
import com.krishna.banda.util.DataFetchersDelegateEmployeeData;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeDataService implements DataFetchersDelegateEmployeeData {
    @Override
    public EmployeeAddress address(DataFetchingEnvironment dataFetchingEnvironment, EmployeeData origin) {
        //Find Address based on Employee Details
        log.info("This is Entry Point for Employee Address");
        //Observe the same Execution id
        log.info("Execution Id for the given request to understand the relation " + dataFetchingEnvironment.getExecutionId().toString());
        return EmployeeAddress.builder()
                .withAddress_line_1("Sample Address Line1")
                .withAddress_line_2("Sample Address Line1")
                .withState("Sample State")
                .withPostal_code("Sample Postal Code")
                .withCountry("Sample Country")
                .build();
    }
}
