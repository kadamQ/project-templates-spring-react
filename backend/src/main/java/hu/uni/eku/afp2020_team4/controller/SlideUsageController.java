package hu.uni.eku.afp2020_team4.controller;

import hu.uni.eku.afp2020_team4.controller.dto.SlideUsageCreateRequestDto;
import hu.uni.eku.afp2020_team4.controller.dto.SlideUsageDto;
import hu.uni.eku.afp2020_team4.model.SlideUsage;
import hu.uni.eku.afp2020_team4.service.SlideUsageService;
import hu.uni.eku.afp2020_team4.service.exceptions.SlideUsageNotFoundException;
import hu.uni.eku.afp2020_team4.service.exceptions.SlideUsageAlreadyExistsException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.aspectj.bridge.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/slideUsage")
@RequiredArgsConstructor
@Api(tags = "SlideUsage")
@Slf4j
public class SlideUsageController {

    private final SlideUsageService slideUsageService;

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "Fetch all slide usages")
    public Collection<SlideUsageDto> fetchAll() {
        return slideUsageService.fetchAll().stream().map(slideUsage ->
                SlideUsageDto.builder()
                .usageId(slideUsage.getUsageId())
                .userId(slideUsage.getUserId())
                .slideId(slideUsage.getSlideId())
                .timestamp(slideUsage.getTimestamp())
                .build()
        ).collect(Collectors.toList());
    }

    @PostMapping(value = {"/create"})
    @ApiOperation(value = "Create new slide usage")
    public void create(@RequestBody SlideUsageCreateRequestDto request) {
        try{
            slideUsageService.create(new SlideUsage(request.getUsageId(), request.getGuestId(), request.getSlideId(), request.getTimestamp()));
        }
        catch (SlideUsageAlreadyExistsException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @PutMapping(value = {"/{id}"})
    @ApiOperation(value = "Update a slide usage")
    public void update(@PathVariable Integer usageId, @RequestBody SlideUsageCreateRequestDto request) {
        try {
            slideUsageService.update(usageId, new SlideUsage(request.getUsageId(), request.getGuestId(), request.getSlideId(), request.getTimestamp()));
        }
        catch(SlideUsageNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping(value = {"/{id}"})
    @ApiOperation(value = "Delete a slide usage")
    public void delete(@PathVariable Integer usageId) {
        try{
            slideUsageService.delete(usageId);
        }
        catch (SlideUsageNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }
}
