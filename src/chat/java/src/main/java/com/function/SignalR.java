package com.function;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

import com.microsoft.azure.functions.annotation.CustomBinding;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@CustomBinding(direction = "out", name = "$return", type = "SignalR")
public @interface SignalR {
   String hubName();
}
