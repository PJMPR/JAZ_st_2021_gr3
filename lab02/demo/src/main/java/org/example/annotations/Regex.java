package org.example.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Regex {
    String message() default "email should be in correct format";
    String pattern() default "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$";
}
