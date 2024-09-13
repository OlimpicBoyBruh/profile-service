## Веб-сервис для работы с учетными записями клиентов

### Описание

Данный веб-сервис предназначен для управления учетными записями клиентов. Он предоставляет функциональность для
создания, чтения и поиска учетных записей по различным полям.

### Функциональность

- **Создание учетной записи**: Возможность создания новой учетной записи клиента с учетом различных правил валидации.
- **Чтение учетной записи**: Получение информации об учетной записи по уникальному идентификатору (id).
- **Поиск учетных записей**: Поиск учетных записей по одним или нескольким полям.

### Поля учетной записи клиента

- id
- bank_id (идентификатор клиента в банке)
- фамилия
- имя
- отчество
- дата рождения
- номер паспорта (вместе с серией в формате ХХХХ ХХХХХХ)
- место рождения
- телефон (в формате 7ХХХХХХХХХХ)
- емейл
- адрес регистрации
- адрес проживания

### Правила валидации

Клиент может быть создан из разных приложений. В зависимости от приложения отличается логика валидации полей при
создании учетной записи. Приложение определяется по обязательному для указания HTTP-заголовку x-Source.

| Приложение | Обязательные поля                                              |
|------------|----------------------------------------------------------------|
| mail       | имя, емейл                                                     |
| mobile     | номер телефона                                                 |
| bank       | bank_id, фамилия, имя, отчество, дата рождения, номер паспорта |
| gosuslugi  | все поля кроме емейла и адреса проживания                      |

### Дополнительные требования

- Код должен быть приспособлен для добавления новых приложений с собственными правилами валидации.
- Основная бизнес-логика должна быть покрыта тестами.

### Технологический стек

- Java 17
- Spring Boot 3+
- Spring Data JPA
- PostgreSQL
- Миграция бд - liquibase
- Maven
- Docker

### Установка и запуск

Для локального запуска сервиса используется Docker Compose.

1. Убедитесь, что у вас установлен Docker и Docker Compose.
2. Клонируйте репозиторий:

   git clone https://github.com/OlimpicBoyBruh/account-service.git

3. Запустите сервис:

   docker-compose up --build

4. Сервис будет доступен по адресу: http://localhost:8585

### Тестирование

Отсутствует
