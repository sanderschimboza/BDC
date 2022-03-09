package zw.co.zb.bdcrbz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import zw.co.zb.bdcrbz.model.TimeTrack;
import zw.co.zb.bdcrbz.model.Trans;
import zw.co.zb.bdcrbz.repository.TIPSRepo.TransRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@EnableScheduling
@javax.transaction.Transactional
public class RemittanceController {

    private static final Logger log = LoggerFactory.getLogger(RemittanceController.class);

    @Autowired
    private TransRepository repository;

    @PersistenceContext(unitName = "db2EntityManager")
    protected EntityManager emEQ;

    @PersistenceContext(unitName = "db3EntityManager")
    protected EntityManager emMYSQL;


   // @Scheduled(fixedDelay = 9000)
    void getEQTransactions() {

        String timeStampStart = getTimeLastRun();
        Timestamp timeStampEnd = new Timestamp(System.currentTimeMillis());

        String queryString = "SELECT S.GZTREF,S.GZAB2,S.GZDRF2,S.GZNR6,S.GZAMA2,S.GZCCY2,U.SATSTP,S.GZDRR AS PICKED,U.SASRC AS ID,U.SAUC1 AS DESCRIPTION, U.SAUC2 AS STATUSCODE FROM KINPFIN.GZH181 S,KFILFIN.SA20LF U WHERE S.GZTCD1 IN ('MT1') AND S.GZTCD2=U.SATCD AND S.GZDRF1 =U.SADRF AND S.GZAMA2 =U.SAAMA AND (U.SATSTP > ?1 and U.SATSTP <= ?2)";

        try {

            log.info("Start Time::::: {}", timeStampStart);
            log.info("End Time::::::: {}", timeStampEnd);

            Query q = emEQ.createNativeQuery(queryString, Trans.class);

            q.setParameter(1, timeStampStart);

          //  q.setParameter(1, "2022-03-02 07:42:44.227000");

            q.setParameter(2, timeStampEnd);

            List<Trans> list = new ArrayList<>(q.getResultList());

            log.info("Number of added elements ::::::::: {}", list.size());

            for (Trans txn : list) {

                if (!txn.getGZTREF().startsWith("C")) {
                    txn.setPICKED("N");
                    repository.save(txn);
                }

            }

            log.info("Done adding Files::::::::");

        } catch (NullPointerException e) {
            log.error("Null Pointer Error: {}", e.getMessage());
        }
    }

    private String getTimeLastRun() {

        String lastRun = "";

        List<TimeTrack> tlist = new ArrayList<>();

        String sql = "select max(S.SATSTP) as timeLastRun from Trans S";

        Query query1 = emMYSQL.createNativeQuery(sql, TimeTrack.class);

        try {
            tlist.addAll(query1.getResultList());
            if (!tlist.isEmpty()) {
                for (TimeTrack t : tlist) {
                    lastRun = t.getTimeLastRun();
                }
            }
        } catch (Exception e) {
            Timestamp timeStampstart = new Timestamp(System.currentTimeMillis());
            timeStampstart.setHours(0);
            timeStampstart.setMinutes(0);
            timeStampstart.setSeconds(0);
            timeStampstart.setNanos(0);
            lastRun = "" + timeStampstart;
        }

        return lastRun;
    }

}
