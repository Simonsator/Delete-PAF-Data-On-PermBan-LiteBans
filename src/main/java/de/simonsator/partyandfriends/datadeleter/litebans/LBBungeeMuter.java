package de.simonsator.partyandfriends.datadeleter.litebans;

import de.simonsator.partyandfriends.api.events.message.SimpleMessageEvent;
import litebans.api.Database;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.net.SocketAddress;

public class LBBungeeMuter implements Listener {
	private final String MUTED_MESSAGE;

	public LBBungeeMuter(String pMutedMessage) {
		this.MUTED_MESSAGE = pMutedMessage;
	}

	@EventHandler
	public void onPAFChat(SimpleMessageEvent pEvent) {
		if (Database.get().isPlayerMuted(pEvent.getSender().getUniqueId(), getIP(pEvent.getSender().getPlayer().getSocketAddress()))) {
			pEvent.setCancelled(true);
			pEvent.getSender().sendMessage(MUTED_MESSAGE);
		}
	}

	private String getIP(SocketAddress socketAddress) {
		if (socketAddress == null) {
			return null;
		}
		String address = socketAddress.toString();
		return socketAddress.toString().substring(1, address.indexOf(':'));
	}
}
