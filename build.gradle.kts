buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:8.0.2")
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.3")

    }
}
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    id ("androidx.navigation.safeargs.kotlin") version "2.7.7" apply false

}