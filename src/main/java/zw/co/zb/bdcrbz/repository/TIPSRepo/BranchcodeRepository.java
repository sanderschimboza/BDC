package zw.co.zb.bdcrbz.repository.TIPSRepo;

/*
 * This program was developed by Douglas Gweera (douglasgweera@gmail.com ) on Copyright (c) 2021.
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zw.co.zb.bdcrbz.model.BranchLookUpEntity;

import java.util.Optional;


@Repository
public interface BranchcodeRepository extends JpaRepository<BranchLookUpEntity,String> {

    @Override
    Optional<BranchLookUpEntity> findById(String s);


}
