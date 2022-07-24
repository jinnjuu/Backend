package com.alevel.backend.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface RecommendRepository extends JpaRepository<Alchol,Long> {
//    @Query(value = "select * from Alchol a where a.type=(select p.type from Preference p where p.user_id=1)", nativeQuery = true)
//    List<Alchol> findByType();

//    @Query("select a.id from Alchol a inner join Preference p on a.type=p.type")
//    List<Alchol> findByID(Alchol.AlcholBuilder sugar);


//    Alchol findByType(String type);
//
//    @Query(value = "select * from Alchol a where a.volume=(select p.volume from Preference p where p.user_id=1)", nativeQuery = true)
//    Alchol findByVolume(int volume);
//
//    @Query(value = "select * from Alchol a where a.sugar=(select p.sugar from Preference p where p.user_id=1)", nativeQuery = true)
//    Alchol findBySugar(int sugar);
//
//    @Query(value = "select * from Alchol a where a.flavor=(select p.flavor from Preference p where p.user_id=1)", nativeQuery = true)
//    Alchol findByFlavor(String flavor);
//
//
//    @Query(value = "select * from Alchol a where a.price=(select p.price from Preference p where p.user_id=1)", nativeQuery = true)
//    Alchol findByPrice(String price);



    // select * from alchol
    // where alchol.type=
    // (select p.type from preference p where user_id=1)




}