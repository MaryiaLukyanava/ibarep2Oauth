package com.iba.mooringball.controller;

import com.iba.mooringball.entity.MooringBall;
import com.iba.mooringball.resourceSupport.MooringBallResource;
import com.iba.mooringball.service.MooringBallService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;



@RestController
@RequestMapping(value = "mooringballs", produces = "application/hal+json")
@Api(value="mooringballs", description="Operations pertaining to mooring balls")
public class MooringBallController {
    @Autowired
    MooringBallService service;

    @GetMapping
    @ApiOperation(value = "View a list of available mooring balls", response = Resources.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    public Resources<MooringBallResource> getMooringBalls(){
        List<MooringBallResource> list = service.getMooringBalls()
                .stream()
                .map(MooringBallResource::new)
                .collect(Collectors.toList());
        final Resources<MooringBallResource> resources = new Resources<>(list);
        final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
        resources.add(new Link(uriString, "self"));
        return resources;
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Search a mooring ball with an ID",response = MooringBallResource.class)
    public MooringBallResource getMooringBall(@PathVariable Long id){
        return new MooringBallResource(service.getMooringBallById(id));
    }

    @PostMapping
    @ApiOperation(value = "Add a mooring ball",response = MooringBallResource.class)
    public MooringBallResource addMooringBall(@RequestBody MooringBall ball){
        service.addMooringBall(ball);
        return new MooringBallResource(service.getMooringBallById(ball.getBallId()));
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Update a mooring ball by ID",response = MooringBallResource.class)
    public MooringBallResource updateMooringBall(@RequestBody MooringBall ball, @PathVariable Long id){
       ball.setBallId(id);
       service.updateMooringBall(ball);
       return new MooringBallResource(service.getMooringBallById(ball.getBallId()));
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Delete a product")
    public void deleteBooringBallById(@PathVariable Long id){
        service.deleteMooringBall(id);
    }
}
