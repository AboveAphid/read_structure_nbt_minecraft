package github.aboveaphid.taskswithbots.structure;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.network.packet.Packet;

public class Read_All_Blocks_Example {
    public static void example() {
        NbtCompound structure_nbt_compound = StructureReader.read_structure_file(
                "PATH_TO_NBT_FILE.nbt" // E.g. "./basic_house.nbt"
        );

        if (structure_nbt_compound != null) {
            /*
            IDs for each type:
                1: Byte (byte)
                2: Short (short)
                3: Int (int)
                4: Long (long)
                5: Float (float)
                6: Double (double)
                7: Byte Array (byte[])
                8: String (String)
                9: List (List<NbtElement>)
                10: Compound (NbtCompound)
                11: Int Array (int[])
                12: Long Array (long[])
             */
            NbtList blocks = structure_nbt_compound.getList("blocks", 10);
            NbtList palette = structure_nbt_compound.getList("palette", 10);

            for (int i = 0; i < blocks.size(); i++) {
                NbtCompound block = blocks.getCompound(i);

                // Get the block's pos
                NbtList pos = block.getList("pos", 3); // 3 = INT type
                int x = pos.getInt(0);
                int y = pos.getInt(1);
                int z = pos.getInt(2);

                // Get block state (this is to reference the palette list to get more info on the block)
                int stateIndex = block.getInt("state");

                // Use palette to get the block id - Use the state_index in the "blocks" -> to get the Name in the "palette"
                NbtCompound blockState = palette.getCompound(stateIndex);
                String block_id = blockState.getString("Name");

                // Check for specific properties
                String axis = null;
                String facing = null;
                String waterlogged = null;
                if (blockState.contains("Properties")) {
                    NbtCompound properties = blockState.getCompound("Properties");

                    if (properties.contains("axis")) {
                        axis = properties.getString("axis");
                    }
                    if (properties.contains("facing")) {
                        facing = properties.getString("facing");
                    }
                    if (properties.contains("waterlogged")) {
                        waterlogged = properties.getString("waterlogged"); // For some reason it's a bool as a string..
                    }
                }

                // Print out block information
                String added_info = "";
                if (axis != null) {
                    added_info += " | with axis " + axis;
                }
                if (facing != null) {
                    added_info += " | facing in direction " + facing;
                }
                if (waterlogged != null) {
                    added_info += " | its waterlogged value is " + waterlogged;
                }

                System.out.println("Block at (" + x + ", " + y + ", " + z + "): " + block_id + added_info);
            }
        }
    }
}
