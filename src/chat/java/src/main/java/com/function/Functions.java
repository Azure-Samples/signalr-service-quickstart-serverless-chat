package com.function;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

public class Functions {
    @FunctionName("negotiate")
    public ConnectionInfo negotiate(
            @HttpTrigger(
                name = "req", 
                methods = { HttpMethod.POST, HttpMethod.GET },
                authLevel = AuthorizationLevel.ANONYMOUS) 
                HttpRequestMessage<Optional<String>> req,
            @SignalRConnectionInfo(hubName = "chat") ConnectionInfo connectionInfo) {
                
        return connectionInfo;
    }

    @FunctionName("messages")
    @SignalR(hubName = "chat")
    public SignalRMessage newMessage(
            @HttpTrigger(
                name = "req", 
                methods = { HttpMethod.POST },
                authLevel = AuthorizationLevel.ANONYMOUS) 
                HttpRequestMessage<Object> req) {

        return new SignalRMessageBuilder("newMessage")
            .addArgument(req.getBody())
            .build();
    }
}
