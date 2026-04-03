plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.jetbrains.kotlin.serialization)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.basemodule"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    // Navigation3
    // Navigation3
    api(libs.androidx.navigation3.ui)
    api(libs.androidx.navigation3.runtime)
    api(libs.androidx.lifecycle.viewmodel.navigation3)
    api(libs.androidx.material3.adaptive.navigation3)
    api(libs.kotlinx.serialization.core)
    api(libs.kotlin.reflection)


    // Koin BOM
    api(platform("io.insert-koin:koin-bom:4.2.0"))
    // Core
    api("io.insert-koin:koin-core")
    // Android
    api("io.insert-koin:koin-android")
    // Compose
    api("io.insert-koin:koin-androidx-compose")
    api("io.insert-koin:koin-compose")
    api("io.insert-koin:koin-compose-viewmodel")
    // Ktor
    api("io.insert-koin:koin-ktor")
    // Testing
    testFixturesApi("io.insert-koin:koin-test")
    // koin Annotation
    api("io.insert-koin:koin-annotations:2.3.1")
    //ksp("io.insert-koin:koin-ksp-compiler:2.3.1")
}