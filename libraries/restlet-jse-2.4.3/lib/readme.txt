====================================================
Edition for Java SE - dependencies between JAR files
====================================================


Below is a list of the dependencies between Restlet libraries. You need to ensure 
that all the dependencies of the libraries that you are using are on the classpath
of your Restlet program, otherwise ClassNotFound exceptions will be thrown.

A minimal Restlet application requires the org.restlet.jar file.

To configure connectors such as HTTP server or HTTP client connectors, please refer
to the Restlet User Guide: http://restlet.org/learn/guide/2.4/


org.restlet.ext.atom (Restlet Extension - Atom)
--------------------
 - nothing beside org.restlet JAR.

org.restlet (Restlet Core - API and Engine)
-----------
 - J2SE 7.0

org.restlet.test (Restlet Unit Tests)
----------------
 - org.hamcrest_1.3
 - org.junit_4.11
 - com.wordnik.swagger.core_1.5
 - com.wordnik.swagger.models_1.5

org.restlet.ext.crypto (Restlet Extension - Crypto)
----------------------
 - nothing beside org.restlet JAR.

org.restlet.ext.emf (Restlet Extension - EMF)
-------------------
 - org.eclipse.emf.common_2.6
 - org.eclipse.emf.ecore_2.6
 - org.eclipse.emf.ecore.xmi_2.6

org.restlet.example (Restlet examples)
-------------------
 - org.junit_4.11
 - org.mongodb_2.11
 - com.sun.syndication_1.0
 - org.testng_6.8

org.restlet.ext.fileupload (Restlet Extension - FileUpload)
--------------------------
 - org.apache.commons.fileupload_1.3
 - javax.servlet_3.1

org.restlet.ext.freemarker (Restlet Extension - FreeMarker)
--------------------------
 - org.freemarker_2.3

org.restlet.ext.gson (Restlet Extension - GSON)
--------------------
 - com.google.code.gson_2.3
 - org.joda.time_2.3

org.restlet.ext.guice (Restlet Extension - Guice)
---------------------
 - org.aopalliance_1.0
 - com.google.guice_3.0
 - javax.inject_1.0

org.restlet.ext.gwt (Restlet Extension - GWT)
-------------------
 - com.google.gwt.server_2.3

org.restlet.ext.html (Restlet Extension - HTML)
--------------------
 - nothing beside org.restlet JAR.

org.restlet.ext.httpclient (Restlet Extension - Apache HTTP Client)
--------------------------
 - org.apache.commons.codec_1.5
 - org.apache.httpclient_4.5
 - org.apache.httpcore_4.4
 - org.apache.httpmime_4.5
 - net.jcip.annotations_1.0
 - org.apache.commons.logging_1.1
 - org.apache.james.mime4j_0.7

org.restlet.ext.jaas (Restlet Extension - JAAS)
--------------------
 - nothing beside org.restlet JAR.

org.restlet.ext.jackson (Restlet Extension - Jackson)
-----------------------
 - com.fasterxml.jackson.annotations_2.9
 - com.fasterxml.jackson.core_2.9
 - com.fasterxml.jackson.csv_2.9
 - com.fasterxml.jackson.databind_2.9
 - com.fasterxml.jackson.jaxb_2.9
 - com.fasterxml.jackson.jsonschema_2.9
 - com.fasterxml.jackson.smile_2.9
 - com.fasterxml.jackson.xml_2.9
 - com.fasterxml.jackson.yaml_2.9
 - org.yaml.snakeyaml_1.18
 - org.codehaus.woodstox.core_4.3
 - org.codehaus.woodstox.stax2api_4.3

org.restlet.ext.javamail (Restlet Extension - JavaMail)
------------------------
 - javax.mail_1.4

org.restlet.ext.jaxb (Restlet Extension - JAXB)
--------------------
 - com.sun.jaxb_2.1

org.restlet.ext.jaxrs (Restlet Extension - JAX-RS)
---------------------
 - org.apache.commons.fileupload_1.3
 - javax.mail_1.4
 - com.sun.jaxb_2.1
 - javax.ws.rs_2.0
 - org.json_2.0
 - org.apache.commons.lang_3.6
 - org.jboss.resteasy_3.6
 - javax.servlet_3.1
 - org.simpleframework.xml_2.7

org.restlet.ext.jetty (Restlet Extension - Jetty)
---------------------
 - org.eclipse.jetty.client_9.4
 - org.eclipse.jetty.http_9.4
 - org.eclipse.jetty.io_9.4
 - org.eclipse.jetty.server_9.4
 - org.eclipse.jetty.util_9.4
 - javax.servlet_3.1

