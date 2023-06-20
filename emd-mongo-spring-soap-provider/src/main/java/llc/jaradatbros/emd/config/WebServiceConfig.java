/**
 * Copyright 2023 JaradatBros LLC.
 *
 * Licensed under the MIT License ("the License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://spdx.org/licenses/MIT.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package llc.jaradatbros.emd.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import llc.jaradatbros.emd.constants.WebServiceConstants;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setDispatchTraceRequest(true);
        servlet.setEnableLoggingRequestDetails(true);
        servlet.setNamespace(WebServiceConstants.SERVLET_WS_SOAP_NAMESPACE_URI);
        servlet.setTransformSchemaLocations(true);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<MessageDispatcherServlet>(servlet, false, WebServiceConstants.SERVLET_WS_SOAP_URL_MAPPINGS);
    }

    @Bean(name = WebServiceConstants.BIKES_WS_SOAP_BEAN_NAME)
    public DefaultWsdl11Definition bikesWsdl11Definition(XsdSchema entitiesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName(WebServiceConstants.BIKES_WS_SOAP_PORT_TYPE_NAME);
        wsdl11Definition.setLocationUri(WebServiceConstants.BIKES_WS_SOAP_LOCATION_URI);
        wsdl11Definition.setTargetNamespace(WebServiceConstants.ENTITIES_WS_SOAP_NAMESPACE_URI);
        wsdl11Definition.setSchema(entitiesSchema);
        return wsdl11Definition;
    }

    @Bean(name = WebServiceConstants.COUNTRIES_WS_SOAP_BEAN_NAME)
    public DefaultWsdl11Definition countriesWsdl11Definition(XsdSchema entitiesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName(WebServiceConstants.COUNTRIES_WS_SOAP_PORT_TYPE_NAME);
        wsdl11Definition.setLocationUri(WebServiceConstants.COUNTRIES_WS_SOAP_LOCATION_URI);
        wsdl11Definition.setTargetNamespace(WebServiceConstants.ENTITIES_WS_SOAP_NAMESPACE_URI);
        wsdl11Definition.setSchema(entitiesSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema entitiesSchema() {
        return new SimpleXsdSchema(new ClassPathResource(WebServiceConstants.ENTITIES_WS_SOAP_SCHEMA));
    }
}
