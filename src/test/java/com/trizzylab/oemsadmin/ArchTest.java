package com.trizzylab.oemsadmin;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.trizzylab.oemsadmin");

        noClasses()
            .that()
            .resideInAnyPackage("com.trizzylab.oemsadmin.service..")
            .or()
            .resideInAnyPackage("com.trizzylab.oemsadmin.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..com.trizzylab.oemsadmin.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
