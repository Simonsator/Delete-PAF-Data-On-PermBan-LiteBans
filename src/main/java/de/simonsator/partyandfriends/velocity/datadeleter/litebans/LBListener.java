package de.simonsator.partyandfriends.velocity.datadeleter.litebans;

import de.simonsator.partyandfriends.api.pafplayers.PAFPlayerManager;
import litebans.api.Entry;
import litebans.api.Events;

public class LBListener extends Events.Listener {
	@Override
	public void entryAdded(Entry entry) {
		if (entry.isPermanent() && entry.getType().equals("ban")) {
			PAFPlayerManager.getInstance().getPlayer(entry.getUuid()).deleteAccount();
		}
	}
}
