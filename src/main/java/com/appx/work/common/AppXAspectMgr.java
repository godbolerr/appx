package com.appx.work.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

//TODO Add methods for authorization checks and other related aspects

@Aspect
@Component
public class AppXAspectMgr {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppXAspectMgr.class);

    @Around("execution(* com.appx..*Service.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {

        LOGGER.debug("Entering method: " + pjp);

        Object[] args = pjp.getArgs();

        if (args.length > 0) {

            for (int i = 0; i < args.length; i++) {
                LOGGER.debug("Arg" + (i + 1) + ":" + args[i]);
            }
        }

        StopWatch sw = new StopWatch(getClass().getSimpleName());
        try {
            sw.start(pjp.getSignature().getName());
            return pjp.proceed();
        } finally {
            sw.stop();
            LOGGER.debug(sw.prettyPrint());
        }

    }

}
