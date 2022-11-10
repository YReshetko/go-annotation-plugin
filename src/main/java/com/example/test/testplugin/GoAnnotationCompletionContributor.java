package com.example.test.testplugin;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class GoAnnotationCompletionContributor extends CompletionContributor {


  public GoAnnotationCompletionContributor() {

    extend(CompletionType.BASIC, PlatformPatterns.psiComment(), new CompletionProvider<>() {
      @Override
      protected void addCompletions(
          @NotNull final CompletionParameters parameters,
          @NotNull final ProcessingContext context,
          @NotNull final CompletionResultSet result
      ) {
        result.addElement(LookupElementBuilder.create("My completion for go-annotation", "Short"));
        result.addElement(LookupElementBuilder.create("My another option", "Another"));
      }
    });
    //Messages.showInfoMessage("Running from go-annotation processor", "go-annotation");
  }

}
