package de.simonsator.partyandfriends.velocity.datadeleter.litebans;

import com.velocitypowered.api.event.Subscribe;
import de.simonsator.partyandfriends.velocity.api.events.message.SimpleMessageEvent;
import litebans.api.Database;

import java.net.SocketAddress;

public class LBBungeeMuter  {
	private final String MUTED_MESSAGE;

	public LBBungeeMuter(String pMutedMessage) {
		this.MUTED_MESSAGE = pMutedMessage;
	}

	@Subscribe
	public void onPAFChat(SimpleMessageEvent pEvent) {
		if (Database.get().isPlayerMuted(pEvent.getSender().getUniqueId(), getIP(pEvent.getSender().getPlayer().getRemoteAddress()))) {
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
