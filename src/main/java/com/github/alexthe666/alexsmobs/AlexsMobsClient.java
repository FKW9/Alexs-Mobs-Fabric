package com.github.alexthe666.alexsmobs;

import com.github.alexthe666.alexsmobs.client.network.AMClientNetworking;
import com.github.alexthe666.alexsmobs.client.render.RenderMultipartCollisionPart;
import com.github.alexthe666.alexsmobs.entity.AMEntityRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class AlexsMobsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        AlexsMobs.PROXY.clientInit();
        AMClientNetworking.registerClientReceivers(); // Changed from AMNetworking
        EntityRendererRegistry.register(AMEntityRegistry.CACHALOT_PART, RenderMultipartCollisionPart::new);
        EntityRendererRegistry.register(AMEntityRegistry.GIANT_SQUID_PART, RenderMultipartCollisionPart::new);
        EntityRendererRegistry.register(AMEntityRegistry.LAVIATHAN_PART, RenderMultipartCollisionPart::new);
    }
}