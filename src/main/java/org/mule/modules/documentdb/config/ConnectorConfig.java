package org.mule.modules.documentdb.config;

import org.mule.api.annotations.components.Configuration;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.param.Default;

@Configuration(friendlyName = "Configuration")
public class ConnectorConfig {

	
	
    /**
     * Greeting message
     */
    @Configurable
    @Default("https://yourname.documents.azure.com:443/")
    private String endPoint;

    /**
     * Reply message
     */
    @Configurable
    @Default("m9w4osP3WlhgiO2Z35m6t6dujiqhVJbeljUrSELxtxR6ZYGmp9LSgIr43fg5V2jtG1ClrKMnazsvQmmIAnsS2A==")
    private String masterKey;

    /**
     * Set greeting message
     *
     * @param greeting the greeting message
     */
    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    /**
     * Get greeting message
     */
    public String getEndPoint() {
        return this.endPoint;
    }

    /**
     * Set reply
     *
     * @param reply the reply
     */
    public void setMasterKey(String masterKey) {
        this.masterKey = masterKey;
    }

    /**
     * Get reply
     */
    public String getMasterKey() {
        return this.masterKey;
    }

}