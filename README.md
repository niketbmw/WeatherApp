# WeatherApp
This is the simple base project generated for you, so that you can focus more on building the Features, rather than setting up the project.

Few things we have done on the behalf of you 
- Setting up the Clean Architecture 
  - Along with `Usecase`, `Repo` and `Presentation` layers with specific Model data classes
- Setup the DI Graph 
- Setup the Room and Data Store
- Retrofit and the Moshi Serialization setup
- Base Unit Testing


## Some Know Blockers 
- Local Properties SDK Path (It can be different for you)
- Gradle Version, Use the latest Android Studio and opt for the recommendation option to sync project
- We are using latest Kotlin Version, so using `KSP` instead of `Kapt`. 
- Apologies, no Version Catalog being implemented, make sure to take good care of Library Versions you use everywhere.
- By default the project uses Compose, feel free to use XML Layouts 
- 