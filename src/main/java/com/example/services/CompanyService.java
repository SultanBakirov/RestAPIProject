package com.example.services;

import com.example.dto.request.CompanyRequest;
import com.example.dto.response.CompanyResponse;

import java.util.List;

public interface CompanyService {

    CompanyResponse saveCompany(CompanyRequest companyRequest);

    List<CompanyResponse> getAllCompanies();

    CompanyResponse getCompanyById(Long companyId);

    CompanyResponse deleteCompanyById(Long companyId);

    CompanyResponse updateCompany(Long companyId, CompanyRequest companyRequest);

}
