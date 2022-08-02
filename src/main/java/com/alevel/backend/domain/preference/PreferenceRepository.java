package com.alevel.backend.domain.preference;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferenceRepository extends JpaRepository<Preference, Long> {
    @Override
    Preference save(Preference preference);

}
