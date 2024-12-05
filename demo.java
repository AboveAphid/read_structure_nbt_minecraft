import net.minecraft.nbt.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StructureReader {
    public static NbtCompound read_structure_file(String filepath, boolean is_compressed) {
        try {
            Path path = Paths.get(filepath);

            File file = new File(filepath);

            // Load the NBT file
            InputStream inputStream = new FileInputStream(file);

            NbtCompound structure_nbt_compound;
            if (is_compressed) {
                structure_nbt_compound = NbtIo.readCompressed(inputStream, NbtSizeTracker.ofUnlimitedBytes());
            } else {
                structure_nbt_compound = NbtIo.read(path);
            }

            if (structure_nbt_compound == null) {
                return null;
            }

            NbtElement data_version =  structure_nbt_compound.get("DataVersion");
            NbtElement size =  structure_nbt_compound.get("size");
            NbtElement blocks =  structure_nbt_compound.get("blocks");
            NbtElement entities =  structure_nbt_compound.get("entities");

            System.out.println("Loaded structure: " + file.getName());
            System.out.println("Size: " + size);
            System.out.println("Blocks: " + blocks);
            System.out.println("Entities: " + entities);
            System.out.println("Data Version: " + data_version);

            return structure_nbt_compound;

        } catch (FileNotFoundException e) {
            System.out.println("Could not find structure nbt file!");
        } catch (IOException e) {
            System.out.println("Failed to read nbt!");
        }
        return null;
    }
}




/*
The to call it in another script you would simply use:

StructureReader.read_structure_file(
    "PATH_TO_NBT_FILE", // E.g. ".\generated\\minecraft\\structures\\house.nbt"
    true // If the file is compressed or not
);

*/
