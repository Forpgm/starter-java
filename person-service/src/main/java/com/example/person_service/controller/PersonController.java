package com.example.person_service.controller;


import com.example.person_service.dto.request.CreatePersonRequest;
import com.example.person_service.dto.response.ApiResponse;
import com.example.person_service.dto.response.CreatePersonResponse;
import com.example.person_service.entity.Person;
import com.example.person_service.service.PersonService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PersonController {

    PersonService personService;

    @PostMapping
    public ApiResponse<CreatePersonResponse> createPerson(@Valid @RequestBody CreatePersonRequest request) {
        CreatePersonResponse response = personService.createPerson(request);
        return ApiResponse.<CreatePersonResponse>builder().code(HttpStatus.CREATED.value()).message("Create person " +
                "successffully").result(response).build();
    }

    @GetMapping("/tax-numbers/{taxNumber}")
    public ApiResponse<CreatePersonResponse> findPersonByTaxNumber(@Valid @PathVariable String taxNumber) {
        CreatePersonResponse response = personService.findByTaxNumber(taxNumber);
        return ApiResponse.<CreatePersonResponse>builder().code(HttpStatus.CREATED.value()).message("Find person by " +
                "tax number successfully").result(response).build();
    }
}
