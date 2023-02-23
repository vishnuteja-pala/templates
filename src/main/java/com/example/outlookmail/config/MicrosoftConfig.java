//package com.example.outlookmail.config;
//
//import com.azure.identity.ClientSecretCredential;
//import com.azure.identity.ClientSecretCredentialBuilder;
//import com.microsoft.graph.authentication.TokenCredentialAuthProvider;
//import com.microsoft.graph.requests.GraphServiceClient;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Configuration
//public class MicrosoftConfig {
//
//    @Value("${MSFT_CLIENT_ID}")
//    private String clientId;
//
//    @Value("${MSFT_CLIENT_SECRET}")
//    private String clientSecret;
//
//    @Value("${MSFT_TENANT_ID}")
//    private String tenant;
//
//    final List<String> scopes = Arrays.asList("https://graph.microsoft.com/.default");
//
//    @Bean
//    public ClientSecretCredential clientSecretCredential(){
//        return new ClientSecretCredentialBuilder()
//                .clientId(clientId)
//                .clientSecret(clientSecret)
//                .tenantId(tenant)
//                .build();
//    }
//
//    @Bean
//    public TokenCredentialAuthProvider tokenCredentialAuthProvider(){
//        return  new TokenCredentialAuthProvider(scopes, clientSecretCredential());
//    }
//
//    @Bean
//    public GraphServiceClient graphServiceClient(){
//        return GraphServiceClient
//                .builder()
//                .authenticationProvider(tokenCredentialAuthProvider())
//                .buildClient();
//    }
//
//}
