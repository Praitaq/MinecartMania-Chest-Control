package com.afforess.minecartmaniachestcontrol.itemcontainer;

import java.util.HashSet;

import com.afforess.minecartmaniacore.utils.DirectionUtils.CompassDirection;
import com.afforess.minecartmaniacore.utils.ItemMatcher;
import com.afforess.minecartmaniacore.utils.ItemUtils;
import com.afforess.minecartmaniacore.world.SpecificMaterial;

public abstract class GenericItemContainer implements ItemContainer {
    protected String line;
    protected final HashSet<CompassDirection> directions = new HashSet<CompassDirection>(4);
    
    public GenericItemContainer(final String line, final CompassDirection direction) {
        directions.add(direction);
        this.line = line;
    }
    
    public boolean hasDirectionCondition() {
        return line.contains("+");
    }
    
    public boolean hasAmountCondition() {
        return line.contains("@");
    }
    
    public SpecificMaterial[] getRawItemList() {
        return ItemUtils.getItemStringToMaterial(line);
    }
    
    public ItemMatcher[] getMatchers(final CompassDirection direction) {
        return ItemUtils.getItemStringToMatchers(line, direction);
    }
    
    public SpecificMaterial[] getItemList(final CompassDirection direction) {
        final String[] list = { line };
        return ItemUtils.getItemStringListToMaterial(list, direction);
    }
    
    public void addDirection(final CompassDirection direction) {
        if (hasDirectionCondition()) {
            directions.add(direction);
        }
    }
}
