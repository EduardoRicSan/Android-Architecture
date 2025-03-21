# 📱 Android Clean Architecture with Ktor, Room, and DataStore

This project follows & is Focused on **Clean Architecture + MVVM** in an Android application, leveraging modern technologies such as **Ktor for networking, Room for local persistence, and DataStore for key-value storage**. The architecture is modularized into `app`, `core`, and `feature`, ensuring scalability and maintainability. 


---

## 🚀 **Technologies Used**
- **Kotlin**
- **Ktor Client** → For API communication.
- **Room Database** → For local data storage.
- **DataStore Preferences** → For lightweight key-value storage.
- **Dagger Hilt** → For dependency injection.
- **Jetpack Compose** → For declarative UI.
- **Kotlin Serialization** → For JSON serialization.
- **Coroutines & Flow** → For real-time and asynchronous data handling.
- **Modularization** → Separated into `app`, `core`, and `feature_poetry`.

---

## 📦 Modules Overview  

The project is modularized into **`app`**, **`core`**, and **`feature_*`** modules for better scalability, maintainability, and separation of concerns.  

- **`app/`** → Entry point of the app. Manages navigation, UI setup, and dependency injection.  
- **`core/`** → Shared logic across features, including networking (Ktor), local storage (Room), repositories, domain models, and utilities.  
- **`feature_*`** → Independent feature modules (e.g., `feature_field/`) containing their own UI, ViewModels, use cases, and data sources.  

### 🎯 Why Modular Architecture?  
✅ **Scalability** – Easily add/remove features.  
✅ **Separation of Concerns** – Organized and maintainable code.  
✅ **Code Reusability** – Shared logic in `core/` prevents duplication.  
✅ **Faster Builds** – Only modified modules are recompiled.  

---


## 📂 **Project Structure**
```plaintext
📂 app
   ├── 📂 di                  # Dependency Injection (Dagger Hilt)
   ├── 📂 ui                  # UI using Jetpack Compose
   ├── 📂 navigation          # Navigation between screens
   ├── 📜 MainActivity.kt      # Entry point of the app
   ├── 📜 AppModule.kt        # Hilt module
📂 core
   ├── 📂 network             # Ktor setup and API Service
   ├── 📂 data                # Data layer: Repositories and Data Sources
   ├── 📂 domain              # Business logic and Use Cases
   ├── 📂 util                # Utility classes and helpers
📂 feature_poetry
   ├── 📂 data                # Field-related repositories & data sources
   ├── 📂 domain              # Field use cases and models
   ├── 📂 ui                  # Field-related UI components
📂 database
   ├── 📜 AppDatabase.kt      # Room database setup
   ├── 📜 FieldDao.kt         # DAO for managing fields in Room
📂 datastore
   ├── 📜 DataStoreModule.kt  # Hilt module for DataStore
   ├── 📜 GenericDataStore.kt # Generic class for saving data
   ├── 📜 DataStoreKeys.kt    # Preference keys
