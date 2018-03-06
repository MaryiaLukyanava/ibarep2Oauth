package com.iba.mooringball.service;


import com.iba.mooringball.entity.MooringBall;

import java.util.List;

public interface MooringBallService {

    List<MooringBall> getMooringBalls();
    MooringBall getMooringBallById(Long id);
    MooringBall addMooringBall(MooringBall ball);
    MooringBall updateMooringBall(MooringBall ball);
    void deleteMooringBall(Long id);

}
