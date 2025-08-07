# Project Name: Compose Navigation 3 With Bottom Navigation

This project demonstrates the use of the **Navigation 3 library** for implementing navigation within an Android application, specifically showcasing a **Bottom Navigation** pattern. It leverages Kotlinx Serialization for type-safe argument passing between destinations.

## Features

*   **Navigation 3:** Utilizes the latest iteration of the Android Jetpack Navigation library for robust and structured navigation.
*   **Bottom Navigation:** Implements a common UI pattern using `BottomNavigationView` (or a Composable equivalent if using Jetpack Compose for UI) integrated with the Navigation 3 controller.
*   **Type-Safe Navigation with Kotlinx Serialization:** Demonstrates how to define navigation routes and pass arguments between screens in a type-safe manner using `kotlinx.serialization`. This helps prevent runtime errors and improves code maintainability.
*   **ViewModel Integration:** Shows how to scope ViewModels to navigation graphs or individual destinations using `androidx.lifecycle.viewmodel.navigation3`.

## Core Libraries Used

This project relies on the following key libraries:

*   **`androidx.navigation:navigation-runtime-ktx` (`libs.androidx.navigation3.runtime`):** The core runtime library for Navigation 3.
*   **`androidx.navigation:navigation-ui-ktx` (`libs.androidx.navigation3.ui`):** Provides UI components and helpers for integrating Navigation 3 with common Android UI widgets like `BottomNavigationView`, `Toolbar`, etc.
*   **`androidx.lifecycle:lifecycle-viewmodel-navigation3` (`libs.androidx.lifecycle.viewmodel.navigation3`):** Enables easy integration of ViewModels with the Navigation 3 component, allowing ViewModels to be scoped to navigation graphs.
*   **`org.jetbrains.kotlinx:kotlinx-serialization-core` (`libs.kotlinx.serialization.core`):** (Typically you'd use `kotlinx-serialization-json` for practical serialization, but `core` is the base). Used here to define serializable data classes for type-safe navigation arguments.
    *   **Note:** For full type-safe argument passing with Navigation 3, you'd usually also need `org.jetbrains.kotlinx:kotlinx-serialization-json` and the Kotlin serialization plugin (`org.jetbrains.kotlin.plugin.serialization`).
