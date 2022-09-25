package com.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Constants {
//	public static DataSource DATASOURCE;
	public static final Gson GSON = new GsonBuilder().setDateFormat("yyy-MM-dd").create();
//	public static final Gson GSON = new GsonBuilder().create();
	public static final String JSON_MIME_TYPE = "application/json";
	public static final String PREFIX_WEB_INF = "/WEB-INF";
}
