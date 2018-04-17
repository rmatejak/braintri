Aplikacja serwerowa udostępniająca REST-owe API umożliwiające zarządzanie listą pracowników fikcyjnej firmy.
Aplikacja umożliwia wykonanie następujących operacji biznesowych:

1. Dodawanie nowego pracownika(imię, nazwisko, stanowisko, adres email).
2. Zwracanie listy wszystkich pracowników z możliwością filtrowania po adresie email, imieniu, nazwisku.
3. Zwracanie listy wszystkich stanowisk razem z ilością pracowników przypisanych do nich.
4. Usuwanie danego pracownika z listy.

Do uruchomienia aplikacji potrzebna jest baza danych MySql oraz odpowiednie skonfigurowanie pliku "application.properties".

URL-e do wykonywania operacji:

1. Dodanie nowego pracownika:

POST http://localhost:8080/api/adduser

{
	"name":"Imie",
	"surname":"Nazwisko",
	"email":"imie_nazwisko@gmail.com",
	"profession":"EMPLOYEE"
}

W polu "profession" podajemy jedną z trzech profesji: "EMPLOYEE", "MANAGER", "DIRECTOR".

2. Zwracanie listy pracowników filtrowanych po atrybucie:

a) Imie

GET http://localhost:8080/api/getallbyname

b) Nazwisko

GET http://localhost:8080/api/getallbysurname

c) Email

GET http://localhost:8080/api/getallbyemail

3. Zwracanie listy stanowisk oraz ilości pracowników przypisanych do nich:

GET http://localhost:8080/api/count/EMPLOYEE

GET http://localhost:8080/api/count/MANAGER

GET http://localhost:8080/api/count/DIRECTOR

W tym podpunkcie miałem problem z napisaniem metody tak jak wymaga polecenie.
Każdy URL jw. zwróci oddzielnie ilość pracowników o danej profesji z bazyd danych.
Dodam jeszcze, że moim pomysłem na wykonanie tej metody było zapytanie SQL-owe "SELECT profession, COUNT(*) FROM user GROUP BY profession;", jednak nie udało mi się tego połączyć, by wyświetlało dane tak jak należy.

4. Usuwanie danego pracownika z listy:

DELETE http://localhost:8080/api/deletebyid/1

Usunięcie pracownika polega na podaniu na końcu URL-a odpowiedniego ID użytkownika z bazy danych.
