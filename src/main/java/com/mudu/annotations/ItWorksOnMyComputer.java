package com.mudu.annotations;

/**
 * Created by mudu on 16/7/15.
 */
public @interface ItWorksOnMyComputer {
    String value() default "me";
}
