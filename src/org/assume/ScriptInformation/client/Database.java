package org.assume.ScriptInformation.client;

import java.util.HashMap;
import java.util.Map;

import scripts.ScriptStatus;

public class Database {

	public static Map<String, ScriptStatus> map = new HashMap<String, ScriptStatus>();

	public void update(String userName, ScriptStatus status) {
		if (userName != null) {
			if (!map.containsKey(userName)) {
				map.put(userName, status);
			} else {
				map.remove(userName);
				map.put(userName, status);
			}
		}
	}
}
