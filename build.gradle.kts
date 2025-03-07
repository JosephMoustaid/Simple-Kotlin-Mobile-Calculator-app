// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
}

// Define extra properties (e.g., Kotlin version) in the `extra` block
extra.apply {
    set("kotlinVersion", "1.9.0")
}