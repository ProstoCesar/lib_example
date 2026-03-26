plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.maven.publish)
    alias(libs.plugins.vanniktech)
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
    publishToMavenCentral()
    signAllPublications()

    coordinates(
        "io.github.prostocesar",
        "example",
        "1.0.0"
    )

    pom {
        name.set("example")
        description.set("My Android library")
        url.set("https://github.com/prostocesar/example")

        licenses {
            license {
                name.set("Apache-2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }

        developers {
            developer {
                id.set("prostocesar")
                name.set("Your Name")
                email.set("your.email@example.com")
            }
        }

        scm {
            connection.set("scm:git:git://github.com/ProstoCesar/lib_example.git")
            developerConnection.set("scm:git:ssh://github.com/ProstoCesar/lib_example.git")
            url.set("https://github.com/ProstoCesar/lib_example")
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
}