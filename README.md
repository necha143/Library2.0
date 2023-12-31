# Web App for library2.0

## [Начало данного проекта было заложено здесь](https://github.com/necha143/Library/tree/master) </br>

## Оглавление
* [Главная задача](#главная-задача)
* [Добавленный функционал web-приложения](#функционал-web-приложения)
* [Добавленные страницы web-приложения](#страницы-web-приложения)
* [Используемые технологии](#используемые-технологии)

## Главная задача
Переписать [Project-1](https://github.com/necha143/Library/tree/master) с использованием Hibernate и Spring Data JPA. В вашем проекте не должно быть ни одного SQL запроса. Должны быть реализованы сущности (@Entity) Книга и Человек, репозитории и сервисы. PersonDAO и BookDAO должны быть пустыми и не должны использоваться, вся работа с БД через сервисы. </br>

## Функционал web-приложения
1) Добавлена пагинация для книг. Книг может быть много и они могут не помещаться на одной странице в браузере. Чтобы решить эту проблему, метод контроллера должен уметь выдавать не только все книги разом, но и разбивать выдачу на страницы.
2) Добавлена сортировка книг по году. Метод контроллера должен уметь выдавать книги в отсортированном порядке.
3) Создана страница поиска книг. Вводим в поле на странице начальные буквы названия книги, получаем полное название книги и имя автора. Также, если книга сейчас находится у кого-то, получаем имя этого человека.
4) Добавлена автоматическая проверка на то, что человек просрочил возврат книги.

## Страницы web-приложения
__Страница пользователя (/people/{id})__  
![person](https://github.com/necha143/Library2.0/assets/113212609/25be4ba0-767b-4476-b314-25b95324a407)

</br> </br> 
__Страница поиска (/book/search)__  
![search](https://github.com/necha143/Library2.0/assets/113212609/46916490-c08c-4be0-b102-78bf87f7df85)
![search2](https://github.com/necha143/Library2.0/assets/113212609/e09ba132-a9bf-4d95-ba25-f033aeb321ba)

</br> </br> 
__Страница книг после сортировки (/book?sort_by_year=true)__  
![sort](https://github.com/necha143/Library2.0/assets/113212609/1f06ae9e-fd8a-4acf-b904-a7c5108988d9)

</br> </br> 
__Страница книг после пагинации (/book?page=0&books_per_page=1)__  
![pagination](https://github.com/necha143/Library2.0/assets/113212609/5bb383cf-08c1-42e9-b51d-7ba13d565078)



## Используемые технологии
* Java(JDK 17)
* Spring Framework(5.3.5)
* Hibernate(5.4.28.Final)
* Spring Data JPA(2.4.7)
* Maven
* Thymeleaf(3.0.11.RELEASE)
* Hibernate validator(6.1.6.Final)
* PostgreSQL(42.2.18)
* Tomcat(9.0.80)
