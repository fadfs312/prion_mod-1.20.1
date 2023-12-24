package net.demod.prionmod.sound;

import net.demod.prionmod.PrionMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent AMBIENT_SOUND = registerSoundEvent("sound_cannibal_ambient");
    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(PrionMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds(){
        PrionMod.LOGGER.info("Registering Sounds for " + PrionMod.MOD_ID);
    }
}
