package com.iba.mooringball.controller;

import com.iba.mooringball.entity.MooringBall;
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
@RequestMapping(value = "mooringballs", produces = "application/json")
@Api(value="mooringballs", description="Operations pertaining to mooring balls")
public class MooringBallController {
    @Autowired
    MooringBallService service;

    @GetMapping
    @ApiOperation(value = "View a list of available mooring balls", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    public List<MooringBall> getMooringBalls(){
        return service.getMooringBalls();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Search a mooring ball with an ID",response = MooringBall.class)
    public MooringBall getMooringBall(@PathVariable Long id){
        return service.getMooringBallById(id);
    }

    @PostMapping
    @ApiOperation(value = "Add a mooring ball",response = MooringBall.class)
    public MooringBall addMooringBall(@RequestBody MooringBall ball){
        return service.addMooringBall(ball);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Update a mooring ball by ID",response = MooringBall.class)
    public MooringBall updateMooringBall(@RequestBody MooringBall ball, @PathVariable Long id){
       ball.setBallId(id);
       return service.updateMooringBall(ball);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Delete a product")
    public void deleteBooringBallById(@PathVariable Long id){
        service.deleteMooringBall(id);
    }
}
