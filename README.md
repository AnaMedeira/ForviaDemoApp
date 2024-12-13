# ForviaDemoApp
Assignment for Forvia 

## Description
ForviaDemoApp list of Applications from Apptoide, send notification with updates.

## Screenshots and features



## Project architecture
This project draws heavy inspiration from Uncle Bob's clean architecture. It aims to separate business rules from implementation details such as network access, database operations and the user interface towards easier development and maintenance.

The project is split into multiple Gradle modules:

- **domain** Kotlin library that defines the app's purpose (business rules). The App fetch the list of Applications and saves them to some form of history for later access. This module embodies the domain and entities layers. Originally, there was a separate *entities* module, but it only contained a single data class with no business rules of its own, so I removed it to keep things simple.

- **app** Android app module 

  This module also manages dependency injection with Dagger Hilt and it is the only module that does so. This makes it very easy to later switch out the dependency injection framework for Koin or plain Dagger.


## Keywords
The project uses the following Android mechanisms and libraries:
- Jetpack Compose
- Model-View-ViewModel
- Kotlin Coroutines
- Dagger Hilt
- Material Design 3
- Retrofit, OkHttp, Gson
- Room Database
- Clean Architecture
