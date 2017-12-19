package group.msg.drools;

import org.drools.decisiontable.DecisionTableProviderImpl;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;

public class DroolsExcelEvaluation {

    private final Resource resource;
    private final KieContainer kContainer;
    private final KieSession kieSession;

    public DroolsExcelEvaluation() {
        KieServices kieServices = KieServices.Factory.get();

        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        resource = ResourceFactory.newClassPathResource("SimpleRules.xlsx");
        kieFileSystem.write(resource);

        KieBuilder kb = kieServices.newKieBuilder(kieFileSystem);
        kb.buildAll();
        KieModule kieModule = kb.getKieModule();

        kContainer = kieServices.newKieContainer(kieModule.getReleaseId());
        kieSession = kContainer.newKieSession();


    }

    public <T> T evaluateRules(T object) {


        kieSession.insert(object);
        kieSession.fireAllRules();

        //kieSession.dispose();

        return object;
    }

    String getDrlFromExcel() {
        DecisionTableProviderImpl decisionTableProvider = new DecisionTableProviderImpl();

        return decisionTableProvider.loadFromResource(resource, null);
    }
}
