package com.greenone.lostheroes.common.potions;

import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;

public class LHEffect extends Effect {
    protected LHEffect(EffectType typeIn, int liquidColorIn) {
        super(typeIn, liquidColorIn);
    }

    protected LHEffect() {
        super(EffectType.BENEFICIAL, 25520646);
    }

    @Override
    public boolean isDurationEffectTick(int p_76397_1_, int p_76397_2_) {
        return true;
    }

    @Override
    public boolean shouldRender(EffectInstance effect) {
        return !(effect.getDuration()<=35);
    }

    @Override
    public boolean shouldRenderHUD(EffectInstance effect) {
        return !(effect.getDuration()<=35);
    }

    @Override
    public boolean shouldRenderInvText(EffectInstance effect) {
        return !(effect.getDuration()<=35);
    }
}