package com.krishna.banda.service;

import com.krishna.banda.Address;
import com.krishna.banda.EmployeeAddress;
import com.krishna.banda.util.DataFetchersDelegateEmployeeAddress;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Slf4j
public class EmplyeeAddressService implements DataFetchersDelegateEmployeeAddress {
    @Override
    public List<Address> addresses(DataFetchingEnvironment dataFetchingEnvironment, EmployeeAddress origin) {
        log.info("Start Fetching Address");
        Address address1 = Address.builder()
                .withAddress_line_1("Sample Address Line1")
                .withAddress_line_2("Sample Address Line1")
                .withState("Sample State")
                .withPostal_code("Sample Postal Code")
                .withCountry("Sample Country")
                .build();
        Address address2 = Address.builder()
                .withAddress_line_1("Sample Address Line2")
                .withAddress_line_2("Sample Address Line2")
                .withState("Sample State")
                .withPostal_code("Sample Postal Code")
                .withCountry("Sample Country")
                .build();
        log.info("End Fetching Address");
        return List.of(address1,address2);
    }
}
