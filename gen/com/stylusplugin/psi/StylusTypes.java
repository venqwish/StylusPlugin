// This is a generated file. Not intended for manual editing.
package com.stylusplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.stylusplugin.psi.impl.*;

public interface StylusTypes {

  IElementType PROPERTY = new StylusElementType("PROPERTY");

  IElementType COMMENT = new StylusTokenType("COMMENT");
  IElementType CRLF = new StylusTokenType("CRLF");
  IElementType KEY = new StylusTokenType("KEY");
  IElementType SEPARATOR = new StylusTokenType("SEPARATOR");
  IElementType VALUE = new StylusTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == PROPERTY) {
        return new StylusPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
