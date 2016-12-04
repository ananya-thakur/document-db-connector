
package org.mule.modules.documentdb.generated.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;


/**
 * Registers bean definitions parsers for handling elements in <code>http://www.mulesoft.org/schema/mule/document-db</code>.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2016-12-04T01:15:06+01:00", comments = "Build UNNAMED.2793.f49b6c7")
public class DocumentDbNamespaceHandler
    extends NamespaceHandlerSupport
{

    private static Logger logger = LoggerFactory.getLogger(DocumentDbNamespaceHandler.class);

    private void handleException(String beanName, String beanScope, NoClassDefFoundError noClassDefFoundError) {
        String muleVersion = "";
        try {
            muleVersion = MuleManifest.getProductVersion();
        } catch (Exception _x) {
            logger.error("Problem while reading mule version");
        }
        logger.error(((((("Cannot launch the mule app, the  "+ beanScope)+" [")+ beanName)+"] within the connector [document-db] is not supported in mule ")+ muleVersion));
        throw new FatalBeanException(((((("Cannot launch the mule app, the  "+ beanScope)+" [")+ beanName)+"] within the connector [document-db] is not supported in mule ")+ muleVersion), noClassDefFoundError);
    }

    /**
     * Invoked by the {@link DefaultBeanDefinitionDocumentReader} after construction but before any custom elements are parsed. 
     * @see NamespaceHandlerSupport#registerBeanDefinitionParser(String, BeanDefinitionParser)
     * 
     */
    public void init() {
        try {
            this.registerBeanDefinitionParser("config", new DocumentDBConnectorConnectorConfigConfigDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("config", "@Config", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-database", new CreateDatabaseDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-database", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-collection", new CreateCollectionDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-collection", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("insert", new InsertDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("insert", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("query", new QueryDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("query", "@Processor", ex);
        }
    }

}
