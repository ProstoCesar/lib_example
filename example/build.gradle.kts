plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.maven.publish)
}

android {
    namespace = "ru.lib.example"
    compileSdk = 36

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
}

publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = "ru.lib.example"      // ваши координаты
            artifactId = "example"             // имя библиотеки
            version = "1.0.0"                 // версия
            afterEvaluate {
                from(components["release"])
            }
        }
    }

    repositories {
        maven {
            // Локальный репозиторий
            name = "LocalMaven"
            url = uri("${System.getProperty("user.home")}/.m2/repository")
        }
    }
}