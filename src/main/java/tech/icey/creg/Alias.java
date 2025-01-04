package tech.icey.creg;

import tech.icey.creg.entity.Entity;

public final class Alias extends Entity {
    public final String target;

    public Alias(String name, String target) {
        super(name);
        this.target = target;
    }
}
