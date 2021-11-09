package org.example;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.LiveQuery;
import org.kie.api.runtime.rule.Row;
import org.kie.api.runtime.rule.ViewChangedEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {
    static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieBase kieBase = kContainer.getKieBase();
        KieSession kSession = kieBase.newKieSession();

        LOG.info("Creating listener");

        ViewChangedEventListener listener = new ViewChangedEventListener() {
            @Override
            public void rowDeleted(Row row) {
            }

            @Override
            public void rowInserted(Row row) {
                Aggregate aggregate = (Aggregate) row.get("$conclusion");
                //System.out.println(">>>" + conclusion.toString());
                LOG.info("Conclusion >>> " + aggregate.toString());

                // stop inference engine after as soon as got a conclusion
                kSession.halt();

            }

            @Override
            public void rowUpdated(Row row) {
            }

        };

        LiveQuery query = kSession.openLiveQuery("Aggregates", null, listener);

        LOG.info("Now running data");

        Bot bot1 = new Bot("1", true);
        kSession.insert(bot1);
        Bot bot2 = new Bot("2", true);
        kSession.insert(bot2);
        Bot bot4 = new Bot("4", true);
        kSession.insert(bot4);
        Bot bot5 = new Bot("5", true);
        kSession.insert(bot5);
        Bot bot6 = new Bot("6", false);
        kSession.insert(bot6);
        Bot bot8 = new Bot("8", true);
        kSession.insert(bot8);

        kSession.fireAllRules();

        LOG.info("Final checks");

        query.close();

        LOG.info("Objects from KieSession");
        for(Object obj: kSession.getObjects()) {
            LOG.info(obj.toString());
        }

    }
}
