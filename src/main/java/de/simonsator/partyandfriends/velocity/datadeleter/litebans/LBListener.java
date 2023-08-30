package de.simonsator.partyandfriends.velocity.datadeleter.litebans;

import de.simonsator.partyandfriends.velocity.api.pafplayers.PAFPlayerManager;
import litebans.api.Entry;
import litebans.api.Events;

import java.util.UUID;

public class LBListener extends Events.Listener {
	@Override
	public void entryAdded(Entry entry) {
		String stringUUID = entry.getUuid();
		if (entry.isPermanent() && entry.getType().equals("ban") && stringUUID != null) {
			PAFPlayerManager.getInstance().getPlayer(UUID.fromString(stringUUID)).deleteAccount();
		}
	}
}
