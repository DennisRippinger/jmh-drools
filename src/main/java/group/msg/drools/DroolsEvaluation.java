package group.msg.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsEvaluation {

	private final KieSession kieSession;

	public DroolsEvaluation() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kieContainer = ks.getKieClasspathContainer();
		kieSession = kieContainer.newKieSession("ksession-rules");
	}

	public <T> T evaluateRules(T object){
		kieSession.insert(object);
		kieSession.fireAllRules();

		return object;
	}
}
