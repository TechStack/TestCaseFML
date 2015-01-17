package com.projectreddog.testcase588;

import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import org.apache.logging.log4j.Level;

public class CustomMessageHandler implements IMessageHandler<CustomMessage,IMessage>{
// Simple network handler only will log a message was received
	@Override
	public IMessage onMessage(CustomMessage message, MessageContext ctx) {
		net.minecraftforge.fml.common.FMLLog.log(TestCase588.ModID, Level.INFO, String.valueOf("Message Received"));

		return null;
	}
	
}