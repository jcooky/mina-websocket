package com.github.jcooky.troll.tomcat;

import org.apache.coyote.AbstractProtocol;
import org.apache.coyote.Adapter;
import org.apache.coyote.ProtocolHandler;
import org.apache.coyote.http11.Http11NioProtocol;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.apache.mina.api.IoSession;
import org.apache.tomcat.util.net.*;

import javax.net.ssl.SSLEngine;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MinaProtocol implements ProtocolHandler {
	private static final Log log = LogFactory.getLog(MinaProtocol.class);

	private Adapter adapter;
	private Executor executor = Executors.newScheduledThreadPool(5);

	@Override
	public void setAdapter(Adapter adapter) {
		this.adapter = adapter;
	}

	@Override
	public Adapter getAdapter() {
		return adapter;
	}

	@Override
	public Executor getExecutor() {
		return executor;
	}

	@Override
	public void init() throws Exception {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void start() throws Exception {

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
