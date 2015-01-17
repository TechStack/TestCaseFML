package com.projectreddog.testcase588;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class CustomMessage implements IMessage{
	public int someVar=1;
	// a simple custom Message with only 1 int as its payload.
	public CustomMessage()
	{
		
	}
	public CustomMessage(int value){
		super();
		this.someVar = value;
		
	}
	@Override
	public void fromBytes(ByteBuf buf) {
        this.someVar= buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
			buf.writeInt(this.someVar);
	}
	
}
