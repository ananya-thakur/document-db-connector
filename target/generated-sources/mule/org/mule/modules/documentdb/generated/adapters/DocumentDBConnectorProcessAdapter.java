
package org.mule.modules.documentdb.generated.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.documentdb.DocumentDBConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>DocumentDBConnectorProcessAdapter</code> is a wrapper around {@link DocumentDBConnector } that enables custom processing strategies.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2016-12-04T01:15:06+01:00", comments = "Build UNNAMED.2793.f49b6c7")
public class DocumentDBConnectorProcessAdapter
    extends DocumentDBConnectorLifecycleInjectionAdapter
    implements ProcessAdapter<DocumentDBConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, DocumentDBConnectorCapabilitiesAdapter> getProcessTemplate() {
        final DocumentDBConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,DocumentDBConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, DocumentDBConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, DocumentDBConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
