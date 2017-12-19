package group.msg;

import group.msg.drools.DroolsEvaluation;
import group.msg.drools.DroolsExcelEvaluation;
import group.msg.dto.InputOutput;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;


@Warmup(iterations = 10)
@Measurement(iterations = 10)
public class DroolsBenchmark {
    
    @State(Scope.Thread)
    public static class DroolsState{

        DroolsEvaluation droolsEvaluation;

        DroolsExcelEvaluation droolsExcelEvaluation;

        public DroolsState() {
            droolsEvaluation = new DroolsEvaluation();
            droolsExcelEvaluation = new DroolsExcelEvaluation();
        }
    }


    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void simpleDrl(DroolsState state) {
        state.droolsEvaluation.evaluateRules(new InputOutput());
    }


    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void excel(DroolsState state) {
        state.droolsExcelEvaluation.evaluateRules(new InputOutput());
    }

}
