package com.github.jcooky.troll.tomcat;

import org.apache.coyote.AbstractProtocol;
import org.apache.coyote.Adapter;
import org.apache.coyote.ProtocolHandler;
import org.apache.coyote.http11.Http11NioProtocol;
import org.apache.mina.api.IoSession;

import java.util.concurrent.Executor;

/**
 * Created with IntelliJ IDEA.
 * User: dennis
 * Date: 13. 12. 6
 * Time: 오후 2:35
 * To change this template use File | Settings | File Templates.
 */
public class MinaProtocolHandler implements ProtocolHandler {
	private Adapter adapter;

	@Override
	public void setAdapter(Adapter adapter) {
		this.adapter = adapter;
	}

	@Override
	public Adapter getAdapter() {
		return this.adapter;
	}

	@Override
	public Executor getExecutor() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void init() throws Exception {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void start() throws Exception {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void pause() throws Exception {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void resume() throws Exception {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void stop() throws Exception {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void destroy() throws Exception {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isAprRequired() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isCometSupported() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isCometTimeoutSupported() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isSendfileSupported() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}
}
