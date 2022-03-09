package zw.co.zb.bdcrbz.repository.TIPSRepo;/*
 * This program was developed by Douglas Gweera (douglasgweera@gmail.com ) on Copyright (c) 2021.
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import zw.co.zb.bdcrbz.model.MtaDetails;


import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;


@Repository
public interface TIPSRepository extends JpaRepository<MtaDetails, String> {

    @Override
    Optional<MtaDetails> findById(String s);

    @Transactional
    @Query(value= "SELECT *FROM CSDB.dbo.MTADetails S where S.reference =:transRef",nativeQuery = true)
    Optional<MtaDetails> getByTransref(@Param("transRef") String transRef);


}
