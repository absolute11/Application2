# App2

## Описание

App2 взаимодействует с микросервисом [App1](https://github.com/absolute11/Application-1) для получения информации о пользователях и ролях. Он перенаправляет запросы на App1 и используется для демонстрации межсервисного взаимодействия.

## Технологии

Проект использует следующие технологии:

- **Spring Boot**: основной фреймворк для создания микросервисов.
- **Spring Security**: для обеспечения безопасности и OAuth2 аутентификации.
- **Spring Data JPA**: для работы с базой данных.
- **RestTemplate**: для межсервисного взаимодействия между UserService и App2.
- **JUnit**: для модульного тестирования.

## Сборка и Развертывание

### Требования

- JDK 17
- Maven
- PostgreSQL
- Запущенный экземпляр App1 (инструкции [здесь](https://github.com/absolute11/Application-1))

### Инструкции по Сборке

1. Клонируйте репозиторий App2.
   ```bash
   git clone https://github.com/absolute11/App2.git
   cd App2



 - Убедитесь, что UserService запущен и доступен по адресу http://localhost:8080.

-Обновите application.properties в App2:
user.service.url=http://localhost:8080
-Соберите и запустите App2:
-mvn clean install
-mvn spring-boot:run


## Использование
- **App2 перенаправляет запросы на соответствующие эндпоинты UserService.**
- **GET** /api/users - Перенаправление на /customers UserService
- **GET** /api/users/{email} - Перенаправление на /customers/{email} UserService
- **GET** /api/roles - Перенаправление на /roles UserService
- **GET** /api/roles/{name} - Перенаправление на /roles/{name} UserService

## Контакты
- **email** : den.gitelman@gmail.com
- **tg**: t.me/f0rtunaaz
