package com.iba.mooringball.repository;

import com.iba.mooringball.entity.MooringBall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MooringBallRepository extends JpaRepository<MooringBall,Long> {
}
