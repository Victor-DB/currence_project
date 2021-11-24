                                **Запуск как обычное приложение**

Найти в проекте по пути src/main/com/alfabank/currence_project класс CurrenceProjectApplication и напротив метода main нажать кнопку "Run".

Ввести в браузере ссылку http://localhost:8080/gif и убедиться, что происходит перенаправление на гифку


                                **Запуск через Docker**

Открыть проект в Intellij IDEA

Зайти в терминал

Ввести команду: ./gradlew docker 

Ввести команду: ./gradlew dockerRun

Ввести в браузере ссылку http://localhost:8080/gif и убедиться, что происходит перенаправление на гифку

Для остановки работы приложения ввести в терминале команду: ./gradlew dockerStop