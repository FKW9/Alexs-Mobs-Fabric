package com.github.alexthe666.alexsmobs.network;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

/**
 * Server -> Client packet to dismount crow from player.
 */
public record MessageCrowDismount(int rider, int mount) implements CustomPacketPayload {

    public static final CustomPacketPayload.Type<MessageCrowDismount> ID =
            new CustomPacketPayload.Type<>(Identifier.fromNamespaceAndPath("alexsmobs", "crow_dismount"));

    public static final StreamCodec<RegistryFriendlyByteBuf, MessageCrowDismount> CODEC = new StreamCodec<>() {
        @Override
        public MessageCrowDismount decode(RegistryFriendlyByteBuf buf) {
            int rider = buf.readInt();
            int mount = buf.readInt();
            return new MessageCrowDismount(rider, mount);
        }

        @Override
        public void encode(RegistryFriendlyByteBuf buf, MessageCrowDismount packet) {
            buf.writeInt(packet.rider);
            buf.writeInt(packet.mount);
        }
    };

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return ID;
    }
}