package com.krishna.banda.service;

import com.krishna.banda.EmployeeData;
import com.krishna.banda.util.DataFetchersDelegateQuery;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class QueryService implements DataFetchersDelegateQuery {
    @Override
    public EmployeeData getEmployeeData(DataFetchingEnvironment dataFetchingEnvironment, String employeeId) {
        log.info("This is Entry Point");
        log.info("Execution Id for the given request " + dataFetchingEnvironment.getExecutionId().toString());
        dataFetchingEnvironment.getGraphQlContext().put("employeeId",employeeId);
        log.info("This is Last Point");
        return EmployeeData.builder().build();
    }
}
