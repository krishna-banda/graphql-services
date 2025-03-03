package com.krishna.banda.service;

import com.krishna.banda.EmployeeAddress;
import com.krishna.banda.EmployeeData;
import com.krishna.banda.EmployeeDetails;
import com.krishna.banda.util.DataFetchersDelegateEmployeeData;
import graphql.schema.DataFetchingEnvironment;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
@Service
@Slf4j
public class EmployeeDataService implements DataFetchersDelegateEmployeeData {
    @Autowired
    @Qualifier("executorService")
    ExecutorService executorService;

    @Override
    public CompletableFuture<?> employeeDetails(DataFetchingEnvironment dataFetchingEnvironment, EmployeeData origin) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return getEmployeeDetails(dataFetchingEnvironment);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },executorService);
    }

    private EmployeeDetails getEmployeeDetails(DataFetchingEnvironment dataFetchingEnvironment) throws InterruptedException {
        log.info("Start Fetching EmployeeDetails");
        Thread.sleep(5000);
        EmployeeDetails employeeDetails = EmployeeDetails.builder()
                .withEmployeeId(dataFetchingEnvironment.getGraphQlContext().get("employeeId"))
                .withFirst_name("MY First name")
                .withLast_name("My Last Name")
                .build();
        log.info("End Fetching EmployeeDetails");
        return employeeDetails;
    }

    @Override
    public CompletableFuture<?> employeeAddress(DataFetchingEnvironment dataFetchingEnvironment, EmployeeData origin) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return getEmployeeAddress(dataFetchingEnvironment);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },executorService);
    }

    public EmployeeAddress getEmployeeAddress(DataFetchingEnvironment dataFetchingEnvironment) throws InterruptedException {
        log.info("Start Fetching EmployeeAddress");
        Thread.sleep(1000);
        EmployeeAddress employeeAddress = EmployeeAddress.builder()
                .withEmployeeId(dataFetchingEnvironment.getGraphQlContext().get("employeeId"))
                .build();
        log.info("End Fetching EmployeeAddress");
        return employeeAddress;
    }

}
