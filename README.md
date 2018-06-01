# Sample flow to test the connector


    <http:listener-config name="HTTP_Listener_Configuration1" host="0.0.0.0" port="8082" doc:name="HTTP Listener Configuration"/>
    <document-db:config name="DocumentDB__Configuration" doc:name="DocumentDB: Configuration" endPoint="https://mulesoft.documents.azure.com:443/" masterKey="m9wrosPmWlhgiO2Z35m6t6dujiqhVJbeljUrSELxtxR6ZYGmp9LSgIrfrPzsV2jtG1ClrKMnazsvQmmIAnsS2A=="/>
    <flow name="documentdbdemoFlow1">
        <http:listener config-ref="HTTP_Listener_Configuration1" path="/" doc:name="HTTP"/>
        <document-db:insert config-ref="DocumentDB__Configuration" collectionID="myCollection" databaseID="myDB" document="{&quot;name&quot;:&quot;Allen Matheus&quot;,&quot;id&quot;:&quot;973&quot;,&quot;email&quot;:&quot;allen [at] contoso.com&quot;}" doc:name="DocumentDB"/>
        <document-db:query config-ref="DocumentDB__Configuration" collectionID="myCollection" databaseID="myDB" queryString="SELECT * FROM myCollection" doc:name="DocumentDB"/>
        <json:object-to-json-transformer mimeType="application/json" doc:name="Object to JSON"/>
    </flow>
</mule>


# DocumentDB Anypoint Connector

[Connector description including destination service or application with]

# Mule supported versions
Examples:
Mule 3.4.x, 3.5.x
Mule 3.4.1

# [Destination service or application name] supported versions
Example:
Oracle E-Business Suite 12.1 and above.

#Service or application supported modules
Example:
Oracle CRM
Oracle Financials
or 
Salesforce API v.24
Salesforce Metadata API


# Installation 
For beta connectors you can download the source code and build it with devkit to find it available on your local repository. Then you can add it to Studio

For released connectors you can download them from the update site in Anypoint Studio. 
Open Anypoint Studio, go to Help → Install New Software and select Anypoint Connectors Update Site where you’ll find all avaliable connectors.

#Usage
For information about usage our documentation at http://github.com/mulesoft/document-db.

# Reporting Issues

We use GitHub:Issues for tracking issues with this connector. You can report new issues at this link http://github.com/mulesoft/document-db/issues.
