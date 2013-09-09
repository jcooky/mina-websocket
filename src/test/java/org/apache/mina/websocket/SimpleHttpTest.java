package org.apache.mina.websocket;

import static org.junit.Assert.assertEquals;

import java.net.InetSocketAddress;
import java.util.Collections;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.BasicConfigurator;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.http.HttpServerCodec;
import org.apache.mina.http.api.DefaultHttpResponse;
import org.apache.mina.http.api.HttpRequest;
import org.apache.mina.http.api.HttpResponse;
import org.apache.mina.http.api.HttpStatus;
import org.apache.mina.http.api.HttpVersion;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleHttpTest {
	private Logger logger = LoggerFactory.getLogger(getClass());

	class handler implements IoHandler {
		@Override
		public void messageReceived(IoSession session, Object message) {
			HttpRequest request = (HttpRequest)message;



			HttpResponse response = new DefaultHttpResponse(HttpVersion.HTTP_1_1,
					HttpStatus.CLIENT_ERROR_NOT_FOUND,
					Collections.EMPTY_MAP);
			session.write(response);
		}

		@Override
		public void sessionCreated(IoSession session) throws Exception {
		}

		@Override
		public void sessionOpened(IoSession session) throws Exception {
		}

		@Override
		public void sessionClosed(IoSession session) throws Exception {
		}

		@Override
		public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		}

		@Override
		public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		}

		@Override
		public void messageSent(IoSession session, Object message) throws Exception {
		}
	}

	@Before
	public void setUp() {
		BasicConfigurator.configure();
	}

	@Test
	public void testHttp() throws Exception {
		NioSocketAcceptor server = new NioSocketAcceptor();

		server.setHandler(new handler());
		server.setReuseAddress(true);
		server.getSessionConfig().setReadBufferSize(2048);
		server.getFilterChain().addLast("http", new HttpServerCodec());
		server.bind(new InetSocketAddress(11024));

		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet("http://localhost:11024/");
		org.apache.http.HttpResponse response = httpclient.execute(httpget);

		assertEquals(404, response.getStatusLine().getStatusCode());
	}

}