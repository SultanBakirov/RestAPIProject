package com.example.services.impls;

import com.example.convert.company.CompanyRequestConvert;
import com.example.convert.company.CompanyResponseConvert;
import com.example.dto.request.CompanyRequest;
import com.example.dto.response.CompanyResponse;
import com.example.models.entities.Company;
import com.example.repositories.CompanyRepository;
import com.example.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyRequestConvert companyRequestConvert;
    private final CompanyResponseConvert companyResponseConvert;


    @Override
    public CompanyResponse saveCompany(CompanyRequest companyRequest) {
        Company company = companyRequestConvert.create(companyRequest);
        companyRepository.save(company);
        return companyResponseConvert.viewCompany(company);
    }

    @Override
    public List<CompanyResponse> getAllCompanies() {
        return companyResponseConvert.getAllCompanies(companyRepository.findAll());
    }

    @Override
    public CompanyResponse getCompanyById(Long companyId) {
        Company company = companyRepository.findById(companyId).get();
        return companyResponseConvert.viewCompany(company);
    }

    @Override
    public CompanyResponse deleteCompanyById(Long companyId) {
        Company company = companyRepository.findById(companyId).get();
        companyRepository.delete(company);
        return companyResponseConvert.viewCompany(company);
    }

    @Override
    public CompanyResponse updateCompany(Long companyId, CompanyRequest companyRequest) {
        Company company = companyRepository.findById(companyId).get();
        companyRequestConvert.update(company, companyRequest);
        return companyResponseConvert.viewCompany(companyRepository.save(company));
    }
}
