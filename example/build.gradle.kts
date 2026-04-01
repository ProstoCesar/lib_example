plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.vanniktech)
    alias(libs.plugins.signing)
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
}

mavenPublishing {
    // Указываем, что публикуем в Maven Central через центральный портал
    publishToMavenCentral()

    // Если нужно подписывать артефакты (обязательно для Central)
    signAllPublications()
    coordinates("io.github.prostocesar", "example", "1.0.1")

    pom {
        name.set("My Library")
        description.set("A description of what my library does.")
        inceptionYear.set("2020")
        url.set("https://github.com/ProstoCesar/lib_example/")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        developers {
            developer {
                id.set("prostocesar")
                name.set("Eugene Sorokin")
                url.set("https://github.com/ProstoCesar/")
            }
        }
        scm {
            url.set("https://github.com/ProstoCesar/lib_example/")
            connection.set("scm:git:git://github.com/ProstoCesar/lib_example.git")
            developerConnection.set("scm:git:ssh://github.com/ProstoCesar/lib_example.git")
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
}