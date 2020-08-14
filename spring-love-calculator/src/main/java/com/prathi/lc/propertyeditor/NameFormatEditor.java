package com.prathi.lc.propertyeditor;

import java.beans.PropertyEditorSupport;

public class NameFormatEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String name) throws IllegalArgumentException {

		String text = name.toUpperCase();

		setValue(text);
	}

}
