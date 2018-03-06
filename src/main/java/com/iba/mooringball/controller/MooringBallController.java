package com.iba.mooringball.controller;

import com.iba.mooringball.entity.MooringBall;
import com.iba.mooringball.resourceSupport.MooringBallResource;
import com.iba.mooringball.service.MooringBallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;


@RestController
@RequestMapping(value = "mooringballs", produces = "application/hal+json")
public class MooringBallController {
    @Autowired
    MooringBallService service;

    @GetMapping
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
    public MooringBallResource getMooringBall(@PathVariable Long id){
        return new MooringBallResource(service.getMooringBallById(id));
    }

    @PostMapping
    public MooringBallResource addMooringBall(@RequestBody MooringBall ball){
        service.addMooringBall(ball);
        return new MooringBallResource(service.getMooringBallById(ball.getBallId()));
    }

    @PutMapping(value = "/{id}")
    public MooringBallResource updateMooringBall(@RequestBody MooringBall ball, @PathVariable Long id){
       ball.setBallId(id);
       service.updateMooringBall(ball);
       return new MooringBallResource(service.getMooringBallById(ball.getBallId()));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBooringBallById(@PathVariable Long id){
        service.deleteMooringBall(id);
    }
}
