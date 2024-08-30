package com.krishna.banda.delegate.service;

import com.krishna.banda.EmployeeData;
import com.krishna.banda.util.DataFetchersDelegateQuery;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class QueryService implements DataFetchersDelegateQuery {

    @Override
    /*
     * @DataFetchingEnvironment contains all Metadata related to each Request
     *
     */
    public EmployeeData getEmployee(DataFetchingEnvironment dataFetchingEnvironment, String employeeId) {
        log.info("This is Entry Point");
        log.info("Execution Id for the given request " + dataFetchingEnvironment.getExecutionId().toString());

        return EmployeeData.builder()
                .withEmployeeId(employeeId)
                .withFirst_name("Sample First Name")
                .withLast_name("Sample Last Name")
                .build();
    }
}
