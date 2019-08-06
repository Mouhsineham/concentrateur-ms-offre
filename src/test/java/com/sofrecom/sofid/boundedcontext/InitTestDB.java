package com.sofrecom.sofid.boundedcontext;

import org.springframework.test.context.TestExecutionListeners;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author sofid@sofrecom.com
 */

//TODO Include this annotation in the framework
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@TestExecutionListeners(mergeMode =
        TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS,
        listeners = {CleanupDatabaseTestExecutionListener.class}
)
public @interface InitTestDB {
}
