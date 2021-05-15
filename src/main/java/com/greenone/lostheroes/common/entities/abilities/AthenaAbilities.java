package com.greenone.lostheroes.common.entities.abilities;

import com.greenone.lostheroes.common.capabilities.CapabilityRegistry;
import com.greenone.lostheroes.common.capabilities.IPlayerCap;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class AthenaAbilities extends AbstractAbility{
    @Override
    public void mainAbility(PlayerEntity player) {
        IPlayerCap playerCap = player.getCapability(CapabilityRegistry.PLAYERCAP, null).orElse(null);
        if(player.isSteppingCarefully()){
            //TODO Add personal crafting
        }else if(playerCap.getMana()>0){
            float repairPoints = playerCap.getMana() * 100;
            for(ItemStack stack : player.inventory.items){
                if(repairPoints > 0 && stack.isDamaged()){
                    int repairAmt = stack.getMaxDamage() - stack.getDamageValue();
                    if(repairPoints > repairAmt){
                        stack.setDamageValue(0);
                        repairPoints -= repairAmt;
                    }else{
                        stack.setDamageValue((int) (stack.getDamageValue()-repairPoints));
                        repairPoints=0;
                    }
                }
            }
            if(!player.isCreative()){ playerCap.setMana(repairPoints/100);}
        }
    }

    @Override
    public void minorAbility(PlayerEntity player) {

    }
}