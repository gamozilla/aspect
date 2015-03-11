package com.adesis.util.aspects;

import org.aspectj.lang.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public aspect TraceAspect {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(TraceAspect.class);

	// pointcut traced() : execution(modifier_pattern ret_type_pattern
	// type_pattern.id_pattern(..));
	pointcut traced() : execution(* *.*(..)) && !within(TraceAspect);

	before() : traced() {
		final Signature signature = thisJoinPointStaticPart.getSignature();
		LOGGER.info("Entering [" + signature.toShortString() + "]");
	}

}
