package hu.uni.eku.afp2020_team4.controller;

import hu.uni.eku.afp2020_team4.controller.dto.ComplexNumberDto;
import hu.uni.eku.afp2020_team4.controller.dto.ComplexNumberRecordRequestDto;
import hu.uni.eku.afp2020_team4.model.ComplexNumber;
import hu.uni.eku.afp2020_team4.service.ComplexNumberService;
import hu.uni.eku.afp2020_team4.service.exceptions.ComplexNumberAlreadyExistsException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/complex-number")
@RequiredArgsConstructor
@Api(tags = "Complex Numbers")
@Slf4j
public class ComplexNumberController {

    private final ComplexNumberService service;

    @PostMapping("/record")
    @ApiOperation(value = "Record")
    public void record(
            @RequestBody
            ComplexNumberRecordRequestDto request
    ){
        log.info("Recording of Complex Number ({},{})",request.getReal(),request.getImag());
        try {
            service.record(new ComplexNumber(request.getReal(),request.getImag()));
        } catch (ComplexNumberAlreadyExistsException e) {
            log.info("Complex number ({},{}) is already exists! Message: {}", request.getReal(),request.getImag(), e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    e.getMessage()
            );
        }
    }

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value= "Query Complex Numbers")
    public Collection<ComplexNumberDto> query(){
        return service.readAll().stream().map(model ->
                ComplexNumberDto.builder()
                .real(model.getReal())
                .imaginary(model.getImaginary())
                .build()
        ).collect(Collectors.toList());
    }

}
