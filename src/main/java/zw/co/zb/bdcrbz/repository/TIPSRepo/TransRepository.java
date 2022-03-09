package zw.co.zb.bdcrbz.repository.TIPSRepo;/*
 * This program was developed by Douglas Gweera (douglasgweera@gmail.com ) on Copyright (c) 2021.
 */

/*
 * This program was developed by Douglas Gweera (douglasgweera@gmail.com ) on Copyright (c) 2021.
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zw.co.zb.bdcrbz.model.Trans;

import java.util.List;


@Repository
public interface TransRepository extends JpaRepository<Trans,String> {

    List<Trans> findAllByPICKED(String picked);
    
    List<Trans> findAllBySATSTPBetween(String startDate, String endDate);
}
