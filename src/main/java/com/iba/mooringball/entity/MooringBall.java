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
    private Long id;

    @Column(name = "latitude", nullable = false)
    @ApiModelProperty(notes = "Mooring ball's latitude")
    private double latitude;

    @Column(name = "longitude", nullable = false)
    @ApiModelProperty(notes = "Mooring ball's longitude")
    private double longitude;

    @Column(name = "name", nullable = false)
    @ApiModelProperty(notes = "Mooring ball's name")
    private String name;

    @ManyToOne
    @JoinColumn(name="harbor_id", nullable=false)
    @ApiModelProperty(notes = "Mooring ball's harbor")
    private Harbor harbor;

    @Column(name = "reserved", nullable = false)
    @ApiModelProperty(notes = "Mooring ball's reserved field")
    private boolean reserved;

    @Column(name = "owner", nullable = false)
    @ApiModelProperty(notes = "Mooring ball's owner")
    private String owner;

    @Column(name = "price", nullable = false)
    @ApiModelProperty(notes = "Mooring ball's price")
    private String price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
