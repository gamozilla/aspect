package com.adesis.util.aspects;

/**
 * 
 * @author Adesis
 *
 */
public aspect ToStringAspect {

	// private static final Logger LOGGER;

//	static {
//		LOGGER = LoggerFactory.getLogger(ToStringAspect.class);
//	}

	private pointcut toStringPointcut() : execution(public * Object.toString());

	String around() :  toStringPointcut() {
		// NOTE: by default, reflectionToString do not returns transient fields.
		// System.out.println(thisJoinPointStaticPart.getClass());
		// if (thisJoinPoint.getTarget() == null) {
		// return getStaticCaseAsString(thisJoinPointStaticPart);
		// } else {
		return ToStringAspectHelper.getObjectAsString(thisJoinPoint.getTarget());
		// }
	}

	// TODO To handle static cases
	// private String getStaticCaseAsString(final JoinPoint.StaticPart
	// staticPart) {
	// throw new NotImplementedException("pending impl");
	// }

	// TODO - PMD

	private interface OverrideToString {
	}

	// NOTA: se debe declarar por cada paquete que se desee aconsejar! es un
	// bug, at least... TODO to fix.
	declare parents : com.adesis.util.aspects.* implements OverrideToString;

	public String OverrideToString.toString() {
		return super.toString();
	}

}
