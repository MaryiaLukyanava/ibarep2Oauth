package com.iba.mooringball.resourceSupport;

import com.iba.mooringball.controller.MooringBallController;
import com.iba.mooringball.entity.MooringBall;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@Getter
public class MooringBallResource extends ResourceSupport {

    private final MooringBall mooringBall;

    public MooringBallResource(final MooringBall mooringBall) {
        this.mooringBall = mooringBall;
        final long id = mooringBall.getBallId();
        add(linkTo(MooringBallController.class).withRel("mooringballs"));
        add(linkTo(methodOn(MooringBallController.class).getMooringBall(id)).withSelfRel());
    }
}