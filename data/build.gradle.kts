plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlin.ksp)
    alias(libs.plugins.parcelize) //To pass complex data between screens
}

android {
    namespace = "com.forvia.domain"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
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

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }


    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    //Fora
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    // Network
    implementation(libs.serialization)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter)
    implementation(libs.okHttp)
    implementation(libs.androidx.junit.ktx)
    implementation(libs.androidx.adapters)
    implementation(libs.runner)

    //dependency injection
    ksp(libs.dagger.hilt.compiler)
    implementation(libs.dagger.hilt.android)

    //persistence
    implementation(libs.android.room.ktx)
    implementation(libs.android.room.runtime)
    ksp(libs.android.room.compiler) //better performance that kapt

    //test
    testImplementation(libs.junit)
    testImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    testImplementation(libs.android.coroutines.test)
    testImplementation(libs.android.coroutines.core.jvm)
    testImplementation(libs.android.coroutines.core)
    testImplementation(libs.dagger.hilt.android.test)
    kspTest(libs.dagger.hilt.compiler.test)
    testImplementation(libs.mockwebserver)
}