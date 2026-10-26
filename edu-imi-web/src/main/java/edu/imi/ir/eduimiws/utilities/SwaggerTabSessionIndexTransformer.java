package edu.imi.ir.eduimiws.utilities;

import jakarta.servlet.http.HttpServletRequest;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springdoc.core.properties.SwaggerUiOAuthProperties;
import org.springdoc.core.providers.ObjectMapperProvider;
import org.springdoc.webmvc.ui.SwaggerIndexPageTransformer;
import org.springdoc.webmvc.ui.SwaggerIndexTransformer;
import org.springdoc.webmvc.ui.SwaggerWelcomeCommon;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.servlet.resource.ResourceTransformerChain;
import org.springframework.web.servlet.resource.TransformedResource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Ties Swagger UI access to the browser tab. Closing the tab/window clears
 * {@code sessionStorage}, so the next visit must log in again even if a
 * leftover {@code JSESSIONID} cookie is still present.
 */
@Component
@Primary
public class SwaggerTabSessionIndexTransformer implements SwaggerIndexTransformer {

    private static final String TAB_FLAG = "swagger-ui-tab";

    private final SwaggerIndexPageTransformer delegate;

    public SwaggerTabSessionIndexTransformer(SwaggerUiConfigProperties swaggerUiConfig,
                                             SwaggerUiOAuthProperties swaggerUiOAuth,
                                             SwaggerWelcomeCommon swaggerWelcomeCommon,
                                             ObjectMapperProvider objectMapperProvider) {
        this.delegate = new SwaggerIndexPageTransformer(
                swaggerUiConfig, swaggerUiOAuth, swaggerWelcomeCommon, objectMapperProvider);
    }

    @Override
    public Resource transform(HttpServletRequest request, Resource resource, ResourceTransformerChain transformerChain)
            throws IOException {
        Resource transformed = delegate.transform(request, resource, transformerChain);
        String filename = transformed.getFilename();
        if (filename == null || !filename.endsWith("index.html")) {
            return transformed;
        }

        String html = StreamUtils.copyToString(transformed.getInputStream(), StandardCharsets.UTF_8);
        String contextPath = request.getContextPath() == null ? "" : request.getContextPath();
        String script = "<script>(function(){"
                + "var flag=" + toJsString(TAB_FLAG) + ";"
                + "var loginUrl=" + toJsString(contextPath + "/swagger-login") + ";"
                + "var endUrl=" + toJsString(contextPath + "/swagger-session-end") + ";"
                + "var params=new URLSearchParams(window.location.search);"
                + "if(params.get('tab')==='1'){"
                + "sessionStorage.setItem(flag,'1');"
                + "params.delete('tab');"
                + "var q=params.toString();"
                + "history.replaceState(null,'',window.location.pathname+(q?('?'+q):'')+window.location.hash);"
                + "return;"
                + "}"
                + "if(sessionStorage.getItem(flag)!=='1'){"
                + "window.location.replace(endUrl);"
                + "}"
                + "})();</script>";

        if (html.contains("</head>")) {
            html = html.replace("</head>", script + "</head>");
        } else {
            html = html.replace("<body>", "<body>" + script);
        }
        return new TransformedResource(transformed, html.getBytes(StandardCharsets.UTF_8));
    }

    private static String toJsString(String value) {
        return "'" + value.replace("\\", "\\\\").replace("'", "\\'") + "'";
    }
}
