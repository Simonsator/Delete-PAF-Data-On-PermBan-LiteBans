package de.simonsator.partyandfriends.datadeleter.litebans;

import de.simonsator.partyandfriends.api.PAFExtension;
import de.simonsator.partyandfriends.api.adapter.ServerSoftware;
import litebans.api.Events;

import java.io.File;
import java.io.IOException;

public class LBDeleterPlugin extends PAFExtension {

	@Override
	public void onEnable() {
		try {
			if (getAdapter().getServerSoftware() == ServerSoftware.BUNGEECORD) {
				String mutedMessage = new LBDeleterMessages(new File(getConfigFolder(), "messages.yml"), this).getString("YouAreMuted");
				getAdapter().registerListener(new LBBungeeMuter(mutedMessage), this);
			}
			Events.get().register(new LBListener());
			registerAsExtension();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
