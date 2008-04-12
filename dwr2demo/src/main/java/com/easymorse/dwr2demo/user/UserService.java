package com.easymorse.dwr2demo.user;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

public class UserService {

	private User user;

	public boolean hasName(String userName) {
		return false;
	}

	public void save(User user) {
		user.setId("001");
		this.user = user;

		WebContext wctx = WebContextFactory.get();

		ScriptBuffer script = new ScriptBuffer();
		script.appendScript("receiveSavedUser(").appendData(this.user)
				.appendScript(");");
		wctx.getScriptSession().addScript(script);
	}

}
