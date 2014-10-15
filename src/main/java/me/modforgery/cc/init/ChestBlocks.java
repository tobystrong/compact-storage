package me.modforgery.cc.init;

import cpw.mods.fml.common.registry.GameRegistry;
import me.modforgery.cc.block.*;
import me.modforgery.cc.tileentity.*;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;

/**
 * Created by Toby on 19/08/2014.
 */
public class ChestBlocks
{
    public static Block doubleChest;
    public static Block tripleChest;
    public static Block quadrupleChest;
    public static Block quintupleChest;
    public static Block sextupleChest;

    public static void init()
    {
        doubleChest = new BlockDoubleChest();
        GameRegistry.registerBlock(doubleChest, "doubleChest");
        GameRegistry.registerTileEntity(TileEntityDoubleChest.class, "doubleChest");

        tripleChest = new BlockTripleChest();
        GameRegistry.registerBlock(tripleChest, "tripleChest");
        GameRegistry.registerTileEntity(TileEntityTripleChest.class, "tripleChest");

        quadrupleChest = new BlockQuadrupleChest();
        GameRegistry.registerBlock(quadrupleChest, "quadrupleChest");
        GameRegistry.registerTileEntity(TileEntityQuadrupleChest.class, "quadrupleChest");

        quintupleChest = new BlockQuintupleChest();
        GameRegistry.registerBlock(quintupleChest, "quintupleChest");
        GameRegistry.registerTileEntity(TileEntityQuintupleChest.class, "quintupleChest");

        sextupleChest = new BlockSextupleChest();
        GameRegistry.registerBlock(sextupleChest, "sextupleChest");
        GameRegistry.registerTileEntity(TileEntitySextupleChest.class, "sextupleChest");
    }
}
