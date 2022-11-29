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
        result.addElement(LookupElementBuilder.create("Constructor", "@Constructor"));
        result.addElement(LookupElementBuilder.create("Constructor...", "@Constructor(name=\"New{{.TypeName}}\", type=\"struct\", exported=\"true\")"));

        result.addElement(LookupElementBuilder.create("Optional", "@Optional"));
        result.addElement(LookupElementBuilder.create("Optional...", "@Optional(name=\"{{.TypeName}}Option\", constructor=\"New{{.TypeName}}\", with=\"With{{.FieldName}}\", type=\"struct\", exported=\"true\")"));

        result.addElement(LookupElementBuilder.create("Builder", "@Builder"));
        result.addElement(LookupElementBuilder.create("Builder...", "@Builder(name=\"{{.TypeName}}Builder\", constructor=\"New{{.TypeName}}Builder\", build=\"{{.FieldName}}\", terminator=\"Build\", type=\"struct\", exported=\"true\")"));

        result.addElement(LookupElementBuilder.create("PostConstruct", "@PostConstruct"));
        result.addElement(LookupElementBuilder.create("PostConstruct...", "@PostConstruct(priority=\"1\")"));

        result.addElement(LookupElementBuilder.create("Init", "@Init"));
        result.addElement(LookupElementBuilder.create("Init...", "@Init(len=\"-1\", cap=\"-1\")"));

        result.addElement(LookupElementBuilder.create("Exclude", "@Exclude"));


        result.addElement(LookupElementBuilder.create("Mapper", "@Mapper"));
        result.addElement(LookupElementBuilder.create("Mapper...", "@Mapper(name=\"{{.TypeName}}Impl\")"));

        result.addElement(LookupElementBuilder.create("Mapping...", "@Mapping(target=\"\", source=\"\")"));
        result.addElement(LookupElementBuilder.create("SliceMapping...", "@SliceMapping(target=\"\", source=\"\")"));
        result.addElement(LookupElementBuilder.create("MapMapping...", "@MapMapping(target=\"\", source=\"\")"));
        result.addElement(LookupElementBuilder.create("IgnoreDefaultMapping", "@IgnoreDefaultMapping"));

        result.addElement(LookupElementBuilder.create("Mock", "@Mock"));
        result.addElement(LookupElementBuilder.create("Mock...", "@Mock(name=\"{{ .TypeName }}Mock\", sub=\"mocks\")"));

        result.addElement(LookupElementBuilder.create("Rest...", "@Rest(method=\"GET\", path=\"/\")"));
      }
    });
    //Messages.showInfoMessage("Running from go-annotation processor", "go-annotation");
  }

}
