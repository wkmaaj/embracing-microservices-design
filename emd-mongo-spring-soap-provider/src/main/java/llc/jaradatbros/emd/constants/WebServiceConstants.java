package llc.jaradatbros.emd.constants;

import llc.jaradatbros.emd.config.WebServiceConfig;

/**
 * @author wkmaaj
 */
public class WebServiceConstants {
    private static final String XSD_DIR = "xsd/";
    private static final String XSD_FILE_EXT = ".xsd";
    private static final String WS_SOAP_LOCATION_URI = "/ws";
    private static final String SOAP_WS_PORT_TYPE_NAME = "Port";

    /**
     * The name of the countries web service bean.
     */
    public static final String BIKES_WS_SOAP_BEAN_NAME = "bikes";

    /**
     * The namespace URI used in the bikes WSDL.
     */
    public static final String BIKES_WS_SOAP_NAMESPACE_URI = "emd:api:spring:mongosoap";

    /**
     * The classpath name of the bikes schema file.
     */
    public static final String BIKES_WS_SOAP_SCHEMA = XSD_DIR + BIKES_WS_SOAP_BEAN_NAME + XSD_FILE_EXT;

    /**
     * The SOAP address location of the bikes web service.
     */
    public static final String BIKES_WS_SOAP_LOCATION_URI = WS_SOAP_LOCATION_URI + "/" + BIKES_WS_SOAP_BEAN_NAME;

    /**
     * The name of the bikes web service's port.
     */
    public static final String BIKES_WS_SOAP_PORT_TYPE_NAME = BIKES_WS_SOAP_BEAN_NAME + SOAP_WS_PORT_TYPE_NAME;

    /**
     * The name of the countries web service bean.
     */
    public static final String COUNTRIES_WS_SOAP_BEAN_NAME = "countries";

    /**
     * The name of the entities web service bean.
     */
    public static final String ENTITIES_WS_SOAP_BEAN_NAME = "entities";

    /**
     * The namespace URI used in the countries WSDL.
     */
    public static final String COUNTRIES_WS_SOAP_NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    /**
     * The namespace URI used in the entities WSDL.
     */
    public static final String ENTITIES_WS_SOAP_NAMESPACE_URI = "llc:jaradatbros:emd:api:soap:mongo";

    /**
     * The classpath name of the countries schema file.
     */
    public static final String COUNTRIES_WS_SOAP_SCHEMA = XSD_DIR + COUNTRIES_WS_SOAP_BEAN_NAME + XSD_FILE_EXT;

    /**
     * The classpath name of the entities schema file.
     */
    public static final String ENTITIES_WS_SOAP_SCHEMA = XSD_DIR + ENTITIES_WS_SOAP_BEAN_NAME + XSD_FILE_EXT;

    /**
     * The SOAP address location of the countries web service.
     */
    public static final String COUNTRIES_WS_SOAP_LOCATION_URI = WS_SOAP_LOCATION_URI + "/" + COUNTRIES_WS_SOAP_BEAN_NAME;

    /**
     * The name of the countries web service's port.
     */
    public static final String COUNTRIES_WS_SOAP_PORT_TYPE_NAME = COUNTRIES_WS_SOAP_BEAN_NAME + SOAP_WS_PORT_TYPE_NAME;

    /**
     * The namespace URI used by the SOAP web service servlet spun up by {@link WebServiceConfig#messageDispatcherServlet messageDispatcherServlet}.
     */
    public static final String SERVLET_WS_SOAP_NAMESPACE_URI = "emd:api:soap";

    /**
     * The URL mappings to be serviced by the SOAP web service servlet spun up by {@link WebServiceConfig#messageDispatcherServlet messageDispatcherServlet}.
     */
    public static final String SERVLET_WS_SOAP_URL_MAPPINGS = WS_SOAP_LOCATION_URI + "/*";
}
