package com.function;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.signalr.*;
import com.microsoft.azure.functions.signalr.annotation.*;
import com.microsoft.azure.functions.*;

public class Functions {
    @FunctionName("negotiate")
    public SignalRConnectionInfo negotiate(
            @HttpTrigger(
                name = "req",
                methods = { HttpMethod.POST },
                authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> req,
            @SignalRConnectionInfoInput(
                name = "connectionInfo",
                hubName = "chat") SignalRConnectionInfo connectionInfo) {
                
        return connectionInfo;
    }

    @FunctionName("messages")
    @SignalROutput(name = "$return", hubName = "chat")
    public SignalRMessage sendMessage(
            @HttpTrigger(
                name = "req", 
                methods = { HttpMethod.POST },
                authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Object> req) {
        
        Object message = req.getBody();
        return new SignalRMessage("newMessage", message);
    }
}
