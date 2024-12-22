package tech.icey.creg.entity;

public abstract sealed class Entity permits
        Bitflag,
        Bitmask,
        Constant,
        Enum,
        Function,
        FunctionTypedef,
        Member,
        OpaqueHandle,
        OpaqueTypedef,
        Param,
        Structure,
        Variant
{
    public final String name;

    protected Entity(String name) {
        this.name = name;
    }

    public final <T> void setExtra(T extra) {
        assert this.extra == null;
        this.extra = extra;
    }

    public final <T> T getExtra() {
        if (extra == null) {
            return null;
        }

        //noinspection unchecked
        return (T) extra;
    }

    private Object extra = null;
}
