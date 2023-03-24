package de.maxhenkel.voicechat.integration.freecam;

import de.maxhenkel.voicechat.VoicechatClient;
import net.minecraft.client.Minecraft;
import net.minecraft.world.phys.Vec3;

public class FreecamUtil {

    private static final Minecraft mc = Minecraft.getInstance();

    /**
     * @return whether freecam is currently in use
     */
    public static boolean isFreecamEnabled() {
        // FIXME once testing is complete, remove `freecamSupport` config option
        return VoicechatClient.CLIENT_CONFIG.freecamSupport.get() &&
                !(mc.player.isSpectator() || mc.player.equals(mc.getCameraEntity()));
    }

    /**
     * Gets the proximity reference point. Unless freecam is active, this is the main camera's position.
     *
     * @return the position distances should be measured from
     */
    public static Vec3 getReferencePoint() {
        return isFreecamEnabled() ?
                mc.player.getEyePosition() : mc.gameRenderer.getMainCamera().getPosition();
    }
}
