package edu.asu.lib.foxml;

import org.apache.commons.lang.time.FastDateFormat;

public class FedoraDateFormat extends FastDateFormat {

	private static final long serialVersionUID = -8902459354643880144L;

	public FedoraDateFormat() {
        super("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", null, null);
        super.init();
    }

}
