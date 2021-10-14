## BCG - Digital Ventures - Challenge 2

1. To run this project in you local:
   1. Import in either IntelliJ Community or IntelliJ Ultimate.
   2. Make sure JDK 1.8 is installed if you want to build.
   3. If Run configuration is empty, you can either manually add Kotlin configuration with main class `com.bcgdv.challenge2.Challenge2ApplicationKt`
   or open file `src/kotlin/com/bcgdv/challenge2/Challenge2Application.kt` and click Play button.
   4. 
2. You can run test in command prompt or terminal by opening cmd or terminal at the root directory of this project, then run
```console
# Windows
mvnw test

# Linux / MacOS
./mvnw test
```

2. View the API request & response sample of the tests [here](./index.html). (You may want to download & view the file in browser.)

## Source code structure
```console
src
|- main/
|  |- kotlin.com.bcgdv.challenge2/
|     |- controllers/
|        |- OrderController.kt
|        |- WatchController.kt
|     |- models/
|        |- Order.kt
|        |- Watch.kt
|     |- repositories/
|        |- OrderRepository.kt
|        |- WatchRepository.kt
|     |- Challenge2Application.kt
|
|- test/
|  |- kotlin.com.bcgdv.challenge2/
|     |- controllerTests/
|        |- OrderControllerTest.kt
|        |- WatchControllerTest.kt
|     |- repositoryTests/
|        |- WatchRepositoryTest.kt
|     |- Challenge2ApplicationTests.kt
```

## Further improvement
1. Add repo tests. Currently `every` doesn't work as I expected so still missing `WatchRepository` test.
2. Have `Item` class which is the parent class of Watch, Jewelry, Phone & other products etc.
3. Have a discount model to handle different discounts at different time period, and different item types.
