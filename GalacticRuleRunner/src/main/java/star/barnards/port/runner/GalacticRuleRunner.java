package star.barnards.port.runner;

import com.hackney.model.Cargo;
import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;

/**
 * Created by clhackne on 04/08/2016.
 */
public class GalacticRuleRunner {

    public static final void main(final String[] args) {
        // KieServices is the factory for all KIE services
        KieServices ks = KieServices.Factory.get();

        ReleaseId version1point1 = ks.newReleaseId("star.barnards.port.rules","GalacticRules","1.2");

        ReleaseId version1point2 = ks.newReleaseId("star.barnards.port.rules","GalacticRules","1.3");

        // From the kie services, a container is created from the classpath
        KieContainer kc = ks.newKieContainer(version1point1);

        execute(kc);

        kc.updateToVersion(version1point2);

        execute( kc );
    }

    public static void execute( KieContainer kc ) {
      KieSession ksession = kc.newKieSession("GalacticRulesKS");

        ksession.addEventListener( new DebugAgendaEventListener() );
        ksession.addEventListener( new DebugRuleRuntimeEventListener() );

        final Cargo cargo = new Cargo();
        cargo.setCargoDescription( "Hello World" );
        cargo.setStatus( 0 );
        cargo.setOriginSpacePort("Earth");
        ksession.insert( cargo );

        // and fire the rules
        ksession.fireAllRules();

        // Remove comment if using logging
        // logger.close();

        // and then dispose the session
        ksession.dispose();
    }


}
