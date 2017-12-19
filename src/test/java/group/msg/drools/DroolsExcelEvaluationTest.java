package group.msg.drools;

import group.msg.dto.InputOutput;
import group.msg.model.Customer;
import group.msg.model.Customer.CustomerType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class DroolsExcelEvaluationTest {

    private DroolsExcelEvaluation droolsEvaluation = new DroolsExcelEvaluation();

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 1, 1 },
                { 2, 2 },
                { 3, 3 },
                { 4, 4 },
                { 5, 5 },
                { 6, 6 },
                { 7, 7 },
                { 8, 7 }
        });
    }

    @Parameter(0)
    public Integer input;


    @Parameter(1)
    public Integer output;

    @Test
    public void evaluateRules() throws Exception {
        InputOutput inputOutput = new InputOutput(input);

        InputOutput result = droolsEvaluation.evaluateRules(inputOutput);

        assertEquals(result.getOutput(), output);
    }

}
