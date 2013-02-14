// This is a generated file. Not intended for manual editing.
package com.stylusplugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.stylusplugin.psi.StylusTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.stylusplugin.psi.*;

public class StylusPropertyImpl extends ASTWrapperPsiElement implements StylusProperty {

  public StylusPropertyImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof StylusVisitor) ((StylusVisitor)visitor).visitProperty(this);
    else super.accept(visitor);
  }

}
