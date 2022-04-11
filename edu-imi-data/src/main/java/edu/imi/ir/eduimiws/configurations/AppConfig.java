package edu.imi.ir.eduimiws.configurations;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import edu.imi.ir.eduimiws.models.helper.DefaultValues;
import edu.imi.ir.eduimiws.security.ApiUrlSecurityCredential;
import edu.imi.ir.eduimiws.security.AuthenticationCredential;
import edu.imi.ir.eduimiws.security.DigitalPaymentCredential;
import edu.imi.ir.eduimiws.utilities.ClobHelper;
import edu.imi.ir.eduimiws.utilities.ErpPasswordEncoder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.cache.jcache.JCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;
import java.util.Map;
import java.util.Properties;

@Configuration
@PropertySources({
        @PropertySource("classpath:application.properties"),
        @PropertySource("classpath:security.properties")
})
@EnableCaching
public class AppConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ErpPasswordEncoder erpPasswordEncoder() {
        return new ErpPasswordEncoder();
    }

//    EhCacheCacheManager caching type:
/*    @Bean
    public CacheManager cacheManager() {
        EhCacheCacheManager cacheManager = new EhCacheCacheManager();
        cacheManager.setCacheManager(ehCacheCacheManagerFactory().getObject());
        cacheManager.setTransactionAware(true);
        return cacheManager;
    }

    @Bean
    public EhCacheManagerFactoryBean ehCacheCacheManagerFactory() {
        EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.txt"));
        cacheManagerFactoryBean.setShared(true);
        return cacheManagerFactoryBean;
    }*/

//  ConcurrentMapCacheManager caching type:
/*    @Bean
    public CacheManager cacheManager() {
        ConcurrentMapCacheManager concurrentMapCacheManager = new ConcurrentMapCacheManager();
        concurrentMapCacheManager.setCacheNames(Arrays.asList("periodDescriptive"));
        return concurrentMapCacheManager;
    }*/

/*    @Bean
    public KeyGenerator multiplyKeyGenerator() {
        return (Object target, Method method, Object... params) ->
                method.getName() + "_" + Arrays.toString(params);
    }*/

//  org.ehcache.CacheManager(V3) caching type:
/*    @Bean
    public CacheManager ehCacheV3Manager() {
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .with(CacheManagerBuilder
                        .persistence("/run/media/omidashouri/Archive/0_0/cacheV3" *//*+ File.separator + "ss"*//*))
                .withCache("myEhv3Cache", CacheConfigurationBuilder
                        .newCacheConfigurationBuilder(Long.class, String.class,
                                ResourcePoolsBuilder
                                        .newResourcePoolsBuilder()
                                        .heap(2000, EntryUnit.ENTRIES)
                                        .disk(50, MemoryUnit.MB, true)
                                        .offheap(10, MemoryUnit.MB))
                        .withExpiry(ExpiryPolicyBuilder.
                                timeToLiveExpiration(Duration.ofSeconds(5)))
                        .withExpiry(ExpiryPolicyBuilder
                                .timeToIdleExpiration(Duration.ofMinutes(20))))
                .build(true);
        return cacheManager;
    }*/

    @Bean
    public JCacheCacheManager jCacheCacheManager(JCacheManagerFactoryBean jCacheManagerFactoryBean) {
        JCacheCacheManager jCacheCacheManager = new JCacheCacheManager();
        jCacheCacheManager.setCacheManager(jCacheManagerFactoryBean.getObject());
        return jCacheCacheManager;
    }

    @Bean
    public JCacheManagerFactoryBean jCacheManagerFactoryBean() throws URISyntaxException {
        JCacheManagerFactoryBean jCacheManagerFactoryBean = new JCacheManagerFactoryBean();
        jCacheManagerFactoryBean.setCacheManagerUri(getClass().getResource("/ehcache.xml").toURI());
        return jCacheManagerFactoryBean;
    }

    @Bean
    public SpringApplicationContext springApplicationContext() {
        return new SpringApplicationContext();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public SimpleMailMessage simpleMailMessage() {
        return new SimpleMailMessage();
    }

    @Bean
    public Jackson2JsonObjectMapper jackson2JsonObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        return new Jackson2JsonObjectMapper(mapper);
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new Hibernate5Module());
        jsonConverter.setObjectMapper(objectMapper);
        return jsonConverter;
    }

    @Bean
    @ConditionalOnMissingBean(JavaMailSender.class)
    JavaMailSenderImpl mailSender(MailProperties properties) {
        JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
        applyProperties(properties, javaMailSenderImpl);
        return javaMailSenderImpl;
    }

    @Bean
    public ClobHelper clobHelper() {
        return new ClobHelper();
    }

    private void applyProperties(MailProperties properties, JavaMailSenderImpl sender) {
        sender.setHost(properties.getHost());
        sender.setPort(properties.getPort());
        sender.setUsername(properties.getUsername());
        sender.setPassword(properties.getPassword());
        sender.setProtocol(properties.getProtocol());
        sender.setDefaultEncoding(properties.getDefaultEncoding().displayName());

        if (!properties.getProperties().isEmpty()) {
            sender.setJavaMailProperties(asProperties(properties.getProperties()));
        }
    }

    private Properties asProperties(Map<String, String> source) {
        Properties properties = new Properties();
        properties.putAll(source);
        return properties;
    }

    @Bean
    @ConfigurationProperties(prefix = "authenticationcredential")
    public AuthenticationCredential authenticationCredential() {
        return new AuthenticationCredential();
    }

    @Bean
    @ConfigurationProperties(prefix = "apiurlsecuritycredential")
    public ApiUrlSecurityCredential apiUrlSecurityCredential() {
        return new ApiUrlSecurityCredential();
    }

    @Bean
    @ConfigurationProperties(prefix = "digitalpaymentcredential")
    public DigitalPaymentCredential digitalPayMentCredential() {
        return new DigitalPaymentCredential();
    }

    @Bean
    @ConfigurationProperties(prefix = "defaultvalues")
    public DefaultValues defaultValues() {
        return new DefaultValues();
    }

/*    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        System.out.println("Date in UTC: " + new Date().toString());
    }*/

}
