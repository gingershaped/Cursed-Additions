package io.github.gingerindustries.cursedadditions.client.entities.render;

import io.github.gingerindustries.cursedadditions.CursedAdditions;
import io.github.gingerindustries.cursedadditions.client.entities.model.SuspiciousCreatureModel;
import io.github.gingerindustries.cursedadditions.entities.SuspiciousCreatureEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SuspiciousCreatureRenderer extends MobRenderer<SuspiciousCreatureEntity, SuspiciousCreatureModel<SuspiciousCreatureEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(CursedAdditions.ID, "textures/entities/suspicious_creature/texture.png");

    public SuspiciousCreatureRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new SuspiciousCreatureModel<>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(SuspiciousCreatureEntity entity) {
        return TEXTURE;
    }
}