package me.modforgery.cc.server;

import me.modforgery.cc.itementity.ItemEntityChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import java.util.ArrayList;

/**
 * Created by Toby on 19/08/2014.
 */
public abstract class ContainerChest extends Container
{
    public EntityPlayer player;
    public World world;

    public int x;
    public int y;
    public int z;

    public IInventory chest;

    public int lastID = 0;

    public ArrayList<Slot> playerSlots;
    public ArrayList<Slot> chestSlots;

    public int xSize;
    public int zSize;

    public ContainerChest(EntityPlayer player, World world, int x, int y, int z, boolean item, int xSize, int zSize, int xStart, int zStart, int xInvStart, int zInvStart, int xHotStart, int zHotStart)
    {
        this.player = player;
        this.world = world;

        this.x = x;
        this.y = y;
        this.z = z;

        this.zSize = zSize;
        this.xSize = xSize;

        playerSlots = new ArrayList<Slot>();
        chestSlots = new ArrayList<Slot>();

        if(!item)
        {
            ((IInventory) world.getTileEntity(x, y, z)).openInventory();

            chest = (IInventory) world.getTileEntity(x, y, z);

            initializeContainer(player, (IInventory) world.getTileEntity(x, y, z), xSize, zSize, xStart, zStart, xInvStart, zInvStart, xHotStart, zHotStart);
        }
        else
        {
            ItemStack stack = player.getHeldItem();
            
            chest = (IInventory) new ItemEntityChest(8, stack);
            chest.openInventory();

            initializeContainer(player, chest, xSize, zSize, xStart, zStart, xInvStart, zInvStart, xHotStart, zHotStart);
        }
    }


    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int sourceSlot)
    {
        ChatComponentText chat = new ChatComponentText("\u00a7cShift Clicking is not implemented yet.");
        player.addChatComponentMessage(chat);

        return null;
    }

    @Override
    public void onContainerClosed(EntityPlayer player)
    {
        super.onContainerClosed(player);
        chest.closeInventory();
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return true;
    }

    public void initializeContainer(EntityPlayer player, IInventory inventory, int xSize, int zSize, int xStart, int zStart, int xInvStart, int zInvStart, int xHotStart, int zHotStart)
    {
        for(int slot = 0; slot < 9; slot++)
        {
            Slot s = new Slot(player.inventory, slot, xHotStart + (slot * 18), zHotStart);

            addSlotToContainer(s);
        }

        for(int x = 0; x < 9; x++)
        {
            for(int y = 0; y < 3; y++)
            {
                Slot s = new Slot(player.inventory, x + y * 9 + 9, xInvStart + (x * 18), zInvStart + (y * 18));
                addSlotToContainer(s);
            }
        }

        int id = 0;

        for(int x = 0; x < xSize; x++)
        {
            for(int y = 0; y < zSize; y++)
            {
                Slot slot = new Slot(chest, id, xStart + (x * 18), zStart + (y * 18));
                addSlotToContainer(slot);

                System.out.println("Adding slot at: " + id + " and x: " + x + " y: " + y);

                id++;
            }
        }

        this.lastID = id;
    }
}
