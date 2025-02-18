package tech.icey.creg;

import tech.icey.creg.entity.*;
import tech.icey.creg.entity.Enum;

import java.util.HashMap;

public final class Registry {
    public final String registryName;

    public final HashMap<String, Alias> aliases;
    public final HashMap<String, Constant> constants;
    public final HashMap<String, Function> functions;
    public final HashMap<String, OpaqueTypedef> opaqueTypedefs;
    public final HashMap<String, OpaqueHandle> opaqueHandles;
    public final HashMap<String, Structure> structures;
    public final HashMap<String, Bitmask> bitmasks;
    public final HashMap<String, Enum> enums;

    public Registry(
            String registryName,
            HashMap<String, Alias> aliases,
            HashMap<String, Constant> constants,
            HashMap<String, Function> functions,
            HashMap<String, OpaqueTypedef> opaqueTypedefs,
            HashMap<String, OpaqueHandle> opaqueHandles,
            HashMap<String, Structure> structures,
            HashMap<String, Bitmask> bitmasks,
            HashMap<String, Enum> enums
    ) {
        this.registryName = registryName;
        this.aliases = aliases;
        this.constants = constants;
        this.functions = functions;
        this.opaqueTypedefs = opaqueTypedefs;
        this.opaqueHandles = opaqueHandles;
        this.structures = structures;
        this.bitmasks = bitmasks;
        this.enums = enums;
    }

    public static Registry mergeRegistry(String mergedRegistryName, Registry ...registries) {
        HashMap <String, Alias> aliases = new HashMap<String, Alias>();
        HashMap <String, Constant> constants = new HashMap<String, Constant>();
        HashMap <String, Function> functions = new HashMap<String, Function>();
        HashMap <String, OpaqueTypedef> opaqueTypedefs = new HashMap<String, OpaqueTypedef>();
        HashMap <String, OpaqueHandle> opaqueHandles = new HashMap<String, OpaqueHandle>();
        HashMap <String, Structure> structures = new HashMap<String, Structure>();
        HashMap <String, Bitmask> bitmasks = new HashMap<String, Bitmask>();
        HashMap <String, Enum> enums = new HashMap<String, Enum>();

        for (Registry registry : registries) {
            aliases.putAll(registry.aliases);
            constants.putAll(registry.constants);
            functions.putAll(registry.functions);
            opaqueTypedefs.putAll(registry.opaqueTypedefs);
            opaqueHandles.putAll(registry.opaqueHandles);
            structures.putAll(registry.structures);
            bitmasks.putAll(registry.bitmasks);
            enums.putAll(registry.enums);
        }

        return new Registry(
                mergedRegistryName,
                aliases,
                constants,
                functions,
                opaqueTypedefs,
                opaqueHandles,
                structures,
                bitmasks,
                enums
        );
    }
}
