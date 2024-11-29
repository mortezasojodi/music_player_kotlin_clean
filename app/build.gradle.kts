import java.io.File
import java.io.FileInputStream
import java.util.*

//plugins {
//    id("com.android.application")
//    id("com.google.gms.google-services")
//    id("com.google.firebase.crashlytics")
//    kotlin("android")
//    kotlin("kapt")
//    id("com.google.dagger.hilt.android")
//
//}

plugins {
    alias(libs.plugins.androidApplication)

    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kotlin.serialization)
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    alias(libs.plugins.compose.compiler)
}




android {
    compileSdk = 34

    defaultConfig {
        applicationId = "com.devrunsoft.msamusic"
        minSdk = 24
        targetSdk = 34
        versionCode = 20
        versionName = "0.3.0"
        multiDexEnabled = true
    }

    splits {
        abi {
            reset()
            isUniversalApk = true
        }
    }

    namespace = "com.msa.musicplayercleanarch"


    signingConfigs {


    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isShrinkResources = false
            manifestPlaceholders["appName"] = "MusicPlayer"
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

        }
        getByName("debug") {
            isMinifyEnabled = false
            isShrinkResources = false
            manifestPlaceholders["appName"] = "MusicPlayer"
            signingConfig = signingConfigs.getByName("debug")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    sourceSets.all {
        kotlin.srcDir("src/$name/kotlin")
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }

    kotlinOptions {
        freeCompilerArgs += "-Xcontext-receivers"
        jvmTarget = "1.8"
    }
}

//ksp {
//    arguments {
//        arg("room.schemaLocation", "$projectDir/schemas")
//    }
//}
composeCompiler {
    reportsDestination = layout.buildDirectory.dir("compose_compiler")
//    stabilityConfigurationFile = rootProject.layout.projectDirectory.file("stability_config.conf")
}

dependencies {
    implementation("androidx.multidex:multidex:2.0.1")
    implementation(libs.compose.activity)
    implementation(libs.compose.foundation)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.util)
    implementation(libs.compose.ripple)
    implementation(libs.compose.shimmer)
    implementation(libs.compose.coil)
    implementation(libs.palette)
    implementation(libs.exoplayer)
    implementation(libs.room)
    ksp(libs.room.compiler)
    coreLibraryDesugaring(libs.desugaring)
    implementation(libs.mediafacer)
    implementation(libs.hilt)
    implementation(libs.hilt.compose)
    ksp(libs.hilt.compiler)

}
