package com.ipph.dc.config;

import com.ipph.dc.service.KeyWordService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * Created with IntelliJ IDEA.
 * User: ZRC
 * Date Time: 2019/8/7 14:17
 * Description: No Description
 */
@Configuration
public class WebServiceConfig {
    @Autowired
    private Bus bus;

    @Autowired
    private KeyWordService keyWordService;

    @Bean
    public ServletRegistrationBean dispatcherServlet2() {
        return new ServletRegistrationBean(new CXFServlet(), "/soap/*");
    }

    @Bean
    public Endpoint endpoint() {
        // http://localhost:8080/soap
        // http://localhost:8080/soap/keyword?wsdl
        EndpointImpl endpoint=new EndpointImpl(bus, keyWordService);//绑定要发布的服务
        endpoint.publish("/keyword"); //显示要发布的名称
        return endpoint;
    }
}
