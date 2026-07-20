plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.ksp)
    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.junit5)
}

android {
    namespace = "me.rezapour.domain"
    compileSdk = 37

    defaultConfig {
        minSdk = 24

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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
    }
}



dependencies {
    implementation(libs.androidx.core.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //dagger
    implementation(libs.dagger.hilt.android)
    ksp(libs.dagger.hilt.compiler)

    //coroutines
    implementation(libs.bundles.coroutines)
    testImplementation(libs.kotlinx.coroutines.test)

    //paging
    implementation(libs.androidx.paging.runtime)
    implementation(libs.androidx.paging.common)

    testImplementation(libs.bundles.junit5)
    testRuntimeOnly(libs.junit5.engine)
}