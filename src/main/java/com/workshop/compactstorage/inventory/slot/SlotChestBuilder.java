package com.workshop.compactstorage.inventory.slot;

import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.workshop.compactstorage.tileentity.TileEntityChestBuilder;

public class SlotChestBuilder extends Slot
{
	public TileEntityChestBuilder builder;
	
	public SlotChestBuilder(TileEntityChestBuilder builder, int id, int x, int y) 
	{
		super(builder, id, x, y);
		this.builder = builder;
	}

	@Override
	public boolean isItemValid(ItemStack stack) 
	{
		return builder.isItemValidForSlot(slotNumber, stack);
	}
}
