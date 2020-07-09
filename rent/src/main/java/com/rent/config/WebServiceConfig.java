package com.rent.config;

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

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    @Bean(name = "schema1")
    public DefaultWsdl11Definition defaultWsdl11Definition1(XsdSchema rentSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("schema1Port");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://localhost:8095/rent");
        wsdl11Definition.setSchema(rentSchema);
        return wsdl11Definition;
    }
    @Bean(name = "rent")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema adSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("rent1Port");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://localhost:8095/rent");
        wsdl11Definition.setSchema(adSchema);
        return wsdl11Definition;
    }
    @Bean
    public XsdSchema rentSchema() {
        return new SimpleXsdSchema(new ClassPathResource("schema1.xsd"));
    }
    @Bean
    public XsdSchema adSchema() {
        return new SimpleXsdSchema(new ClassPathResource("rent.xsd"));
    }
}

