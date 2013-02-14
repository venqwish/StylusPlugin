package com.stylusplugin.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.stylusplugin.StylusFileType;
import com.stylusplugin.StylusLanguage;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
/**
 * Created with IntelliJ IDEA.
 * User: badabing
 * Date: 2/14/13
 * Time: 9:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class StylusFile extends PsiFileBase{
    public StylusFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, StylusLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return StylusFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Stylus File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}
