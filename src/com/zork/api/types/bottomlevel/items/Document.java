package com.zork.api.types.bottomlevel.items;

import com.zork.api.types.toplevel.items.Item;

public class Document extends Item {
	public String documentWords;
	private static final String NAME = "a DOCUMENT";
	
	public Document(String documentWords) {
		super(NAME, 0);
		this.documentWords = documentWords;
	}
	
	public String getDocumentWords() {
		return documentWords;
	}
}

