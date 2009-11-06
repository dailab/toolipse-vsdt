package com.ivistar.glt;

public class Constants {

	static final public String NAME = "HVR-Bridge";
	static final public String VERSION = "1.0.6 (18.1.2008)";
	static final public String COPYRIGHT = "(C) 2007 IVISTAR";
	static final public String TITLE = NAME + " v" + VERSION + " - " + COPYRIGHT;

	static final public String TAG_URL = "vr.config.url";
//	static final public String VALUE_URL = "http://192.168.1.230:80/action/vroomctrl_config?login=root&passwd=root&simple=true";
	static final public String VALUE_URL = "http://192.168.1.230/action/vroomctrl_config?login=glt_dai&passwd=root&simple=true";

	static final public int IPPROXY_EVENT_TIMEOUT = 10 * 60 * 1000; 	// 10 min

	static final public int MAX_STATUS_LENGTH = 100*1024;	// 100kb
	// rooms ids
	static final public String RID[]= {"10", "11", "12", "13"};
}
