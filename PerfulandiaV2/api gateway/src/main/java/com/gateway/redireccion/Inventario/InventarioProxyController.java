package com.gateway.redireccion.Inventario;

import org.springframework.http.HttpHeaders;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/proxy/inventario")
@RequiredArgsConstructor
public class InventarioProxyController {

    private final RestTemplate restTemplate;

    @RequestMapping(value = "/**", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    public ResponseEntity<?> proxyInventario(HttpServletRequest request,
                                             @RequestBody(required = false) String body,
                                             @RequestHeader HttpHeaders headers) {

        String baseUrl = "http://localhost:8085/api/inventario";
        String requestPath = request.getRequestURI().replace("/api/proxy/inventario", "");
        String finalUrl = baseUrl + requestPath;

        HttpMethod method = HttpMethod.valueOf(request.getMethod());

        HttpHeaders newHeaders = new HttpHeaders();
        headers.forEach((key, value) -> {
            if (!key.equalsIgnoreCase(HttpHeaders.CONTENT_LENGTH)) {
                newHeaders.put(key, value);
            }
        });

        newHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(body, newHeaders);

        try {
            ResponseEntity<String> response = restTemplate.exchange(finalUrl, method, entity, String.class);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\": \"" + ex.getMessage() + "\"}");
        }
    }
}
