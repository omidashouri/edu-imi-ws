package edu.imi.ir.eduimiws.controllers.edu.v1;

import edu.imi.ir.eduimiws.services.edu.PeriodService;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Objects;
//___periodfour
@SpringBootTest
@ActiveProfiles(value = "prod")
public class PeriodServiceTest {

    @Autowired
    public PeriodService periodService;

    @Test
    public void queryAllPeriodsCustomThreeTest(){
        /*Page<PeriodProjectionCustomThree> periodProjectionCustomThrees =
                periodService.queryAllPeriodsCustomThree(null, null, null,
                        null, null, null, null, null,
                        null, null, null, null, null,
                        null, null, null, null,
                        null, null, null, null, null,
                null, null, null, null, null,
                        null, null, null, null, null,
                        null, null);
        List<PeriodProjectionCustomThree> content = periodProjectionCustomThrees.getContent();*/
        final val periodCustomFours = periodService.queryAllPeriodsCustomFour(null, null, null,
                null, null, null, null, null,
                null, null, null, null, null,
                null, null, null, null,
                null, null, null, null, null,
                null, null, null, null,
                null, null, null, null, null,
                null, null,null,null,null,null,
                null,null);
        Assertions.assertTrue(Objects.nonNull(periodCustomFours));
        System.out.println("the count size is: "+periodCustomFours.size());
//        Assertions.assertTrue("15228".equalsIgnoreCase(String.valueOf(periodCustomFours.size())));

    }

}