org.restlet.ext.jibx (Restlet Extension - JiBX)
--------------------
 - org.jibx.runtime_1.2

org.restlet.ext.json (Restlet Extension - JSON)
--------------------
 - org.json_2.0

org.restlet.ext.lucene (Restlet Extension - Lucene)
----------------------
 - org.apache.commons.io_2.6
 - org.apache.lucene_4.6
 - org.apache.solr_7.4
 - org.apache.solr.common_7.4
 - org.apache.tika_1.18
 - org.apache.tika.parsers_1.18

org.restlet.ext.nio (Restlet Extension - NIO)
-------------------
 - nothing beside org.restlet JAR.

org.restlet.ext.oauth (Restlet Extension - OAuth)
---------------------
 - org.apache.commons.codec_1.5
 - org.apache.commons.dbcp_1.3
 - org.freemarker_2.3
 - org.json_2.0
 - net.oauth_1.0
 - org.apache.commons.pool_1.5

org.restlet.ext.odata (Restlet Extension - OData)
---------------------
 - org.freemarker_2.3

org.restlet.ext.openid (Restlet Extension - OpenID)
----------------------
 - com.google.guice_3.0
 - org.apache.httpclient_4.5
 - org.json_2.0
 - net.sourceforge.nekohtml_1.9
 - org.openid4java_0.9

org.restlet.ext.platform (Restlet Extension - Platform)
------------------------
 - com.google.guava_26.0
 - javax.ws.rs_2.0
 - org.raml_0.8
 - org.raml_0.8
 - com.wordnik.swagger.annotations_1.5
 - com.wordnik.swagger.core_1.5
 - com.wordnik.swagger.models_1.5

org.restlet.ext.raml (Restlet Extension - Raml)
--------------------
 - com.fasterxml.jackson.annotations_2.9
 - com.fasterxml.jackson.core_2.9
 - com.fasterxml.jackson.csv_2.9
 - com.fasterxml.jackson.databind_2.9
 - com.fasterxml.jackson.jaxb_2.9
 - com.fasterxml.jackson.jsonschema_2.9
 - com.fasterxml.jackson.smile_2.9
 - com.fasterxml.jackson.xml_2.9
 - com.fasterxml.jackson.yaml_2.9
 - org.raml_0.8
 - org.slf4j_1.7

org.restlet.ext.rdf (Restlet Extension - RDF)
-------------------
 - nothing beside org.restlet JAR.

org.restlet.ext.simple (Restlet Extension - Simple)
----------------------
 - org.simpleframework_5.1

org.restlet.ext.slf4j (Restlet Extension - SLF4J)
---------------------
 - org.slf4j_1.7

org.restlet.ext.spring (Restlet Extension - Spring Framework)
----------------------
 - net.sf.cglib_2.2
 - org.apache.commons.logging_1.1
 - org.springframework.beans_3.2
 - org.springframework.context_3.2
 - org.springframework.core_3.2
 - org.springframework.expression_3.2
 - org.springframework.web_3.2
 - org.springframework.webmvc_3.2

org.restlet.ext.swagger (Restlet Extension - Swagger)
-----------------------
 - com.fasterxml.jackson.annotations_2.9
 - com.fasterxml.jackson.core_2.9
 - com.fasterxml.jackson.csv_2.9
 - com.fasterxml.jackson.databind_2.9
 - com.fasterxml.jackson.jaxb_2.9
 - com.fasterxml.jackson.jsonschema_2.9
 - com.fasterxml.jackson.smile_2.9
 - com.fasterxml.jackson.xml_2.9
 - com.fasterxml.jackson.yaml_2.9
 - javax.ws.rs_2.0
 - scala-library_2.9
 - scalap_2.9
 - org.slf4j_1.7
 - com.wordnik.swagger.models_1.5

org.restlet.ext.thymeleaf (Restlet Extension - Thymeleaf)
-------------------------
 - org.thymeleaf_2.1

org.restlet.ext.velocity (Restlet Extension - Velocity)
------------------------
 - org.apache.commons.collections_3.2
 - org.apache.commons.lang_3.6
 - org.apache.velocity_2.0

org.restlet.ext.wadl (Restlet Extension - WADL)
--------------------
 - nothing beside org.restlet JAR.

org.restlet.ext.xml (Restlet Extension - XML)
-------------------
 - nothing beside org.restlet JAR.
