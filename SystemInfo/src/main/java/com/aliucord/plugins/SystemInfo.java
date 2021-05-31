package com.aliucord.plugins;

import android.content.Context;
import android.os.Build;

import androidx.annotation.NonNull;

import com.aliucord.api.CommandsAPI;
import com.aliucord.entities.MessageEmbed;
import com.aliucord.entities.Plugin;

import java.util.Collections;

@SuppressWarnings("unused")
public class SystemInfo extends Plugin {
    @NonNull
    @Override
    public Manifest getManifest() {
        Manifest manifest = new Manifest();
        manifest.authors = new Manifest.Author[]{ new Manifest.Author("Möth", 289556910426816513L) };
        manifest.description = "System Info";
        manifest.version = "1.0.1";
        manifest.updateUrl = "https://raw.githubusercontent.com/litleck/aliucord-plugins/builds/updater.json";
        return manifest;
    }

    @Override
    public void start(Context context) {
        commands.registerCommand("system-info", "Get system information", Collections.emptyList(), args -> {
            MessageEmbed embed = new MessageEmbed();

            embed.setTitle("System Information");
            embed.setColor(0x00FFA200);
            embed.addField("Brand:", Build.BRAND, true);
            embed.addField("Version:", Build.VERSION.RELEASE, true);
            embed.addField("Codename:", Build.VERSION.CODENAME, true);

            return new CommandsAPI.CommandResult(null, Collections.singletonList(embed), false);
        });
    }

    @Override
    public void stop(Context context) {
        commands.unregisterAll();
    }
}