package group.msg.drools;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.io.Resource;
import org.kie.internal.io.ResourceFactory;

public class DroolsEvaluation extends AbstractDroolsEvaluation {

    private final Resource resource;


    public DroolsEvaluation() {
        KieServices kieServices = KieServices.Factory.get();

        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        resource = ResourceFactory.newClassPathResource("rules/rule.drl");
        kieFileSystem.write(resource);

        KieBuilder kb = kieServices.newKieBuilder(kieFileSystem);
        kb.buildAll();
        KieModule kieModule = kb.getKieModule();

        kContainer = kieServices.newKieContainer(kieModule.getReleaseId());

        kieSession = kContainer.newKieSession();
    }

}
