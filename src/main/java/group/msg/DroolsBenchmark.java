package group.msg;

import group.msg.drools.DroolsEvaluation;
import group.msg.dto.InputOutput;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

public class DroolsBenchmark {
    
    @State(Scope.Thread)
    public static class DroolsState{

        DroolsEvaluation droolsEvaluation;

        @Setup(Level.Invocation)
        public void doSetup(){
            droolsEvaluation = new DroolsEvaluation();
        }
    }


    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void testMethod(DroolsState state) {
        state.droolsEvaluation.evaluateRules(new InputOutput());
    }

}