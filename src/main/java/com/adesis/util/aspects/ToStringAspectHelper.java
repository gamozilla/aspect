package com.adesis.util.aspects;

import java.lang.reflect.Field;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Adesis
 *
 */
public class ToStringAspectHelper {

	private static final Logger LOGGER;

	static {
		LOGGER = LoggerFactory.getLogger(ToStringAspectHelper.class);
	}

	// TODO To handle static cases
	// private String getStaticCaseAsString(final JoinPoint.StaticPart
	// staticPart) {
	// throw new NotImplementedException("pending impl");
	// }

	static String getObjectAsString(final Object target) {
		try {
			if (target != null) {
				return getNotNullObjectAsString(target);
			}
		} catch (IllegalArgumentException e) {
			if (LOGGER.isErrorEnabled()) {
				LOGGER.error("", e);
			}
		} catch (IllegalAccessException e) {
			if (LOGGER.isErrorEnabled()) {
				LOGGER.error("", e);
			}
		}
		return null;
	}

	private static String getNotNullObjectAsString(final Object target)
			throws IllegalArgumentException, IllegalAccessException {
		final StringBuilder builder = new StringBuilder();
		for (final Field field : target.getClass().getDeclaredFields()) {
			if (!field.getName().startsWith("ajc")) {
				field.setAccessible(true);
				final Object fieldValue = field.get(target);
				if (fieldValue != null) {
					builder.append(field.getName()).append(fieldValue);
				}
			}
		}
		if (builder.length() == 0) {
			builder.append("empty");
		}
		return new ToStringBuilder(target).append(builder).toString();
	}

	// TODO - PMD

}
