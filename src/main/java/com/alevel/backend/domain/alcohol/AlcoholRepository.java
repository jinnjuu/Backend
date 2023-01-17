package com.alevel.backend.domain.alcohol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlcoholRepository extends JpaRepository<Alcohol, Long>, AlcoholRepositoryCustom {

    @Query(value = "select t.id " +
                    "from ( " +
                        "select * from alcohol a where a.volume = :volume " +
                        "union all " +
                        "select * from alcohol a where a.sugar = :sugar " +
                        "union all " +
                        "select * from alcohol a where a.flavor like concat('%', :flavor, '%') " +
                        "union all " +
                        "select * from alcohol a where a.price >= :minPrice and a.price <= :maxPrice " +
                    ") t " +
                    "where t.type in :typeArray " +
                    "group by t.id " +
                    "order by count(*) desc "
            , nativeQuery = true
    )
    List<Long> findRecommend(@Param("typeArray") String[] typeArray,
                                  @Param("volume") Integer volume,
                                  @Param("sugar") Integer sugar,
                                  @Param("flavor") String flavor,
                                  @Param("minPrice") Integer minPrice, @Param("maxPrice") Integer maxPrice);

    Alcohol findAllById(Long id);

    @Query(value="select distinct a.type from Alcohol a")
    List<String> findDistinctType();

    //search
    List<Alcohol> findByNameContaining(String keyword);
}
