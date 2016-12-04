
package org.mule.modules.documentdb.generated.adapters;

import javax.annotation.Generated;
import org.mule.api.devkit.capability.Capabilities;
import org.mule.api.devkit.capability.ModuleCapability;
import org.mule.modules.documentdb.DocumentDBConnector;


/**
 * A <code>DocumentDBConnectorCapabilitiesAdapter</code> is a wrapper around {@link DocumentDBConnector } that implements {@link org.mule.api.Capabilities} interface.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2016-12-04T01:15:06+01:00", comments = "Build UNNAMED.2793.f49b6c7")
public class DocumentDBConnectorCapabilitiesAdapter
    extends DocumentDBConnector
    implements Capabilities
{


    /**
     * Returns true if this module implements such capability
     * 
     */
    public boolean isCapableOf(ModuleCapability capability) {
        if (capability == ModuleCapability.LIFECYCLE_CAPABLE) {
            return true;
        }
        return false;
    }

}
