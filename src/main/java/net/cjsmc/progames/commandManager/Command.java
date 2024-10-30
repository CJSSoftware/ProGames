package net.cjsmc.progames.commandManager;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Command {
    String name();
    String subcommand() default "";
    String description() default "";
}