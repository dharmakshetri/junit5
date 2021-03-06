/*
 * Copyright 2015-2017 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.junit.platform.console.options;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.MessageFormat;

import joptsimple.ValueConversionException;
import joptsimple.ValueConverter;

class URIConverter implements ValueConverter<URI> {

	@Override
	public URI convert(String value) {
		try {
			return new URI(value);
		}
		catch (URISyntaxException e) {
			String message = MessageFormat.format("Value [{0}] is not a valid URI", value);
			throw new ValueConversionException(message, e);
		}
	}

	@Override
	public Class<? extends URI> valueType() {
		return URI.class;
	}

	@Override
	public String valuePattern() {
		return null;
	}

}
