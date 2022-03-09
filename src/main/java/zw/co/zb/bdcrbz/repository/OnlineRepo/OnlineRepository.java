package zw.co.zb.bdcrbz.repository.OnlineRepo;/*
 * This program was developed by Douglas Gweera (douglasgweera@gmail.com ) on Copyright (c) 2021.
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zw.co.zb.bdcrbz.model.Payment;

import java.util.Optional;


@Repository
public interface OnlineRepository extends JpaRepository<Payment,Long> {

    Optional<Payment> findById(Long aLong);
    Optional<Payment> findByIdAndStatusEquals(Long aLong, String status);
    Optional<Payment> findByIdAndStatusEqualsOrStatus(Long aLong, String statusFailed, String statusPending);

}
