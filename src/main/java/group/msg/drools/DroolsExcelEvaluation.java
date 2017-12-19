package group.msg.drools;

import org.drools.decisiontable.DecisionTableProviderImpl;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.io.Resource;
import org.kie.internal.io.ResourceFactory;

public class DroolsExcelEvaluation extends AbstractDroolsEvaluation {

    private final Resource resource;

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

    String getDrlFromExcel() {
        DecisionTableProviderImpl decisionTableProvider = new DecisionTableProviderImpl();

        return decisionTableProvider.loadFromResource(resource, null);
    }
}
