package com.iba.mooringball.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="harbor")
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Harbor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(notes = "The database generated harbor's ID")
    private Long id;

    @Column(name = "latitude", nullable = false)
    @ApiModelProperty(notes = "Harbor's latitude")
    private double latitude;

    @Column(name = "longitude", nullable = false)
    @ApiModelProperty(notes = "Harbor's longitude")
    private double longitude;

    @Column(name = "name", nullable = false)
    @ApiModelProperty(notes = "Harbor's name")
    private String name;

    @OneToMany(mappedBy = "harbor")
    @JsonIgnore
    private List<MooringBall> balls;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
