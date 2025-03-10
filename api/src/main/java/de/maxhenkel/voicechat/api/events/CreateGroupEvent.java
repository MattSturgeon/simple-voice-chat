package de.maxhenkel.voicechat.api.events;

import de.maxhenkel.voicechat.api.Group;
import de.maxhenkel.voicechat.api.VoicechatConnection;

import javax.annotation.Nullable;

public interface CreateGroupEvent extends GroupEvent {

    /**
     * @return the group that was created
     */
    Group getGroup();

    /**
     * @return the connection of the player that created the group - <code>null</code> if the group was created programmatically
     */
    @Nullable
    VoicechatConnection getConnection();

}
