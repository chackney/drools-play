package star.barnards.port.rules;

import com.hackney.model.Cargo;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Created by clhackne on 04/08/2016.
 */
public class BasicTest {

    @Test
    public void testRules() {
        KieServices ks = KieServices.Factory.get();

        KieContainer kc = ks.getKieClasspathContainer();

        execute( kc );
    }


    public void execute( KieContainer kc ) {
        KieSession ksession = kc.newKieSession("GalacticRulesKS");

        ksession.addEventListener( new DebugAgendaEventListener() );
        ksession.addEventListener( new DebugRuleRuntimeEventListener() );

        final Cargo cargo = new Cargo();
        cargo.setCargoDescription( "Hello World" );
        cargo.setOriginSpacePort("Earth");
        cargo.setStatus( 0 );
        ksession.insert( cargo );

        ksession.fireAllRules();

        ksession.dispose();
    }

}
