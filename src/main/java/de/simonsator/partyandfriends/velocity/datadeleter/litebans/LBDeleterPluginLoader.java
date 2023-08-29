package de.simonsator.partyandfriends.velocity.datadeleter.litebans;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Dependency;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import de.simonsator.partyandfriends.velocity.VelocityExtensionLoadingInfo;
import de.simonsator.partyandfriends.velocity.main.PAFPlugin;

import java.nio.file.Path;
import java.util.logging.Logger;

@Plugin(id = "delete-paf-data-on-perm-ban-litebans-loader", name = "Delete-PAF-Data-On-Perm-Ban-LiteBans Loader", version = "1.0.1-SNAPSHOT",
		description = "Loads Delete-PAF-Data-On-Perm-Ban-LiteBans", authors = {"Simonsator"}, dependencies = {@Dependency(id = "partyandfriends"), @Dependency(id = "litebans")})
public class LBDeleterPluginLoader {
	private final ProxyServer proxyServer;
	private final Path folder;

	@Inject
	public LBDeleterPluginLoader(ProxyServer server, Logger logger, @DataDirectory final Path folder) {
		proxyServer = server;
		this.folder = folder;
	}

	@Subscribe
	public void onProxyInitialization(ProxyInitializeEvent event) {
		PAFPlugin.loadExtension(new VelocityExtensionLoadingInfo(new LBDeleterPlugin(folder),
				"delete-paf-data-on-perm-ban-litebans", "Delete-PAF-Data-On-Perm-Ban-LiteBans", "1.0.1-SNAPSHOT", "Simonsator"));
	}
}
