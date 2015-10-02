package com.earl.util;

import com.google.gson.Gson;

public class ToJson {
	private volatile static Gson gson;

	private ToJson() {

	}

	/**
	 *单列获取gson
	 *
	 * @return the gson
	 */
	public static final Gson getGson() {
		if (gson == null) {
			synchronized (ToJson.class) {
				if (gson == null) {
					gson = new Gson();
				}
			}
		}
		return gson;
	}
}
