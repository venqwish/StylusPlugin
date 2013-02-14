/**
 * Created with IntelliJ IDEA.
 * User: badabing
 * Date: 2/12/13
 * Time: 8:07 PM
 * To change this template use File | Settings | File Templates.
 */
package com.stylusplugin;

import com.intellij.lang.Language;

public class StylusLanguage extends Language {
    public static final StylusLanguage INSTANCE = new StylusLanguage();

    private StylusLanguage() {
        super("Stylus");
    }
}
