# [liveSense :: JCR :: Explorer - org.liveSense.jcr.explorer](http://github.com/liveSense/org.liveSense.jcr.explorer)

## Description
liveSense JCR Content explorer. This based on https://code.google.com/p/jackrabbitexplorer/

## OSGi Exported packages
* org.liveSense.jcr.explorer.client(1.0.0.SNAPSHOT)
* org.liveSense.jcr.explorer.client.callback(1.0.0.SNAPSHOT)
* org.liveSense.jcr.explorer.client.fileupload(1.0.0.SNAPSHOT)
* org.liveSense.jcr.explorer.client.handler(1.0.0.SNAPSHOT)
* org.liveSense.jcr.explorer.client.ui(1.0.0.SNAPSHOT)
* org.liveSense.jcr.explorer.domain(1.0.0.SNAPSHOT)
* org.liveSense.jcr.explorer.server(1.0.0.SNAPSHOT)
* org.liveSense.jcr.explorer.service(1.0.0.SNAPSHOT)

## OSGi Dependencies
* __[liveSense :: Framework :: GWT framework - org.liveSense.framework.gwt (2-SNAPSHOT)](http://github.com/liveSense/org.liveSense.framework.gwt)__
	* com.google.gwt.core.client
	* com.google.gwt.event.shared
	* com.google.gwt.i18n.shared.impl
	* com.google.gwt.user.client
	* com.google.gwt.user.client.rpc
	* com.google.gwt.user.client.rpc.core.java.lang
	* com.google.gwt.user.client.rpc.core.java.util
	* com.google.gwt.user.client.ui
* __Content Repository for JavaTM Technology API - javax.jcr (2.0)__
	* javax.jcr
	* javax.jcr.lock
	* javax.jcr.nodetype
	* javax.jcr.query
	* javax.jcr.version
* __Apache Sling Authentication Service - org.apache.sling.auth.core (1.1.2)__
	* org.apache.sling.auth.core
* __Apache Sling JCR Base Bundle - org.apache.sling.jcr.base (2.1.2)__
	* org.apache.sling.jcr.base
* __Apache Sling Repository API Bundle - org.apache.sling.jcr.api (2.1.0)__
	* org.apache.sling.jcr.api
* __Apache Sling API - org.apache.sling.api (2.4.2)__
	* org.apache.sling.api
	* org.apache.sling.api.auth
	* org.apache.sling.api.request
	* org.apache.sling.api.resource
	* org.apache.sling.api.servlets
* __Apache Commons IO Bundle - org.apache.commons.io (1.4)__
	* org.apache.commons.io
* __Commons FileUpload - org.apache.commons.fileupload (1.2.2)__
	* org.apache.commons.fileupload
	* org.apache.commons.fileupload.servlet
	* org.apache.commons.fileupload.util
* __Servlet 3.0 - org.apache.geronimo.specs.geronimo-servlet_3.0_spec (1.0)__
	* javax.servlet
	* javax.servlet
	* javax.servlet.http
	* javax.servlet.http
* __Commons Lang - org.apache.commons.lang (2.6)__
	* org.apache.commons.lang
* __Apache Sling MIME type mapping support - org.apache.sling.commons.mime (2.1.4)__
	* org.apache.sling.commons.mime
* __[liveSense :: Service :: GWT Abstract Services - org.liveSense.service.gwt (2-SNAPSHOT)](http://github.com/liveSense/org.liveSense.service.gwt)__
	* org.liveSense.service.gwt
* __Apache Felix Declarative Services - org.apache.felix.scr (1.6.2)__
	* org.osgi.service.component
* __Apache Felix Configuration Admin Service - org.apache.felix.configadmin (1.6.0)__
	* org.osgi.service.cm
* __Apache Sling Commons OSGi support - org.apache.sling.commons.osgi (2.2.0)__
	* org.apache.sling.commons.osgi
* __OPS4J Pax Logging - API - org.ops4j.pax.logging.pax-logging-api (1.7.0)__
	* org.apache.commons.logging
	* org.apache.commons.logging
	* org.knopflerfish.service.log
	* org.ops4j.pax.logging
	* org.osgi.service.log
	* org.slf4j
	* org.slf4j
	* org.slf4j
	* org.slf4j
* __Apache ServiceMix :: Bundles :: guava - org.apache.servicemix.bundles.guava (11.0.0.1)__
	* com.google.common.collect
* __Apache Jackrabbit API - org.apache.jackrabbit.jackrabbit-api (2.4.2)__
	* org.apache.jackrabbit.api.management
* __[liveSense :: Core - org.liveSense.core (2-SNAPSHOT)](http://github.com/liveSense/org.liveSense.core)__
	* org.liveSense.core
* __System Bundle - org.apache.felix.framework (4.0.3)__
	* org.osgi.service.packageadmin
* __[liveSense :: Service :: Security Manager - org.liveSense.service.securityManager (2-SNAPSHOT)](http://github.com/liveSense/org.liveSense.service.securityManager)__
	* org.liveSense.service.securityManager
	* org.liveSense.service.securityManager.exceptions

## OSGi Embedded JARs

## Dependency Graph
![alt text](http://raw.github.com.everydayimmirror.in/liveSense/org.liveSense.jcr.explorer/master/osgidependencies.svg "")