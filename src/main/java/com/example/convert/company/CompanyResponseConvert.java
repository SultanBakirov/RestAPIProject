package com.example.convert.company;

import com.example.dto.response.CompanyResponse;
import com.example.models.entities.Company;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyResponseConvert {

    public CompanyResponse viewCompany(Company company) {
        if (company == null) {
            return null;
        }
        CompanyResponse companyResponse = new CompanyResponse();
        companyResponse.setId(company.getId());
        companyResponse.setCompanyName(company.getCompanyName());
        companyResponse.setLocatedCountry(company.getLocatedCountry());
        return companyResponse;
    }

    public List<CompanyResponse> getAllCompanies(List<Company> companies) {
        List<CompanyResponse> companyResponses = new ArrayList<>();
        for (Company company: companies) {
            companyResponses.add(viewCompany(company));
        }
        return companyResponses;
    }
}
