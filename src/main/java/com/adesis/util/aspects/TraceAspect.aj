package com.adesis.util.aspects;

import org.aspectj.lang.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public aspect TraceAspect {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(TraceAspect.class);

	// XXX No jala pointcut getter() : get(public * *);
	pointcut getter() : execution(public * *.get*());

	pointcut setter() : execution(public * *.set*());

	// This version shows more details in program flow, even if it's not very
	// well formatted - pointcut traced() : !within(TraceAspect) && !getter() &&
	// !setter();
	pointcut traced() : execution(* *.*(..)) && !within(TraceAspect) && !getter() && !setter();

	before() : traced() {
		final Signature signature = thisJoinPointStaticPart.getSignature();
		LOGGER.info("Entering [" + signature.toShortString() + "]");
	}

}
