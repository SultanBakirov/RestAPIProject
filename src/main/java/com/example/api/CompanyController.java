package com.example.api;

import com.example.dto.request.CompanyRequest;
import com.example.dto.response.CompanyResponse;
import com.example.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("/save")
    public CompanyResponse saveCompany(@RequestBody CompanyRequest companyRequest) {
        return companyService.saveCompany(companyRequest);
    }

    @GetMapping("/getAll")
    public List<CompanyResponse> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/{companyId}")
    public CompanyResponse getCompanyById(@PathVariable Long companyId) {
        return companyService.getCompanyById(companyId);
    }

//    @PatchMapping or
    @PutMapping("/{companyId}")
    public CompanyResponse updateCompany(@RequestBody CompanyRequest companyRequest, @PathVariable Long companyId) {
        return companyService.updateCompany(companyId, companyRequest);
    }

    @DeleteMapping("/{companyId}")
    public CompanyResponse deleteCompanyById(@PathVariable Long companyId) {
        return companyService.deleteCompanyById(companyId);
    }
}
