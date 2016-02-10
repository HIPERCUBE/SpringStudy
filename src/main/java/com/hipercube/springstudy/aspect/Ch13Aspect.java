package com.hipercube.springstudy.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * Copyright (c) 2/7/16 Joowon Ryoo
 * <p/>
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 * <p/>
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * <p/>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

@Component
@Aspect
public class Ch13Aspect {
    private static final Logger logger = LoggerFactory.getLogger(Ch13Aspect.class);

    @Pointcut("execution(public * com.hipercube.springstudy.controller.Ch13Controller.runtimeCheck(..))")
    private void runtimeCheck() {
    }

    @Around("runtimeCheck()")
    public Object runtimeCheckAdvice(ProceedingJoinPoint joinPoint) {
        // Before
        String signatureString = joinPoint.getSignature().toShortString();
        logger.info(signatureString + " Start");
        long start = System.nanoTime();
        Object result = null;

        // Method Execution
        try {
            result = joinPoint.proceed();
        } catch (Throwable ignored) {
        }

        // After
        long finish = System.nanoTime();
        logger.info(signatureString + " End");
        long runtime = finish - start;
        logger.info(signatureString + " Execution time: " + runtime + "ns");

        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        requestAttributes.setAttribute("runtime", runtime, RequestAttributes.SCOPE_REQUEST);

        return result;
    }

    @Pointcut("execution(public * com.hipercube.springstudy.controller.Ch13Controller.board*(..))")
    private void loginCheck() {
    }

    @Around("loginCheck()")
    public Object loginCheckAdvice(ProceedingJoinPoint joinPoint) {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        String mid = (String) requestAttributes.getAttribute("sessionMid", RequestAttributes.SCOPE_SESSION);
        if (mid == null) {
            requestAttributes.setAttribute("loginNeed", "로그인이 필요합니다.", RequestAttributes.SCOPE_REQUEST);
            return "ch13/content";
        } else {
            Object result = null;
            try {
                result = joinPoint.proceed();
            } catch (Throwable ignored) {
            }
            return result;
        }
    }
}
