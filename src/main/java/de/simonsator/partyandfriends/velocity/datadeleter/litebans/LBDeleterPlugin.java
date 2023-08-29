package de.simonsator.partyandfriends.velocity.datadeleter.litebans;

import de.simonsator.partyandfriends.velocity.api.PAFExtension;
import de.simonsator.partyandfriends.velocity.api.adapter.ServerSoftware;
import litebans.api.Events;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class LBDeleterPlugin extends PAFExtension {

	public LBDeleterPlugin(Path folder) {
		super(folder);
	}

	@Override
	public void onEnable() {
		try {
			if (getAdapter().getServerSoftware() == ServerSoftware.VELOCITY) {
				String mutedMessage = new LBDeleterMessages(new File(getConfigFolder(), "messages.yml"), this).getString("YouAreMuted");
				getAdapter().registerListener(new LBBungeeMuter(mutedMessage), this);
			}
			Events.get().register(new LBListener());
			registerAsExtension();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getName() {
		return "Delete-PAF-Data-On-Perm-Ban-LiteBans";
	}

}
