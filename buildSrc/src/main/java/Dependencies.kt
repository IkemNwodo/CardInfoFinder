
object Versions {
    val kotlin = "1.3.72"
    val compile_sdk = 30
    val target_sdk = 30
    val min_sdk_version = 21
    val build_tools_version = "30.0.2"
    val android_build_tools = "4.0.1"
    val version_code = 1
    val version_name = "1.0"
    val core_ktx = "1.3.2"

    // test libs
    val junit = "4.12"
    val junit_ext = "1.1.1"
    val espresso_core = "3.2.0"

    val coroutines = "1.3.7"
    val retrofit = "2.9.0"
    val constraint_layout = "2.0.4"
    val androidx_app_compact = "1.2.0"
    val hilt_version = "2.31.2-alpha"
    val hilt_jetpack_version = "1.0.0-alpha02"
    val lifecycle_version = "2.2.0"
    val nav_version = "2.3.3"
    val fragment_ktx = "1.2.5"

    val vector_drawable = "1.1.0"

    val material_version = "1.2.1"
    val lifecycle_ext = "2.1.1"
    val room_version = "2.2.5"
    val retrofit_adapter = "0.9.2"
    val legacy_support = "1.0.0"
    val glide_version = "4.11.0"
    val mockito_version = "2.27.0"
    val androidx_core_test = "2.1.0"
    val fragment_version = "1.3.0-alpha06"
    val dex_maker_version = "2.12.1"

    val paycard_version = "1.1.0"
}

object Deps {
    val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    val android_build_tools = "com.android.tools.build:gradle:${Versions.android_build_tools}"
    val androidx_core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
    val androidx_legacy_support = "androidx.legacy:legacy-support-v4:${Versions.legacy_support}"
    val constraint_layout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
    val androidx_app_compact = "androidx.appcompat:appcompat:${Versions.androidx_app_compact}"
    val junit = "junit:junit:${Versions.junit}"
    val junit_ext = "androidx.test.ext:junit:${Versions.junit_ext}"
    val espresso_core = "androidx.test.espresso:espresso-core:${Versions.espresso_core}"
    val vector_drawable = "androidx.vectordrawable:vectordrawable:${Versions.vector_drawable}"
    val kotlin_coroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    val viewmodel_ktx =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_version}"
    val livedata_ktx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle_version}"

    val hilt_android = "com.google.dagger:hilt-android:${Versions.hilt_version}"
    val hilt_android_compiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt_version}"
    val hilt_plugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt_version}"
    val hilt_jetpack_version = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hilt_jetpack_version}"
    val hilt_jetpack_version_compiler = "androidx.hilt:hilt-compiler:${Versions.hilt_jetpack_version}"

    val paycard = "cards.pay:paycardsrecognizer:${Versions.paycard_version}"
    val navigation_fragment_ktx =
        "androidx.navigation:navigation-fragment-ktx:${Versions.nav_version}"
    val navigation_ui_ktx = "androidx.navigation:navigation-ui-ktx:${Versions.nav_version}"
    val fragment_ktx = "androidx.fragment:fragment-ktx:${Versions.fragment_ktx}"
    val material_design = "com.google.android.material:material:${Versions.material_version}"
    val lifecycle_extensions = "android.arch.lifecycle:extensions:${Versions.lifecycle_ext}"
    val room = "androidx.room:room-runtime:${Versions.room_version}"
    val room_ktx = "androidx.room:room-ktx:${Versions.room_version}"
    val room_compiler = "androidx.room:room-compiler:${Versions.room_version}"
    val nav_safe_args =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.nav_version}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofit_converter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val glide = "com.github.bumptech.glide:glide:${Versions.glide_version}"

    val mockito = "org.mockito:mockito-core:${Versions.mockito_version}"
    val coroutine_test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    val androidx_core_test = "androidx.arch.core:core-testing:${Versions.androidx_core_test}"
    val fragment_test = "androidx.fragment:fragment-testing:${Versions.fragment_version}"
    val dex_maker_mockito = "com.linkedin.dexmaker:dexmaker-mockito:${Versions.dex_maker_version}"
    val espresso_idling = "androidx.test.espresso:espresso-idling-resource:${Versions.espresso_core}"
}

