package group.msg.drools;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

public class AbstractDroolsEvaluation {

    protected KieContainer kContainer;
    protected KieSession kieSession;

    public <T> T evaluateRules(T object) {

        FactHandle insert = kieSession.insert(object);
        kieSession.fireAllRules();

        kieSession.delete(insert);

        return object;
    }
}
