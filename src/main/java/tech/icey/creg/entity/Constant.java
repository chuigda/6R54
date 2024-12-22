package tech.icey.creg.entity;

import tech.icey.creg.type.IdentifierType;

public final class Constant extends Entity {
    public final String expr;
    public final IdentifierType type;

    public Constant(String name, String expr, IdentifierType type) {
        super(name);
        this.expr = expr;
        this.type = type;
    }

    public Constant(String name, String expr) {
        this(name, expr, null);
    }
}
