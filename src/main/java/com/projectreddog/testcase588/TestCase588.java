package com.projectreddog.testcase588;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

@Mod (modid="TestCase588" , name= "TestCase588", version="1.0")

public class TestCase588 {
	
	public  static final  String ModID ="TestCase588";
	@SubscribeEvent
	public void onInteract ( PlayerInteractEvent event ){
		if (!event.world.isRemote){
			// SEND PACKET ON PLAYER INTERACT (FROM SERVER) 
	     simpleNetworkWrapper.sendToAllAround(new CustomMessage( 1), new TargetPoint(event.world.provider.getDimensionId(), event.pos.getX() , event.pos.getY(), event.pos.getZ(), 80));
		}
	}

	@Mod.Instance( ModID)
	public static TestCase588 instance; 
	
	public static SimpleNetworkWrapper simpleNetworkWrapper;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
		//init the network code
		
		MinecraftForge.EVENT_BUS.register(this);

		simpleNetworkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel(ModID);
		simpleNetworkWrapper.registerMessage (CustomMessageHandler.class, CustomMessage.class, 0, Side.CLIENT);// message to client


		
	}
	
	
}

