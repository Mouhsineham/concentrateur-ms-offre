package com.sofrecom.sofid.boundedcontext;

import liquibase.exception.LiquibaseException;
import liquibase.integration.spring.SpringLiquibase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

/**
 * Test listener that cleans the database and re-run liquibase before each test method for test classes annotated with {@link InitTestDB}
 *
 * @author sofid@sofrecom.com
 */
//TODO Include this class in the framework
@Slf4j
public class CleanupDatabaseTestExecutionListener
        extends AbstractTestExecutionListener {

    private boolean alreadyCleared = false;

    public final int getOrder() {
        return 2001;
    }

    @Override
    public void prepareTestInstance(TestContext testContext) throws Exception {
        if (!alreadyCleared) {
            cleanupDatabase(testContext);
            alreadyCleared = true;
        } else {
            alreadyCleared = true;
        }
    }

    @Override
    public void beforeTestMethod(TestContext testContext) throws Exception {
        if (testContext.getTestClass().getAnnotation(InitTestDB.class) != null) {
            log.debug("Clean test database");
            cleanupDatabase(testContext);
        }
        super.beforeTestMethod(testContext);
    }

    private void cleanupDatabase(TestContext testContext) throws LiquibaseException {
        ApplicationContext app = testContext.getApplicationContext();
        SpringLiquibase springLiquibase = app.getBean(SpringLiquibase.class);
        springLiquibase.setDropFirst(true);
        springLiquibase.afterPropertiesSet(); //The database get recreated here
    }
}
