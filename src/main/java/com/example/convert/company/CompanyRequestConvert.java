package com.example.convert.company;

import com.example.dto.request.CompanyRequest;
import com.example.models.entities.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyRequestConvert {

    public Company create(CompanyRequest companyRequest) {
        if (companyRequest == null) {
            return null;
        }
        Company company = new Company();
        company.setCompanyName(companyRequest.getCompanyName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());
        return company;
    }

    public void update(Company company, CompanyRequest companyRequest) {
        company.setCompanyName(companyRequest.getCompanyName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());
    }
}
