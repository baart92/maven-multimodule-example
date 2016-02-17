# maven-multimodule-example
Prosta aplikacja pokazujaca przykladowe rozbicie na podmoduly api/impl z delikatnym wykorzystaniem technik DDD.


Zbuduj aplikacje i zdeploy'uj wara na tomcat

* http://localhost:8080/order/ GET - podglad jakie ksiazki mamy w zamowieniu. Standardowo przy starcie mamy cormena i podstawy javy ;D
* http://localhost:8080/order/NAZWA/CENA POST - dodanie ksiazki o nazwie NAZWA i cenie CENA (z dokladnoscia do 2 miejsc po przecinku. W odpowiedzi jest zwracane ID dodanej ksiazki
* http://localhost:8080/order/ID DELETE - usuniecie z zamowienia ksiazki o podanym ID
* http://localhost:8080/order/calculate GET - obliczenie wartosci zamowienia. Uwaga: Do sumy cen ksiazek dodawany jest 10% podatek (patrz wartosc w tax.properties). Po wywolaniu tego adresu zamowienie jest czyszczone