package com.stylusplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.stylusplugin.StylusLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class StylusTokenType extends IElementType {
    public StylusTokenType(@NotNull @NonNls String debugName) {
        super(debugName, StylusLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "StylusTokenType." + super.toString();
    }
}