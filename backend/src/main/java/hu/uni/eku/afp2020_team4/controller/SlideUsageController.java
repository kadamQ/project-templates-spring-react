package hu.uni.eku.afp2020_team4.controller;

import hu.uni.eku.afp2020_team4.controller.dto.SlideUsageCreateRequestDto;
import hu.uni.eku.afp2020_team4.controller.dto.SlideUsageDto;
import hu.uni.eku.afp2020_team4.controller.dto.SlideCreateRequestDto;
import hu.uni.eku.afp2020_team4.controller.dto.SlideDto;
import hu.uni.eku.afp2020_team4.controller.dto.WatchDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/slideUsage")
@RequiredArgsConstructor
@Api(tags = "SlideUsage")
public class SlideUsageController {

    private Collection<SlideUsageDto> slideUsages = new ArrayList<>();

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "Fetch all slide usages")
    public Collection<SlideUsageDto> fetchAll() {
        return slideUsages.stream().map(slideUsage ->
                SlideUsageDto.builder()
                        .id(slideUsage.GetId)
                        .userId(slideUsage.getUserId())
                        .slideId(slideUsage.getSlideId())
                        .timestamp(slideUsage.getTimeStamp())
                        .build()
        ).collect(Collectors.toList());
    }

    @GetMapping(value = {"/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "Fetch slide usage by ID")
    public SlideUsageDto fetchById(@PathVariable String id) {
        for(SlideUsageDto slideUsage: slideUsages) {
            if(slideUsage.getSlideUsageId().equals(id)) {
                return SlideUsageDto.builder()
                        .id(slideUsage.GetId)
                        .userId(slideUsage.getUserId())
                        .slideId(slideUsage.getSlideId())
                        .timestamp(slideUsage.getTimeStamp())
                        .build();
            }
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No slide usage found by the given ID!");
    }

    @PostMapping(value = {"/create"})
    @ApiOperation(value = "Create new slide usage")
    public void create(@RequestBody SlideUsageCreateRequestDto request) {
        SlideUsageDto newSlideUsage = SlideUsageDto.builder()
                .id(UUID.randomUUID().toString())
                .userId(request.getUserId())
                .slideId(request.getSlideId())
                .build();
        slideUsages.add(newSlideUsage);
    }

    @PutMapping(value = {"/{id}"})
    @ApiOperation(value = "Update a slide usage")
    public void update(@PathVariable String id, @RequestBody SlideUsageCreateRequestDto request) {
        slideUsages = slideUsages.stream().map(
                slideUsage -> slideUsage.getId().equals(id)
                        ? SlideUsageDto.builder()
                        .id(id)
                        .userId(request.getUserId())
                        .slideId(request.getSlideId())
                        .timestamp(request.getTimeStamp())
                        .build()
                        : slideUsage
        ).collect(Collectors.toList());
    }

    @DeleteMapping(value = {"/{id}"})
    @ApiOperation(value = "Delete a slide usage")
    public void delete(@PathVariable String id) {
        slideUsages.removeIf(slideUsage -> slideUsage.getUsageId().equals(id));
    }
}
