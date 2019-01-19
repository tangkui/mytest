package test;


import client.ConnectionManager;

import java.io.IOException;

/**
 * 测试心跳包的简单客户端程序
 * <p>
 * Created by tanghao on 2017/4/10.
 */
public class TestClient {

	public static void main(String[] args) throws IOException {
		ConnectionManager.createConnection("localhost", 65432);
	}

}