package github.aboveaphid.taskswithbots.structure;

import net.minecraft.nbt.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StructureReader {
    public static NbtCompound read_structure_file(String filepath) {
        try {
            Path path = Paths.get(filepath);

            File file = new File(filepath);

            // Load the NBT file
            InputStream inputStream = new FileInputStream(file);

            NbtCompound structure_nbt_compound;

            // Way smarter way instead of using is_compressed parameter
            try {
                structure_nbt_compound = NbtIo.readCompressed(inputStream, NbtSizeTracker.ofUnlimitedBytes());
            } catch (Exception e) {
                structure_nbt_compound = NbtIo.read(path);
            }

            if (structure_nbt_compound == null) {
                return null;
            }

            NbtElement data_version =  structure_nbt_compound.get("DataVersion");
            NbtElement size =  structure_nbt_compound.get("size");
            NbtElement blocks =  structure_nbt_compound.get("blocks");
            NbtElement palette =  structure_nbt_compound.get("palette");
            NbtElement entities =  structure_nbt_compound.get("entities");

            System.out.println("Loaded structure: " + file.getName());
            System.out.println("Size: " + size);
            System.out.println("Blocks: " + blocks);
            System.out.println("Palette: " + palette);
            System.out.println("Entities: " + entities);
            System.out.println("Data Version: " + data_version);

            return structure_nbt_compound;

        } catch (FileNotFoundException e) {
            System.out.println("Could not find structure nbt file!");
        } catch (IOException e) {
            System.out.println("Failed to read nbt! IOException:" + e);
        }
        return null;
    }
}
