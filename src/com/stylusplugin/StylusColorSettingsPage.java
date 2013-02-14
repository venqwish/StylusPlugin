package com.stylusplugin;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: badabing
 * Date: 2/14/13
 * Time: 1:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class StylusColorSettingsPage implements ColorSettingsPage{
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Key", StylusSyntaxHighlighter.KEY),
            new AttributesDescriptor("Separator", StylusSyntaxHighlighter.SEPARATOR),
            new AttributesDescriptor("Value", StylusSyntaxHighlighter.VALUE),
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return StylusIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new StylusSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return  "/* Regular CSS rules apply. */\n" +
                "@import \"manual.css\";\n" +
                "h1.mystyle {\n" +
                "   color:blue; /* TODO: change THIS to yellow for next version! */\n" +
                "   font-size: 15pt;\n" +
                "   border:rgb(255,0,0);\n" +
                "   background-color: #FAFAFA;\n" +
                "   background:url(hello.jpg) !important;\n" +
                "}\n" +
                "/* Stylus keeps things clean. */\n" +
                "@import \"manual\"\n" +
                "h1.mystyle\n" +
                "   color blue /* TODO: change THIS to yellow for next version! */\n" +
                "   font-size 15pt\n" +
                "   border rgb(255,0,0)\n" +
                "   background-color #FAFAFA\n" +
                "   background url(hello.jpg) !important\n" +
                "}\n";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Stylus";
    }
}
