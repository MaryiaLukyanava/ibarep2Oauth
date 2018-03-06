package com.iba.mooringball.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="mooring_ball")
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MooringBall{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(notes = "The database generated mooring ball's ID")
    private Long ballId;

    @Column(name = "latitude", nullable = false)
    @ApiModelProperty(notes = "Mooring ball's latitude")
    private double latitude;
    @Column(name = "longitude", nullable = false)
    @ApiModelProperty(notes = "Mooring ball's longitude")
    private double longitude;
}
