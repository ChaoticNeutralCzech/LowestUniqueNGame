plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

//    id("com.google.devtools.ksp")  //KSP: Kotlin Symbol Processing replaces KAPT: Kotlin Annotation Processing Tool
}

android {
    namespace = "io.github.chaoticneutralczech.lowestuniquengame"
    compileSdk = 34

    defaultConfig {
        applicationId = "io.github.chaoticneutralczech.lowestuniquengame"
        minSdk = 16 //A4
        targetSdk = 34  // A13
        versionCode = 1
        versionName = "0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        multiDexEnabled = true
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    packaging {
        resources.excludes.add("META-INF/*")
    }
    buildFeatures {
        viewBinding = true
//        dataBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("com.github.androidmads:QRGenerator:1.0.1")
    implementation("io.ktor:ktor-server-netty:1.6.8")
    implementation("io.ktor:ktor-server-core:1.6.8")
    implementation("io.ktor:ktor-gson:1.6.8")
    implementation("io.ktor:ktor-server-sessions:1.6.8")
    implementation("io.ktor:ktor-server-default-headers:2.3.8")
    implementation("io.ktor:ktor-server-websockets:2.3.8")
    /*implementation("io.ktor:ktor-server-routing:2.3.8")
    implementation("io.ktor:ktor-server-application:2.3.8")
    implementation("io.ktor:ktor-server-features:2.3.8")
    implementation("io.ktor:ktor-server-response:2.3.8")*/
    implementation("androidx.multidex:multidex:2.0.1")
    implementation("androidx.fragment:fragment-ktx:1.6.2")
    implementation("androidx.preference:preference-ktx:1.2.1")
    implementation("io.ktor:ktor-server-content-negotiation:2.3.8")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.8")
    //implementation("com.google.code.gson:gson:2.10")
    implementation("io.ktor:ktor-gson:1.6.8")
//    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("androidx.work:work-runtime-ktx:2.9.0")
//    implementation("androidx.lifecycle:lifecycle-extensions-ktx:2.7.0")

}
repositories {
    google()
}
