Есть REST-сервис, который предоставляет некоторое API.

Хост: kuruma.vaan.io

---
API:
* создать машину - POST /api/v1/cars
пример тела запроса:

```json
{
  "id": 1,
  "color": "black",
  "numberOfWheels": 3
}
```


* найти машину по id - GET /api/v1/cars/\<id>
    * для фильтрации рез-та доступны параметры запроса ([подробнее](https://stackoverflow.com/a/39294675/6040185)) 
        * numberOfWheels 
        * color

* найти все машины - GET /api/v1/cars/
* удалить машину по id - DELETE /api/v1/cars/\<id>

---
Сейчас есть 3 бага.

Что нужно сделать:
* найти все баги
* прислать экспорт конфига для Postman для всех запросов
* прислать команды для curl для всех запросов

---
Что нужно сделать:
* проверить, что исправлены баги
* проверить работу API с фильтрацией - см [ссылку](https://www.vinaysahni.com/best-practices-for-a-pragmatic-restful-api#advanced-queries)
