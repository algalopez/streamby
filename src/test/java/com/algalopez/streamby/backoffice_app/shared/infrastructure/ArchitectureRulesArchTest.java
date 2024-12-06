package com.algalopez.streamby.backoffice_app.shared.infrastructure;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import com.tngtech.archunit.library.Architectures;
import org.junit.jupiter.api.Test;

class ArchitectureRulesArchTest {
  private static final JavaClasses CLASSES =
      new ClassFileImporter()
          .importPackages("com.algalopez.streamby.backoffice_app");

  @Test
  void architecture_shouldFollowDependencyRule() {
    Architectures.LayeredArchitecture layeredArchitecture =
        Architectures.layeredArchitecture()
            .consideringAllDependencies()
            .layer("Api")
            .definedBy("..streamby.backoffice_app.*.api..")
            .layer("Application")
            .definedBy("..streamby.backoffice_app.*.application..")
            .layer("Domain")
            .definedBy("..streamby.backoffice_app.*.domain..")
            .layer("Infrastructure")
            .definedBy("..streamby.backoffice_app.*.infrastructure..");

    layeredArchitecture
        .whereLayer("Api")
        .mayOnlyBeAccessedByLayers("Api", "Infrastructure")
        .whereLayer("Application")
        .mayOnlyBeAccessedByLayers("Api", "Application", "Infrastructure")
        .whereLayer("Domain")
        .mayOnlyBeAccessedByLayers("Api", "Application", "Domain", "Infrastructure")
        .whereLayer("Infrastructure")
        .mayOnlyBeAccessedByLayers("Infrastructure");

    layeredArchitecture.check(CLASSES);
  }

  @Test
  void architecture_shouldFollowHexagonalStructure() {
    ArchRule archRule =
        ArchRuleDefinition.noClasses()
            .should()
            .resideOutsideOfPackages(
                "..streamby.backoffice_app.*.api..",
                "..streamby.backoffice_app.*.application..",
                "..streamby.backoffice_app.*.domain..",
                "..streamby.backoffice_app.*.infrastructure..");

    archRule.check(CLASSES);
  }
}
