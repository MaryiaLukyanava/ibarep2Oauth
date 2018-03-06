package com.iba.mooringball.service.impl;

import com.iba.mooringball.entity.MooringBall;
import com.iba.mooringball.repository.MooringBallRepository;
import com.iba.mooringball.service.MooringBallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MooringBallServiceImpl implements MooringBallService {
    @Autowired
    MooringBallRepository repository;

    @Transactional
    @Override
    public List<MooringBall> getMooringBalls() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public MooringBall getMooringBallById(Long id) {
        return repository.getOne(id);
    }

    @Transactional
    @Override
    public MooringBall addMooringBall(MooringBall ball) {
        return repository.save(ball);
    }

    @Override
    public MooringBall updateMooringBall(MooringBall ball) {
        return repository.save(ball);
    }

    @Transactional
    @Override
    public void deleteMooringBall(Long id) {
        repository.deleteById(id);
    }
}
