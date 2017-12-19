package group.msg.drools;

import org.junit.Test;

public class DroolsExcelTranspileTest {

    DroolsExcelEvaluation droolsExcelEvaluation = new DroolsExcelEvaluation();

    @Test
    public void getDrlFromExcel() throws Exception {
        System.out.println(droolsExcelEvaluation.getDrlFromExcel());
    }

}
