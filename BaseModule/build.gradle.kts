plugins {
    alias(libs.plugins.android.library)
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
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Navigation3
    // Navigation3
    api(libs.androidx.navigation3.ui)
    api(libs.androidx.navigation3.runtime)
    api(libs.androidx.lifecycle.viewmodel.navigation3)
    api(libs.androidx.material3.adaptive.navigation3)
    api(libs.kotlinx.serialization.core)
}