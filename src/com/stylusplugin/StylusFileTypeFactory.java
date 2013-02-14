package com.stylusplugin;

/**
 * Created with IntelliJ IDEA.
 * User: badabing
 * Date: 2/12/13
 * Time: 8:16 PM
 * To change this template use File | Settings | File Templates.
 */

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class StylusFileTypeFactory extends FileTypeFactory{
    @Override
    public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer) {
        fileTypeConsumer.consume(StylusFileType.INSTANCE, "styl");
    }
}
