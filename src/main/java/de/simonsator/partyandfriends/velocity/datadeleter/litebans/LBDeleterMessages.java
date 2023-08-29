package de.simonsator.partyandfriends.velocity.datadeleter.litebans;

import de.simonsator.partyandfriends.api.PAFPluginBase;
import de.simonsator.partyandfriends.utilities.Language;
import de.simonsator.partyandfriends.utilities.LanguageConfiguration;

import java.io.File;
import java.io.IOException;

public class LBDeleterMessages extends LanguageConfiguration {

	protected LBDeleterMessages(File file, PAFPluginBase pPlugin) throws IOException {
		super(Language.ENGLISH, file, pPlugin, true);
		copyFromJar();
		readFile();
		saveFile();
		process();
	}
}
