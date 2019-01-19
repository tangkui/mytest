package nettyDemo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by lenovo on 2017/4/11.
 */
public class ClientHandler extends CustomHeartbeatHandler{


    private Client client;
    public ClientHandler(Client client) {
        super("client");
        this.client = client;
    }

    @Override
    protected void handleData(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        byte[] data = new byte[byteBuf.readableBytes() - 5];
        byteBuf.skipBytes(5);
        byteBuf.readBytes(data);
        String content = new String(data);
        System.out.println("####################ClientHandler:handleData()###################");
        System.out.println(name + " get content: " + content);
    }

    @Override
    protected void handleAllIdle(ChannelHandlerContext ctx) {
        super.handleAllIdle(ctx);
        System.out.println("####################ClientHandler:handleAllIdle()###################");
        sendPingMsg(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        client.doConnect();
    }

    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {

    }
}
