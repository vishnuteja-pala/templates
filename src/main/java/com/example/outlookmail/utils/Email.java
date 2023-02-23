package com.example.outlookmail.utils;

import com.azure.identity.ClientSecretCredential;
import com.azure.identity.ClientSecretCredentialBuilder;
import com.microsoft.graph.authentication.TokenCredentialAuthProvider;
import com.microsoft.graph.models.*;
import com.microsoft.graph.requests.GraphServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Component
public class Email {

   String clientId ="99cd7532-f425-4e7d-8c35-805116102382";

    String clientSecret = "xbl8Q~dVvV3ldt.I1ejqhoT8-H3ghiHrgpzbdbFH";

  String tenant ="6bc0be30-e915-48c7-a295-e414c3045548";

    final List<String> scopes = Arrays.asList("https://graph.microsoft.com/.default");
    public ClientSecretCredential clientSecretCredential(){
        return new ClientSecretCredentialBuilder()
                .clientId(clientId)
                .clientSecret(clientSecret)
                .tenantId(tenant)
                .build();
    }
    public TokenCredentialAuthProvider tokenCredentialAuthProvider(){
        return  new TokenCredentialAuthProvider(scopes, clientSecretCredential());
    }
    public GraphServiceClient graphServiceClient(){
        return GraphServiceClient
                .builder()
                .authenticationProvider(tokenCredentialAuthProvider())
                .buildClient();
    }
    public void send(String subject, String messageBody, String emailAddress, ArrayList<String> emailCcList) {


        Message message = new Message();
        message.subject = subject;

        ItemBody body = new ItemBody();
        body.contentType = BodyType.HTML;
        body.content = messageBody;
        message.body = body;

        LinkedList<Recipient> toRecipientsList = new LinkedList<Recipient>();
        Recipient toRecipients = new Recipient();
        EmailAddress setEmailAddress = new EmailAddress();
        setEmailAddress.address = emailAddress;
        toRecipients.emailAddress = setEmailAddress;
        toRecipientsList.add(toRecipients);
        message.toRecipients = toRecipientsList;

//        LinkedList<Recipient> ccRecipientsList = new LinkedList<Recipient>();
//        Recipient ccRecipients = new Recipient();
//        for (String ccEmail : emailCcList) {
//            EmailAddress emailAddress1 = new EmailAddress();
//            emailAddress1.address = ccEmail;
//            ccRecipients.emailAddress = emailAddress1;
//        }
//        ccRecipientsList.add(ccRecipients);
//        message.ccRecipients = ccRecipientsList;

        boolean saveToSentItems = true;

        graphServiceClient().users("kailash.m@beehyv.com")
                .sendMail(UserSendMailParameterSet
                        .newBuilder()
                        .withMessage(message)
                        .withSaveToSentItems(saveToSentItems)
                        .build())
                .buildRequest()
                .post();
    }
}
