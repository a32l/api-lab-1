## Технология разработки программного обеспечения

## Лабораторная работа №1: создание микросервиса на Spring Boot с базой данных

## Казанцев Антон Алексеевич, Группа ЗМАС2001

## Цель лабораторной работы: 

Целью лабораторной работы является знакомство с проектированием многослойной архитектуры Web-API (веб-приложений, микро-сервисов). 

В данной лабораторной работе был создан простой микросервис, реализующий CRUD на одной таблице в СУБД PostgreSQL, содержащей каталог смартфонов с перечислением характеристик.

Задание:

1. Создать веб-приложение на Spring Boot, которое будет обращаться к базе данных postgres (таблица catalog содержит каталог смартфонов с перечислением характеристик). Приложение должно иметь слои: model, dao, service, controller.
- Выполнено.
2. Реализовать ендпоинты, которые позволят выполнять CRUD-запросы.
- Выполнено.
3. Реализовать ендпоинт, который будет возвращать hostname.
- Выполнено.
4. Написать Dockerfile.
- Выполнено.
5. Запустить приложение в докере.
- Выполнено.

Отчётность:

1. Настройки подключения к БД в файле<code>./src/main/resources/application.properties</code>. Для создания docker-контейнера с БД использовать команду <code>docker run -e POSTGRES_PASSWORD=pass -p 5432:5432 postgres</code> (получаем login:posgres,password:pass, проброс портов порт_хоста:порт_контейнера,). Для создания таблицы используем команду <code>psql -h hostnamme -p 5432 -U username -d public -f "schema.sql"</code>, для заполнения базы <code>psql -h hostnamme -p 5432 -U username -d public -f "data.sql"</code>. Чтобы узнать внутренний адрес docker-контейнера использовать команду <code>docker inspect -f '{{.Name}} - {{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' $(docker ps -aq)</code>
2. Для сборки проекта в Maven использовать команду <code>mvn package -D maven.test.skip=true</code>.
3. Для сборки docker-образа использовать команду <code> docker build -t antonapi:latest</code>.
4. Для запуска docker-контейнера использовать команду docker run -p 8080:8080 <code>antonapi:latest</code> 
5. Для обращения к эндпоинтам приложения использовать команды: 
<code>curl -X GET http://localhost:8080/api/v1/catalog</code> - получить весь каталог в JSON.
<code>curl -X GET http://localhost:8080/api/v1/catalog/3</code> - получить запись с id №3 в JSON.
<code>curl -X DELETE http://localhost:8080/api/v1/catalog/del/3</code> - удалить запись с id №3 в JSON.
<code>curl -i -H "Accept: application/json" -H "Content-Type:application/json" -X POST --data '{"vendor": "Realme", "model": "7Pro", "cpu": "Snapdragon 720", "ram": 128}' http://localhost:8080/api/v1/catalog</code> - вставить данные в формате JSON в БД.
<code>curl -X GET http://localhost:8080/api/v1/catalog</code> - получить весь каталог в JSON.
<code>curl -X GET http://localhost:8080/api/v1/status</code> - получить hostname.
