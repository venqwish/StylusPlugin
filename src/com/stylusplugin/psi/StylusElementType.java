
package com.stylusplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.stylusplugin.StylusLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class StylusElementType extends IElementType {
    public StylusElementType(@NotNull @NonNls String debugName) {
        super(debugName, StylusLanguage.INSTANCE);
    }
}