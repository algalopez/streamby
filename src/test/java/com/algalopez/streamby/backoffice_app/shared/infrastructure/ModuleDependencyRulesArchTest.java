package com.algalopez.streamby.backoffice_app.shared.infrastructure;

import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import com.tngtech.archunit.library.dependencies.SliceRule;
import com.tngtech.archunit.library.dependencies.SlicesRuleDefinition;
import org.junit.jupiter.api.Test;

class ModuleDependencyRulesArchTest {

  private static final JavaClasses CLASSES =
      new ClassFileImporter()
          .importPackages("com.algalopez.streamby.backoffice_app");

  @Test
  void modules_shouldHaveNoCyclicDependencies() {
    SliceRule sliceRule =
        SlicesRuleDefinition.slices()
            .matching("..streamby.backoffice_app.(*)..")
            .should()
            .beFreeOfCycles();

    sliceRule.allowEmptyShould(true).check(CLASSES);
  }

  @Test
  void sharedModule_shouldNotAccessOtherModules() {
    DescribedPredicate<JavaClass> sharedModuleAccessAllowed =
        JavaClass.Predicates.resideOutsideOfPackages("..streamby.backoffice_app..")
            .or(JavaClass.Predicates.resideInAnyPackage("..streamby.backoffice_app.shared.."));

    ArchRule rule =
        ArchRuleDefinition.classes()
            .that()
            .resideInAnyPackage("..streamby.backoffice_app.shared..")
            .should()
            .onlyAccessClassesThat(sharedModuleAccessAllowed);

    rule.allowEmptyShould(true).check(CLASSES);
  }

  @Test
  void sampleModule_shouldNotAccessOtherModules_exceptSharedOrThoughApi() {
    DescribedPredicate<JavaClass> sampleModuleAccessAllowed =
        JavaClass.Predicates.resideOutsideOfPackages("..streamby.backoffice_app..")
            .or(
                JavaClass.Predicates.resideInAnyPackage(
                    "..streamby.backoffice_app.sample..",
                    "..streamby.backoffice_app.shared..",
                    "..streamby.backoffice_app.*.api.."));

    ArchRule rule =
        ArchRuleDefinition.classes()
            .that()
            .resideInAnyPackage("..streamby.backoffice_app.sample..")
            .should()
            .onlyAccessClassesThat(sampleModuleAccessAllowed);

    rule.allowEmptyShould(true).check(CLASSES);
  }
}
